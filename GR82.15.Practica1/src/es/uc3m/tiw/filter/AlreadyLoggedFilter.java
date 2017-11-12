package es.uc3m.tiw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns ={"/login.jsp","/login", "/register.jsp","/register"})
//filtra que un usuario ya logeado no pueda acceder al logeo/registro
public class AlreadyLoggedFilter implements Filter {

	
	public void destroy() {
	}

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(httpRequest.getSession(false).getAttribute("loggedUser") == null){
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher r = request.getRequestDispatcher("/index");
			r.forward(request, response);
		}

	}

	
	

}
