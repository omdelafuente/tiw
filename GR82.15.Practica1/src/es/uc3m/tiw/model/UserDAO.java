package es.uc3m.tiw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {
	
	public void insertUser(UserBean user){
		
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		String psw = user.getPassword();

		Connection con = connectDatabase();	

			
		PreparedStatement userStatement;
		try {
			userStatement = con.prepareStatement("INSERT INTO User (name, surname, email, password) VALUES (?,?,?,?)");
			userStatement.setString(1, name);
			userStatement.setString(2, surname);
			userStatement.setString(3, email);		
			userStatement.setString(4, psw);
			
			userStatement.executeUpdate();
					
			userStatement.close();
			con.close();
		} catch (SQLException sqlException) {
			
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());	
				sqlException = sqlException.getNextException();
			}
		}

			
	}
	
	public void deleteUser(UserBean user){
		
		String email = user.getEmail();
		
		Connection con = connectDatabase();	

		try {
		
			PreparedStatement userStatement = con.prepareStatement("DELETE FROM User WHERE email=?");
			userStatement.setString(1, email);
			
			userStatement.executeUpdate();
			
			userStatement.close();
			con.close();
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());	
				sqlException = sqlException.getNextException();
			}
			
		}
		
	}
	
	public void updateUser(UserBean user){
		
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		String psw = user.getPassword();
		
		Connection con = connectDatabase();	
		
		try {
			
			PreparedStatement userStatement = con.prepareStatement("UPDATE User SET name=?, surname=?, password=? WHERE email=?");			
			userStatement.setString(1, name);
			userStatement.setString(2, surname);
			userStatement.setString(3, psw);
			userStatement.setString(4, email);
				
			userStatement.executeUpdate();
				
			userStatement.close();
			con.close();
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());	
				sqlException = sqlException.getNextException();
			}
			
		}

	}
	
	public UserBean readUser(String email){
		
		Connection con = connectDatabase();	
		Statement stmnt = null;
		UserBean user = new UserBean();
		
		
		try {
			
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM User WHERE email='"+email+"'");
			
			if(rs.next()){
				
				user.setEmail(email);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSurname(rs.getString("surname"));
				
			} else {

				return null;
				
			}
			
			stmnt.close();
			con.close();
		
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());	
				sqlException = sqlException.getNextException();
			}
			
		}
		
		return user;
	}
	
	private Connection connectDatabase(){
		
		InitialContext context;
		DataSource ds;
		Connection con = null;
		
		try {
			
			context = new InitialContext();
			ds = (DataSource) context.lookup("jdbc/tiw");	
			con = ds.getConnection();
			
		} catch (SQLException sqlException) {
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());
				sqlException = sqlException.getNextException();
			}
		} catch (NamingException e) {			
			System.out.println(e);
		}
		
		return con;
		
		
	}


}
