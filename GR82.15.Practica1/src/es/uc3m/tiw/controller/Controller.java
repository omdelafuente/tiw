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

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns ={"/index","/login","/register", "/search", "/logOut","/edit","/dropOut","/createEvent","/event","/myCreatedEvents"})
@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, IRequestHandler> handlerHash = new HashMap<String, IRequestHandler>();

	public void init(ServletConfig config) throws ServletException {
		
		handlerHash.put("/login", new LoginHandler());
		handlerHash.put("/register", new RegisterHandler());
		handlerHash.put("/search", new SearchHandler());
		handlerHash.put("/logOut", new LogOutHandler());
		handlerHash.put("/edit", new EditProfileHandler());
		handlerHash.put("/dropOut", new DropOutHandler());
		handlerHash.put("/createEvent", new CreateEventHandler());
		handlerHash.put("/event", new ShowEventHandler());
		handlerHash.put("/myCreatedEvents", new MyCreatedEventsHandler());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
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
