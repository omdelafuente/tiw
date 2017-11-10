package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.*;

public class PurchasedTicketsHandler  implements IRequestHandler  {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Usr user = (Usr) request.getSession().getAttribute("loggedUser");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1");
		
		PurchaseManager manager = new PurchaseManager();
		manager.setEntityManagerFactory(factory);
		
		List<Purchase> purchases = manager.findPurchasesByUser(user);
		
		request.setAttribute("purchases", purchases);
		return "purchasedTickets.jsp";
	}

}
