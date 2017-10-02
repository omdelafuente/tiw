package es.uc3m.tiw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterHandler implements IRequestHandler {

	private UserBean user;
	
	public RegisterHandler(){
		
		user = new UserBean();
		
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("psw"));
		System.out.println("a");
		request.setAttribute("user", user);
		
		return "success.jsp";
	}

}
