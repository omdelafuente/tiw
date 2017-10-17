package es.uc3m.tiw.controller;

import es.uc3m.tiw.model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterHandler implements IRequestHandler {

	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("psw");
		String checkPassword = request.getParameter("checkpsw");
		String email = request.getParameter("email");
		

		ArrayList<String> errorMessages = new ArrayList<String>();
		boolean success = true;
		
		UserBean user = new UserBean(name,surname,password,email);
		
		//user data validation
		
		if(!password.equals(checkPassword)){
			
			success = false;
			errorMessages.add("La contraseña y la confirmación deben coincidir.");
			
		}
		if(password.length() < 6){
			
			success = false;
			errorMessages.add("La contraseña debe tener mínimo 6 números o letras.");
			
		}
		
		if(!name.matches("[a-zA-Z]+") || !surname.matches("[a-zA-Z]+")){
			
			success = false;
			errorMessages.add("Los nombres y apellidos solo pueden contener letras.");
		}
		
		
		//insert user into database
			
		UserDAO registerDAO = new UserDAO();
			
		if(registerDAO.readUser(email) == null){
				
			success = false;
			errorMessages.add("Ya existe una cuenta con esa dirección de correo, por favor use otra.");
				
		}else {
			
			registerDAO.insertUser(user);
		}
		
		request.setAttribute("success", success);
		
		if(success){
			return "login.jsp";
		} else {
			
			request.setAttribute("errorMessages", errorMessages);
			return "register.jsp";
		}
		
		
		
	}

}
