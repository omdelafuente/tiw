package es.uc3m.tiw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Event;
import es.uc3m.tiw.model.EventManager;
import es.uc3m.tiw.model.Usr;
import es.uc3m.tiw.model.UsrManager;

public class ChatHandler implements IRequestHandler {

	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		Usr user = (Usr)request.getSession().getAttribute("loggedUser");
		
		if(type == null){
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
			
			UsrManager manager = new UsrManager();
			manager.setEntityManagerFactory(factory);
			
			List<Usr> users = manager.findUsersWithCreatedEvents();
			
			request.setAttribute("users", users);		
			
		}
		else {
		
		
			Context context;
			ConnectionFactory factory;
			Connection connection;
			Session session;
			Destination queue;
			MessageProducer messageProducer;
			MessageConsumer messageConsumer;
			
			if(type.equals("write")){
				
				try {
					
					context = new InitialContext();
					
					//recuperamos la QueueConnectionFactory
					factory = (ConnectionFactory) context.lookup("jms/tiw");
					
					//recuperamos la cola
					queue = (Destination) context.lookup("jms/queuetiw");
					
					//creamos la QueueConnection			
					connection = factory.createConnection();
					
					//iniciamos la conexi�n
					connection.start();
					
					//creamos una sesi�n
					session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					
					messageProducer = session.createProducer(queue);
					
					//env�amos mensajes a la cola
					
					TextMessage message = session.createTextMessage();
					message.setText(request.getParameter("msg"));
					message.setJMSCorrelationID(user.getEmail());
					messageProducer.send(message);
					
					messageProducer.close();
					session.close();
					connection.close();
				
					
				} catch (Exception e) {
					
					System.out
					.println("JHC *************************************** Error Exception: "
							+ e.getMessage());
				}
				
			}
			else if(type.equals("read")){
				
				StringBuffer messageBuffer = new StringBuffer(64);
				
				try {
					
					context = new InitialContext();
					
					factory = (ConnectionFactory) context.lookup("jms/tiw");
					
					queue = (Destination) context.lookup("jms/queuetiw");
					
					connection = factory.createConnection();
					
					session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					
					messageConsumer = session.createConsumer(queue, "JMSCorrelationID = '"+user.getEmail()+"'");
					
					connection.start();
					
					Message message;
					
					while(true){
						
						message = messageConsumer.receive(1);
						
						if(message != null){
							if(message instanceof TextMessage){
								TextMessage msg = (TextMessage) message;
								Date date = new Date(msg.getJMSTimestamp());
								SimpleDateFormat formatter = new SimpleDateFormat("E dd.MM.yyyy hh:mm:ss a");
								messageBuffer.append(formatter.format(date)+" | "+msg.getJMSCorrelationID()+" : "+msg.getText()+"<br>");
							}
						}
						else {
							if(messageBuffer.length() == 0){
								messageBuffer.append("No tienes ning�n mensaje.");
							}
							break;
						}
					}
					
					messageConsumer.close();
					session.close();
					connection.close();
					
					request.setAttribute("messages", messageBuffer);
				
				
				} catch (Exception e){
	
				System.out
				.println("JHC *************************************** Error Exception: "
						+ e.getMessage());
				}
			
			}
			
		}
		return "chat.jsp";
	}

}
