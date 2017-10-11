package es.uc3m.tiw;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterHandler implements IRequestHandler {

	private UserBean user;
	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("checkpsw") != request.getParameter("psw")){
			
			String wrongPassMessage = "Las contraseñas deben coincidir.";
			
			request.setAttribute("failedRegister", true);
			request.setAttribute("wrongPassMessage", wrongPassMessage);
			return "register.jsp";
			
		}
		
		return "index.jsp";
	}

}
