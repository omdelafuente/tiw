package es.uc3m.tiw.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {"/home","/register","/login","/event"})
@MultipartConfig
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	
	
}
