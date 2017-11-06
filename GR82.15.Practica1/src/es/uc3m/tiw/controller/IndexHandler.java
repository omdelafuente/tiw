package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import es.uc3m.tiw.model.Event;
import es.uc3m.tiw.model.EventManager;

public class IndexHandler implements IRequestHandler {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		
		List<Event> events = manager.findAll();
		List<Event> eventsToShow = new ArrayList<Event>();
		
		List<Integer> randomNums = ThreadLocalRandom.current().ints(0,events.size()).distinct().limit(9).boxed().collect(Collectors.toList());
		
		for(int i = 0; i < randomNums.size(); i++){			
			eventsToShow.add(events.get(randomNums.get(i)));		
		}
		
		request.setAttribute("events", eventsToShow);
		return "index.jsp";
	}

}
