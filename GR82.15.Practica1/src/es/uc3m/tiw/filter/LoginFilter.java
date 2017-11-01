package es.uc3m.tiw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(httpRequest.getSession(false) != null  && httpRequest.getSession(false).getAttribute("loggedUser") != null){
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher r = request.getRequestDispatcher("login.jsp");
			request.setAttribute("notLogged", true);
			r.forward(request, response);
		}

	}

	
	public void init(FilterConfig config) throws ServletException {
		
	}

}
