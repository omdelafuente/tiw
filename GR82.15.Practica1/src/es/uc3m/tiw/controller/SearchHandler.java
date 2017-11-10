package es.uc3m.tiw.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Event;
import es.uc3m.tiw.model.EventManager;


public class SearchHandler implements IRequestHandler {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		
		List<Event> retrievedEvents = null;
		
		//advanced search
		if(type.equals("advanced")){
			
			String title = request.getParameter("title");
			String category = request.getParameter("category");
			String place = request.getParameter("place");
			String description = request.getParameter("description");
			String state = request.getParameter("state");
			BigDecimal priceMin = null;
			BigDecimal priceMax = null;
			if(!request.getParameter("priceMin").isEmpty()){
				priceMin = new BigDecimal(request.getParameter("priceMin"));
			}
			if(!request.getParameter("priceMax").isEmpty()){
				priceMax = new BigDecimal(request.getParameter("priceMax"));
			}
			LocalDateTime dateMin = null;
			LocalDateTime dateMax = null;
			try {
		    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    	if(!request.getParameter("dateMin").isEmpty()){
		    		LocalDate dateMinAux =  LocalDate.parse(request.getParameter("dateMin"), formatter);;
		    		dateMin = dateMinAux.atStartOfDay();
		    	}
		    	if(!request.getParameter("dateMax").isEmpty()){
		    		LocalDate dateMaxAux = LocalDate.parse(request.getParameter("dateMax"), formatter);
		    		dateMax = dateMaxAux.atStartOfDay();
		    	}
		    }
		    catch(DateTimeParseException exc){
		    	System.out.println(exc.getMessage());
		    }
			
			retrievedEvents = manager.findEventsByMultipleFields(title,category,place,description,state,priceMin,priceMax,dateMin,dateMax);

		}
		
		//simple search
		else if(type.equals("simple")){		
			String value = request.getParameter("search");	
			
			retrievedEvents = manager.findEventsMatchingString(value);		
		}
		
		request.setAttribute("events", retrievedEvents);
		return "searchResults.jsp";
	}

}
