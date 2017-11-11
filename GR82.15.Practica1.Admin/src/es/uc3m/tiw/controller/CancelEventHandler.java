package es.uc3m.tiw.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Event;
import es.uc3m.tiw.model.EventManager;

public class CancelEventHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		
		Event eventToCancel = manager.findEventByID(id);
		
		if(request.getParameter("type") != null){
			
			request.setAttribute("event", eventToCancel);
			return "cancelEvent.jsp";
			
		} else {
			
			eventToCancel.setState("Cancelado");
			
			try {
				manager.updateEvent(eventToCancel);
			} catch (Exception e){
				System.out.println("Descripcion: " + e.getMessage());
			}
			
			return "/events";
			
		}
	}

}
