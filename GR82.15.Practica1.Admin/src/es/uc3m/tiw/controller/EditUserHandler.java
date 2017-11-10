package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.Usr;
import es.uc3m.tiw.model.UsrManager;

public class EditUserHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GR82.15.Practica1.Admin");
		
		UsrManager manager = new UsrManager();
		
		manager.setEntityManagerFactory(factory);
		
		Usr user = manager.findUserByEmail(request.getParameter("email"));
		
		if(request.getParameter("type") != null){
			
			request.setAttribute("user", user);
			return "editUser.jsp";
			
		}else {
			
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			
			Usr updatedUser = new Usr();
			updatedUser.setEmail(user.getEmail());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setActive(true);
			
			ArrayList<String> errorEdit = new ArrayList<String>();
			boolean editSuccess = true;
			
			if((name.isEmpty() || name.equals(user.getName())) && (surname.isEmpty() || surname.equals(user.getSurname()))){
				editSuccess = false;
				errorEdit.add("No hay ningún campo que modificar.");
			}
			else {
				
				if(!name.isEmpty()){
					
					if(!name.equals(user.getName())){
						if(!name.matches("^[\\p{Space}\\p{L}]+$")){
							editSuccess = false;
							errorEdit.add("El nombre solo puede contener letras.");
						}
						updatedUser.setName(name);
					}else{
						updatedUser.setName(user.getName());
					}
					
				}else{
					updatedUser.setName(user.getName());
				}
				
				if(!surname.isEmpty()){
					
					if(!surname.equals(user.getSurname())){
						if(!surname.matches("^[\\p{Space}\\p{L}]+$")){
							editSuccess = false;
							errorEdit.add("Los apellidos solo pueden contener letras.");
						}
						updatedUser.setSurname(surname);
					}else{
						updatedUser.setSurname(user.getSurname());
					}
				}else{
					updatedUser.setSurname(user.getSurname());
				}
			}
			
			request.setAttribute("editSuccess", editSuccess);
			
			if(editSuccess){
					
				try {
					manager.updateUser(updatedUser);
				} catch (Exception e){
					System.out.println("Descripcion: " + e.getMessage());
				}
				
				return "/users";
			} else {
				
				request.setAttribute("errorEdit", errorEdit);
				request.setAttribute("user", user);
				return "editUser.jsp";
			}
		}
	}

}
