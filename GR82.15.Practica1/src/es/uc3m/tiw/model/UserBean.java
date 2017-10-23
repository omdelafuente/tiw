package es.uc3m.tiw.model;

import java.io.Serializable;

public class UserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String password;
	private String email;
	
	
	public UserBean(String name, String surname, String password, String email) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
	}
	
	public UserBean() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
