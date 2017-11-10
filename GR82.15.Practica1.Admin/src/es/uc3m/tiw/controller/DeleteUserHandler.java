package es.uc3m.tiw.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Usr;
import es.uc3m.tiw.model.UsrManager;

public class DeleteUserHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
		
		UsrManager manager = new UsrManager();
		manager.setEntityManagerFactory(factory);
		
		Usr user = manager.findUserByEmail(request.getParameter("email"));
		
		if(request.getParameter("type") != null){
			
			request.setAttribute("user", user);
			return "deleteUser.jsp";
			
		}else {
			
			Usr updatedUser = user;
			updatedUser.setActive(false);
			
			try {
				manager.updateUser(updatedUser);
			} catch (Exception e){
				System.out.println("Descripcion: " + e.getMessage());
			}
			return "/users";
		}		
		
	}

}
