package es.uc3m.tiw.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import es.uc3m.tiw.model.*;

public class CreateEventHandler implements IRequestHandler {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		Part filePart = request.getPart("image");
		byte[] image = new byte[(int) filePart.getSize()];
	    filePart.getInputStream().read(image, 0, image.length);
	    BigDecimal price = new BigDecimal(request.getParameter("price"));
	    String inputDate = request.getParameter("date"); 
	    LocalDateTime date = null;
	    try {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	    	date = LocalDateTime.parse(inputDate, formatter);
	    }
	    catch(DateTimeParseException exc){
	    	System.out.println(exc.getMessage());
	    }
	    String place = request.getParameter("place");
	    String description = request.getParameter("description");
	    int availableTickets = Integer.parseInt(request.getParameter("availableTickets"));
	    Usr creator = (Usr)request.getSession().getAttribute("loggedUser");
		
	    
	    
		Event newEvent = new Event();
		newEvent.setTitle(title);
		newEvent.setCategory(category);
		newEvent.setImage(image);
		newEvent.setPrice(price);
		newEvent.setEventDate(date);
		newEvent.setPlace(place);
		newEvent.setDescription(description);
		newEvent.setAvailableTickets(availableTickets);
		newEvent.setState("Disponible");
		newEvent.setCreator(creator);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		try {
			manager.createEvent(newEvent);
		} catch (Exception e){
			System.out.println("Descripcion: " + e.getMessage());
		}
		
		return "event?id="+newEvent.getId();
	}

}
