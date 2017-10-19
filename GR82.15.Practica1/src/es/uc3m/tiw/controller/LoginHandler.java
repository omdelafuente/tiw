package es.uc3m.tiw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.*;

public class LoginHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		ArrayList<String> errorLogin = new ArrayList<String>();
		boolean loginSuccess = true;
		
		UserDAO loginDAO = new UserDAO();
		
		UserBean user = loginDAO.readUser(email);
		
		if(user == null){
			
			loginSuccess = false;
			errorLogin.add("No se encontró ninguna cuenta con ese e-mail, por favor regístrate si no lo has hecho o introduce una cuenta existente.");
		} else {
			
			if(!user.getPassword().equals(password)){
				
				loginSuccess = false;
				errorLogin.add("La contraseña introducida es incorrecta.");
				
			}
			
		}
		
		request.setAttribute("loginSuccess", loginSuccess);
		
		if(loginSuccess){
			
			request.getSession().setAttribute("loggedUser", user);
			return "index.jsp";
		} else {
			
			request.setAttribute("errorLogin", errorLogin);
			return "login.jsp";
		}
		
	}

}
