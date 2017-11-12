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
import es.uc3m.tiw.model.Purchase;
import es.uc3m.tiw.model.PurchaseManager;

public class SoldTicketsHandler implements IRequestHandler {

	@Override
	//devuelve la lista de entradas que se han vendido para un evento
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int eventId = Integer.parseInt(request.getParameter("id"));
		Event event; 
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		
		event = manager.findEventByID(eventId);
		
		PurchaseManager pManager = new PurchaseManager();
		pManager.setEntityManagerFactory(factory);
		
		List<Purchase> purchases = pManager.findPurchasesByEvent(event);
		
		request.setAttribute("purchases", purchases);
		return "soldTickets.jsp";
	}

}
