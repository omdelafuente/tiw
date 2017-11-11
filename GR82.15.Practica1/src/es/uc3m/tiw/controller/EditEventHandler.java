package es.uc3m.tiw.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import es.uc3m.tiw.model.Event;
import es.uc3m.tiw.model.EventManager;

public class EditEventHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String place = request.getParameter("place");
	    String description = request.getParameter("description");
	    BigDecimal price = null;
	    if(!request.getParameter("price").isEmpty()){
			price = new BigDecimal(request.getParameter("price"));
		}
	    int availableTickets = 0;
	    
	    if(!request.getParameter("availableTickets").isEmpty()){
	    	availableTickets = Integer.parseInt(request.getParameter("availableTickets"));
	    }
	    
		String inputDate = request.getParameter("date"); 
	    LocalDateTime date = null;
	    try {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	    	if(!request.getParameter("date").isEmpty()){
	    		date = LocalDateTime.parse(inputDate, formatter);
	    	}    	
	    }
	    catch(DateTimeParseException exc){
	    	System.out.println(exc.getMessage());
	    }
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		
		Event eventToUpdate = manager.findEventByID(id);
		
		if(request.getPart("image") != null){
			Part filePart = request.getPart("image");
			byte[] image = new byte[(int) filePart.getSize()];
		    filePart.getInputStream().read(image, 0, image.length);
		    eventToUpdate.setImage(image);
		}
		
		if(!title.isEmpty() && !title.equals(eventToUpdate.getTitle())){
			eventToUpdate.setTitle(title);
		}
		
		if(!place.isEmpty() && !place.equals(eventToUpdate.getPlace())){
			eventToUpdate.setPlace(place);
		}
		
		if(price != null && !price.equals(eventToUpdate.getPrice())){
			eventToUpdate.setPrice(price);
		}

		if(!description.isEmpty() && !description.equals(eventToUpdate.getDescription())){
			eventToUpdate.setDescription(description);
		}
		
		if(date != null && !date.equals(eventToUpdate.getEventDate())){
			eventToUpdate.setEventDate(date);
		}
		
		if(availableTickets != 0 && availableTickets != eventToUpdate.getAvailableTickets()){
			eventToUpdate.setAvailableTickets(availableTickets);
		}	
		
		try {
			manager.updateEvent(eventToUpdate);
		} catch (Exception e){
			System.out.println("Descripcion: " + e.getMessage());
		}
		
		return "myCreatedEvents";
	}

}
