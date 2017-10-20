package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.UserBean;


public class EditProfileHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String oldPassword = request.getParameter("psw");
		String newPassword = request.getParameter("npsw");
		String checkNewPassword = request.getParameter("checknpsw");
		
		UserBean user = (UserBean)request.getSession().getAttribute("loggedUser");
		
		ArrayList<String> errorEdit = new ArrayList<String>();
		boolean editSuccess = true;
		
		request.setAttribute("editSuccess", editSuccess);
		
		if(editSuccess){
			return "index.jsp";
		} else {
			
			request.setAttribute("errorEdit", errorEdit);
			return "editProfile.jsp";
		}
		
	}

}
