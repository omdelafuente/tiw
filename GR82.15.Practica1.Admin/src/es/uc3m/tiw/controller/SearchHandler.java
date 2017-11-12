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
import es.uc3m.tiw.model.Usr;
import es.uc3m.tiw.model.UsrManager;

public class SearchHandler implements IRequestHandler{
	
	@Override
	//realiza una búsqueda en los eventos y los usuarios
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String value = request.getParameter("search");	
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
		
		EventManager emanager = new EventManager();
		emanager.setEntityManagerFactory(factory);
		UsrManager umanager = new UsrManager();
		umanager.setEntityManagerFactory(factory);
		
		List<Event> retrievedEvents = null;
		List<Usr> retrievedUsers = null;
		
		retrievedEvents = emanager.findEventsMatchingString(value);
		retrievedUsers = umanager.findUsersMatchingString(value);
		
		request.setAttribute("users", retrievedUsers);
		request.setAttribute("events", retrievedEvents);
		return "searchResults.jsp";
	}

}
