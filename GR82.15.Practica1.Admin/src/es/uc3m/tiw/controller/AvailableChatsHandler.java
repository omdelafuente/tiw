package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Usr;
import es.uc3m.tiw.model.UsrManager;

public class AvailableChatsHandler implements IRequestHandler {

	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
		
		UsrManager manager = new UsrManager();
		manager.setEntityManagerFactory(factory);
		
		List<Usr> users = manager.findUsersWithCreatedEvents();
		
		if(users.isEmpty()){
			request.setAttribute("noUsers", true);
		}else {
			request.setAttribute("users", users);	
		}		
		
		return "availableChats.jsp";
	}

}
