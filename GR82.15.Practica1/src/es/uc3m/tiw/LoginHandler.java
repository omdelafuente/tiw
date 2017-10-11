package es.uc3m.tiw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandler implements IRequestHandler {
	
	private final String userAddress = "user@gmail.com";
	private final String userPassword = "password";
	

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user = request.getParameter("email");
		String psw = request.getParameter("psw");
		
		if(psw.equals(userPassword) && user.equals(userAddress)){
			
			request.getSession().setAttribute("loggedUser", "Alfredo");
			return "index.jsp";
			
		}
		else{
			
			request.setAttribute("failedLogin", true);
			return "login.jsp";
			
			
		}
		
	}

}
