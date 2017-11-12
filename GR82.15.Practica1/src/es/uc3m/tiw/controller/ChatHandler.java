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

public class ChatHandler implements IRequestHandler {
	
	private Context context;
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Destination queue;
	private MessageProducer messageProducer;
	private MessageConsumer messageConsumer;

	@Override
	//chat entre usuario y administrador mediante JMS
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		Usr user = (Usr)request.getSession().getAttribute("loggedUser");
		
		//si type no existe se está accediendo al chat
		if(type == null){
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
			
			EventManager manager = new EventManager();
			manager.setEntityManagerFactory(factory);
			
			List<Event> events = manager.findEventsByCreator(user);
			
			if(events.isEmpty()){
				request.setAttribute("creator", false);
			}
			else {					
				request.setAttribute("messages", this.readFromQueue(user.getEmail()));
			}
			
		}
		//si type existe, se ha solicitado leer/escribir en la cola
		else {
		
			if(type.equals("write")){
				
				request.setAttribute("sendSuccess", this.writeToQueue(user.getEmail(), request.getParameter("msg")));
				
			}
			else if(type.equals("read")){
				
				request.setAttribute("messages", this.readFromQueue(user.getEmail()));
			
			}
			
		}
		return "chat.jsp";
	}
	
	//escritura de un mensaje en la cola
	private boolean writeToQueue(String email, String msg){
		
		try {
			
			this.context = new InitialContext();

			this.factory = (ConnectionFactory) this.context.lookup("jms/tiw");
			
			this.queue = (Destination) this.context.lookup("jms/queuetiw");
	
			this.connection = this.factory.createConnection();

			this.connection.start();

			this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			this.messageProducer = this.session.createProducer(this.queue);
			
			TextMessage message = this.session.createTextMessage();
			message.setText(msg);
			message.setJMSCorrelationID(email+"-admin");
			messageProducer.send(message);
			
			messageProducer.close();
			session.close();
			connection.close();
			
			return true;
		
			
		} catch (Exception e) {
			
			System.out
			.println("JHC *************************************** Error Exception: "
					+ e.getMessage());
			return false;
		}
	}
	
	//lectura de los mensajes de la cola
	private StringBuffer readFromQueue (String email){
		
		StringBuffer messageBuffer = new StringBuffer(64);
		
		try {
			
			this.context = new InitialContext();
			
			this.factory = (ConnectionFactory) this.context.lookup("jms/tiw");
			
			this.queue = (Destination) this.context.lookup("jms/queuetiw");
			
			this.connection = this.factory.createConnection();
			
			this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			this.messageConsumer = this.session.createConsumer(this.queue, "JMSCorrelationID = 'admin-"+email+"'");
			
			this.connection.start();
			
			Message message;
			
			while(true){
				
				message = messageConsumer.receive(1);
				
				if(message != null){
					if(message instanceof TextMessage){
						TextMessage msg = (TextMessage) message;
						Date date = new Date(msg.getJMSTimestamp());
						SimpleDateFormat formatter = new SimpleDateFormat("E dd.MM.yyyy hh:mm:ss a");
						messageBuffer.append(formatter.format(date)+" | admin : "+msg.getText()+"<br>");
					}
				}
				else {
					if(messageBuffer.length() == 0){
						messageBuffer.append("No tienes ningún mensaje.");
					}
					break;
				}
			}
			
			messageConsumer.close();
			session.close();
			connection.close();
		
		} catch (Exception e){

		System.out
		.println("JHC *************************************** Error Exception: "
				+ e.getMessage());
		}

		return messageBuffer;
	}

}
