package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.*;

public class LoginHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = "admin@admin.com";
		String password = request.getParameter("psw");
		
		String errorLogin = null;
		boolean loginSuccess = true;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
		UsrManager manager = new UsrManager();
		manager.setEntityManagerFactory(factory);
		Usr user = manager.findUserByEmail(email);
		
		if(!user.getPassword().equals(password)){
				
				loginSuccess = false;
				errorLogin = "La contraseña introducida es incorrecta.";
				
		}
		
		request.setAttribute("loginSuccess", loginSuccess);
		
		if(loginSuccess){
			request.getSession().setAttribute("loggedUser", user);
			return "index.jsp";
		}
		
		else{
			request.setAttribute("errorLogin", errorLogin);
			return "login.jsp";
		}
			
	}

}
