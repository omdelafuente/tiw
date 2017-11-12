package es.uc3m.tiw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UsrDAO {
	
	//crea un nuevo usuario en la base de datos
	public void insertUser(Usr user){
		
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		String psw = user.getPassword();
		boolean isActive = user.isActive();

		Connection con = connectDatabase();	

			
		PreparedStatement userStatement;
		try {
			userStatement = con.prepareStatement("INSERT INTO USR (name, surname, email, password, isActive) VALUES (?,?,?,?,?)");
			userStatement.setString(1, name);
			userStatement.setString(2, surname);
			userStatement.setString(3, email);		
			userStatement.setString(4, psw);
			userStatement.setBoolean(5, isActive);
			
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
	
	//elimina un usuario de la base de datos
	public void deleteUser(Usr user){
		
		String email = user.getEmail();
		
		Connection con = connectDatabase();	

		try {
		
			PreparedStatement userStatement = con.prepareStatement("DELETE FROM USR WHERE email=?");
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
	
	//modifica los datos de un usuario en la base de datos
	public void updateUser(Usr user){
		
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		String psw = user.getPassword();
		boolean isActive = user.isActive();
		
		Connection con = connectDatabase();	
		
		try {
			
			PreparedStatement userStatement = con.prepareStatement("UPDATE USR SET name=?, surname=?, password=?, isActive=? WHERE email=?");			
			userStatement.setString(1, name);
			userStatement.setString(2, surname);
			userStatement.setString(3, psw);
			userStatement.setString(5, email);
			userStatement.setBoolean(4, isActive);
				
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
	
	//encuentra un usuario por su email
	public Usr readUser(String email){
		
		Connection con = connectDatabase();	
		Statement stmnt = null;
		Usr user = new Usr();
		
		
		try {
			
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM USR WHERE email='"+email+"'");
			
			if(rs.next()){
				
				user.setEmail(email);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSurname(rs.getString("surname"));
				user.setActive(rs.getBoolean("isActive"));
				
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
	
	//m�todo que realiza las operaciones de conexi�n a la base de datos mediante JDBC DataSource
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
