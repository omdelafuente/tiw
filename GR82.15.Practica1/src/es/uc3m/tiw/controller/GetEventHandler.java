package es.uc3m.tiw.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.*;

public class GetEventHandler implements IRequestHandler {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		Event event;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		event = manager.findEventByID(id);
		
		request.setAttribute("event", event);
		
		if(type != null){				
			if(type.equals("editEvent")){
				return "editEvent.jsp";
			} else if(type.equals("buyTicket")) {
				
				if(event.getCreator().equals(request.getSession().getAttribute("loggedUser"))){
					request.setAttribute("cannotBuy", true);
				} else {				
					return "buyTicket.jsp";
				}
			}
		}
		return "event.jsp";

	}

}
