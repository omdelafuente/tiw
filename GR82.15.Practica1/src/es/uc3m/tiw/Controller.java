package es.uc3m.tiw;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns ={"/index","/login","/register", "/search", "/logOut"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, IRequestHandler> handlerHash = new HashMap<String, IRequestHandler>();

	public void init(ServletConfig config) throws ServletException {
		
		handlerHash.put("/login", new LoginHandler());
		handlerHash.put("/register", new RegisterHandler());
		handlerHash.put("/search", new SearchHandler());
		handlerHash.put("/logOut", new LogOutHandler());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
