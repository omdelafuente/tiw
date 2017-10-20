package es.uc3m.tiw.controller;

import es.uc3m.tiw.model.*;
import java.io.IOException;
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
		

		ArrayList<String> errorRegister = new ArrayList<String>();
		boolean registerSuccess = true;
		
		UserBean user = new UserBean(name,surname,password,email);
		
		//user data validation
		
		if(!password.equals(checkPassword)){
			
			registerSuccess = false;
			errorRegister.add("La contrase�a y la confirmaci�n deben coincidir.");
			
		}
		if(password.length() < 6){
			
			registerSuccess = false;
			errorRegister.add("La contrase�a debe tener m�nimo 6 n�meros o letras.");
			
		}
		
		if(!name.matches("[a-zA-Z]+") || !surname.matches("[a-zA-Z]+")){
			
			registerSuccess = false;
			errorRegister.add("Los nombres y apellidos solo pueden contener letras.");
		}
		
		
		//insert user into database
		
		if(registerSuccess){
			UserDAO registerDAO = new UserDAO();
			
			if(registerDAO.readUser(email) != null){
				
				registerSuccess = false;
				errorRegister.add("Ya existe una cuenta con esa direcci�n de correo, por favor use otra.");
				
			}else {
			
				registerDAO.insertUser(user);
			}
		}
		
		request.setAttribute("registerSuccess", registerSuccess);
		
		if(registerSuccess){
			return "login.jsp";
		} else {
			
			request.setAttribute("errorRegister", errorRegister);
			return "register.jsp";
		}
		
		
		
	}

}
