package es.uc3m.tiw.controller;

import es.uc3m.tiw.model.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterHandler implements IRequestHandler {
	
	@Override
	//registro de un usuario y validacion del formulario de registro
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("psw");
		String checkPassword = request.getParameter("checkpsw");
		String email = request.getParameter("email");
		

		ArrayList<String> errorRegister = new ArrayList<String>();
		boolean registerSuccess = true;
		
		Usr user = new Usr(name,surname,password,email,true);
		
		//validacion de los datos introducidos
		
		if(!password.equals(checkPassword)){
			
			registerSuccess = false;
			errorRegister.add("La contraseña y la confirmación deben coincidir.");
			
		}
		if(password.length() < 6){
			
			registerSuccess = false;
			errorRegister.add("La contraseña debe tener mínimo 6 números o letras.");
			
		}
		
		if(!name.matches("^[\\p{Space}\\p{L}]+$") || !surname.matches("^[\\p{Space}\\p{L}]+$")){
			
			registerSuccess = false;
			errorRegister.add("Los nombres y apellidos solo pueden contener letras.");
		}
		
		
		//si no ha habido errores, se registra al usuario en la base de datos y se le manda al login
		//si ha ha habido errores, se echa para atrás el registro y se devuelven los errores 
		
		if(registerSuccess){
			UsrDAO registerDAO = new UsrDAO();
			
			if(registerDAO.readUser(email) != null){
				
				registerSuccess = false;
				errorRegister.add("Ya existe una cuenta con esa dirección de correo, por favor use otra.");
				
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
