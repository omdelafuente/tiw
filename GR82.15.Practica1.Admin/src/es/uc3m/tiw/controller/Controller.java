package es.uc3m.tiw.controller;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/index","/login","/logOut","/events","/chat","/availableChats"})
@MultipartConfig
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, IRequestHandler> handlerHash = new HashMap<String, IRequestHandler>();

public void init (ServletConfig config) throws ServletException {
	
	handlerHash.put("/login", new LoginHandler());
	handlerHash.put("/logOut", new LogOutHandler());
	handlerHash.put("/events", new EventListHandler());
	handlerHash.put("/chat", new ChatHandler());
	handlerHash.put("/availableChats", new AvailableChatsHandler());

}

public void destroy (){
	
}
	
public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	doPost(request,response);
}
	
public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	IRequestHandler rh = (IRequestHandler) handlerHash.get(request.getServletPath());
	
	if (rh == null) {
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
	} else {
			
		String url = rh.handleRequest(request, response);
			
		if (url == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}
}
