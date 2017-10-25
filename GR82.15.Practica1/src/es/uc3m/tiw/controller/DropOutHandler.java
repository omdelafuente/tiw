package es.uc3m.tiw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.*;

public class DropOutHandler implements IRequestHandler{


	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Usr user = (Usr)request.getSession().getAttribute("loggedUser");
		UserDAO userDAO = new UserDAO();
		
		userDAO.deleteUser(user);
		
		request.setAttribute("dropOutSuccess", true);
		request.getSession().invalidate();
		return "index.jsp";
	}

}
