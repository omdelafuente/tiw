package es.uc3m.tiw.controller;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Usr;

public class ChatHandler implements IRequestHandler {

	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		try {
		
			Context context = new InitialContext();
			
			//recuperamos la QueueConnectionFactory
		
			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("jms/tiw");
			
			//creamos la QueueConnection
			
			QueueConnection connection = factory.createQueueConnection();
			
			//iniciamos la conexión
			
			connection.start();
			
			//creamos una sesión
			
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//recuperamos la cola
			
			MessageProducer messageProducer = session.createProducer((Queue)context.lookup("jms/queuetiw"));
			
			//envíamos mensajes a la cola
			
			TextMessage message = session.createTextMessage();
			message.setText(request.getParameter("msg"));
			message.setJMSCorrelationID(((Usr)request.getSession().getAttribute("loggedUser")).getEmail());
			messageProducer.send(message);
			
			messageProducer.close();
			session.close();
			connection.close();
		
			
		} catch (Exception e) {
			
			System.out
			.println("JHC *************************************** Error Exception: "
					+ e.getMessage());
		}
		*/
		return null;
	}

}
