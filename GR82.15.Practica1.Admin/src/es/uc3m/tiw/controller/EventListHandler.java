package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Event;
import es.uc3m.tiw.model.EventManager;

public class EventListHandler implements IRequestHandler{

	@Override
	//devuelve la lista de eventos creados
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		
		List<Event> events = manager.findAll();
		
		if(events.isEmpty())
			request.setAttribute("noEvents",true);
		else 
			request.setAttribute("events", events);
		
		return "events.jsp";
	}

}
