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

	private Context context;
	private ConnectionFactory factory;
	private Connection connection;
	private Session session;
	private Destination queue;
	private MessageProducer messageProducer;
	private MessageConsumer messageConsumer;
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String userEmail = request.getParameter("userEmail");
		
		request.setAttribute("userEmail", userEmail);
		
		if(type == null){
			
			request.setAttribute("messages", this.readFromQueue(userEmail));
			
		} else {
			
			if(type.equals("write")){
				
				request.setAttribute("sendSuccess", this.writeToQueue(userEmail, request.getParameter("msg")));
				
			}
			else if(type.equals("read")){
				
				request.setAttribute("messages", this.readFromQueue(userEmail));
			
			}
			
		}
		return "chat.jsp";
	}
	
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
			message.setJMSCorrelationID("admin-"+email);
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
	
	private StringBuffer readFromQueue (String email){
		
		StringBuffer messageBuffer = new StringBuffer(64);
		
		try {
			
			this.context = new InitialContext();
			
			this.factory = (ConnectionFactory) this.context.lookup("jms/tiw");
			
			this.queue = (Destination) this.context.lookup("jms/queuetiw");
			
			this.connection = this.factory.createConnection();
			
			this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			this.messageConsumer = this.session.createConsumer(this.queue, "JMSCorrelationID = '"+email+"-admin'");
			
			this.connection.start();
			
			Message message;
			
			while(true){
				
				message = messageConsumer.receive(1);
				
				if(message != null){
					if(message instanceof TextMessage){
						TextMessage msg = (TextMessage) message;
						Date date = new Date(msg.getJMSTimestamp());
						SimpleDateFormat formatter = new SimpleDateFormat("E dd.MM.yyyy hh:mm:ss a");
						messageBuffer.append(formatter.format(date)+" | "+email+" : "+msg.getText()+"<br>");
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
