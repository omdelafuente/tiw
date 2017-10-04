package es.uc3m.tiw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandler implements IRequestHandler {
	
	private UserBean user;
	
	public LoginHandler(){
		
		user = new UserBean();
		
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("psw"));
		user.setName("Alfredo");
		
		request.getSession().setAttribute("loggedUser", user);
		
		return "index.jsp";
	}

}
