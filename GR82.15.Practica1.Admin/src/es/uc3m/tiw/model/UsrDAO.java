package es.uc3m.tiw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsrDAO {

	public void insertUser(Usr user){
		
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		String psw = user.getPassword();
		
		Connection con = connectDatabase();
		
		PreparedStatement userStatement;
		
		try {
			userStatement = con.prepareStatement("INSERT INTO USR (name, surname, email, password) VALUES (?,?,?,?)");
			userStatement.setString(1, name);
			userStatement.setString(2, surname);
			userStatement.setString(3, email);
			userStatement.setString(4, psw);
			
			userStatement.executeUpdate();
			userStatement.close();
			con.close();			
		} catch (SQLException sqlException){
			
		
			while (sqlException != null) {
				System.out.println("Error: " + sqlException.getErrorCode());
				System.out.println("Descripcion: " + sqlException.getMessage());
				System.out.println("SQLstate: " + sqlException.getSQLState());	
				sqlException = sqlException.getNextException();
			}
		}
	}

	public void deleteUser (Usr user){
		
		String email = user.getEmail();
		
		Connection con = connectDatabase();
		
		PreparedStatement userStatement;
		
		try{
			userStatement = con.prepareStatement("DELETE FROM USR WHERE email=?");
			userStatement.setString(1,email);
			
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
	
		private Connection connectDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

		
		
}
