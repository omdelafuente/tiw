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


public class SearchHandler implements IRequestHandler {
	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		
		//advanced search
		if(type.equals("advanced")){
			
			
		}
		
		//simple search
		else if(type.equals("simple")){
			
			String value = request.getParameter("search");
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
			
			EventManager manager = new EventManager();
			manager.setEntityManagerFactory(factory);
			
			List<Event> events = manager.findEventsMatchingString(value);
			request.setAttribute("events", events);
			
		}
		
		return "searchResults.jsp";
	}

}
