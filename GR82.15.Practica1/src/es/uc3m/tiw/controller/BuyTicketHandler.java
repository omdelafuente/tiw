package es.uc3m.tiw.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.*;

public class BuyTicketHandler implements IRequestHandler  {

	@Override
	//compra de entradas para un evento
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		
		EventManager manager = new EventManager();
		manager.setEntityManagerFactory(factory);
		Event event = manager.findEventByID(id);
		
		if(request.getParameter("buy") == null){
				
			request.setAttribute("event", event);
			//si el usuario que intenta comprar es el que ha creado el evento, no puede
			if(event.getCreator().equals(request.getSession().getAttribute("loggedUser"))){
				request.setAttribute("cannotBuy", true);
				return "event.jsp";
			} else {				
				return "buyTicket.jsp";
			}
		}
		else {	
			
			int availableTickets = event.getAvailableTickets();
			Usr client = (Usr)request.getSession().getAttribute("loggedUser");
			int tickets = Integer.parseInt(request.getParameter("tickets"));
			int newTickets = availableTickets - tickets;
			
			//se verifica que haya entradas disponibles y se modifican las entradas que quedan
			
			if(newTickets < 0){
				
				request.setAttribute("purchaseSuccess", false);
				request.setAttribute("event", event);
				return "buyTicket.jsp";
				
			} else {
				
				if(newTickets == 0){
					event.setState("Completo");
				}
				
				event.setAvailableTickets(newTickets);
				try {
					manager.updateEvent(event);
				} catch (Exception e){
					System.out.println("Descripcion: " + e.getMessage());
				}
				
				Purchase purchase = new Purchase();
				purchase.setClient(client);
				purchase.setEvent(event);
				purchase.setTickets(tickets);
				
				PurchaseManager pManager = new PurchaseManager();
				pManager.setEntityManagerFactory(factory);
				
				try {
					pManager.createPurchase(purchase);
				} catch (Exception e){
					System.out.println("Descripcion: " + e.getMessage());
				}
				
				request.setAttribute("purchaseSuccess", true);
				return "index";
				
			}
			
			
		}
		
		
	}
}
