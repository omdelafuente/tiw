package es.uc3m.tiw;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class RegisterHandler implements IRequestHandler {

	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		String errorMessage = null;
		boolean success = true;
		
		InitialContext context;
		DataSource ds;
		Connection con;
		try {
			
			context = new InitialContext();
			ds = (DataSource) context.lookup("jdbc/tiw");	
			con = ds.getConnection();
			
			PreparedStatement registerStatement = con.prepareStatement("INSERT INTO user (name, surname, email, password) VALUES (?,?,?,?)");
			registerStatement.setString(1, name);
			registerStatement.setString(2, surname);
			registerStatement.setString(3, email);
			registerStatement.setString(4, psw);
			
			registerStatement.executeUpdate();
			
			registerStatement.close();
			con.close();
			
		} catch (NamingException e) {	
			System.out.println(e);
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				if(sqlException.getErrorCode() == 1062){
					
					success = false;
					errorMessage = "Ya existe una cuenta con esa dirección de correo, por favor use otra.";
					
				}
				sqlException = sqlException.getNextException();
			}
		}
		
		if(success){
			return "index.jsp";
		} else {
			
			request.setAttribute("success", success);
			request.setAttribute("errorMessage", errorMessage);
			return "register.jsp";
		}
		
		
		
	}

}
