package es.uc3m.tiw.controller;

import es.uc3m.tiw.model.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterHandler implements IRequestHandler {

	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("psw");
		String email = request.getParameter("email");
		

		String errorMessage = null;
		boolean success = true;
		
		UserBean user = new UserBean(name,surname,password,email);
		
		UserDAO registerDAO = new UserDAO();
		
		
		try {
			
			registerDAO.insertUser(user);
			
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				if(sqlException.getErrorCode() == 1062){
					
					success = false;
					errorMessage = "Ya existe una cuenta con esa dirección de correo, por favor use otra.";
					
				}
				sqlException = sqlException.getNextException();
			}
			
		}
		
		if(success){
			return "index.jsp";
		} else {
			
			request.setAttribute("success", success);
			request.setAttribute("errorMessage", errorMessage);
			return "register.jsp";
		}
		
		
		
	}

}
