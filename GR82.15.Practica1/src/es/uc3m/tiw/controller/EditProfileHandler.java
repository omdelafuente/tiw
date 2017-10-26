package es.uc3m.tiw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.*;


public class EditProfileHandler implements IRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String oldPassword = request.getParameter("psw");
		String newPassword = request.getParameter("npsw");
		String checkNewPassword = request.getParameter("checknpsw");
		
		Usr user = (Usr)request.getSession().getAttribute("loggedUser");
		Usr updatedUser = new Usr();
		updatedUser.setEmail(user.getEmail());
		UsrDAO userDAO = new UsrDAO();
		
		ArrayList<String> errorEdit = new ArrayList<String>();
		boolean editSuccess = true;

		if(!name.isEmpty()){
			
			if(!name.equals(user.getName())){
				if(!name.matches("^[ A-Za-z]+$")){
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
				if(!surname.matches("^[ A-Za-z]+$")){
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
		
		if(!newPassword.isEmpty()) {
			
			if(checkNewPassword.isEmpty()){
				
				editSuccess = false;
				errorEdit.add("Debes confirmar la nueva contraseña.");
			}else {
				
				if(!newPassword.equals(checkNewPassword)){
					editSuccess = false;
					errorEdit.add("La nueva contraseña y su confirmación deben ser iguales.");
				}
				if(newPassword.equals(user.getPassword())){
					editSuccess = false;
					errorEdit.add("La nueva contraseña debe ser distinta a la antigua.");
				}
				if(newPassword.length() < 6){
					
					editSuccess = false;
					errorEdit.add("La contraseña debe tener mínimo 6 números o letras.");
					
				}
				updatedUser.setPassword(newPassword);
			}
		}else{
			updatedUser.setPassword(user.getPassword());
		}
		
		if(newPassword.isEmpty() && (name.isEmpty() || name.equals(user.getName())) && (surname.isEmpty() || surname.equals(user.getSurname()))){
			editSuccess = false;
			errorEdit.add("No hay ningún campo que modificar.");
			
		}

		if(oldPassword.isEmpty()){
			
			editSuccess = false;
			errorEdit.add("Debes introducir la contraseña actual para poder realizar cambios.");
			
		}else{
			
			if(!oldPassword.equals(user.getPassword())){
				
				editSuccess = false;
				errorEdit.add("La contraseña actual no es correcta.");
				
			}
			
		}
		
		request.setAttribute("editSuccess", editSuccess);
		
		if(editSuccess){
			
			userDAO.updateUser(updatedUser);
			request.getSession().setAttribute("loggedUser", updatedUser);
			return "index.jsp";
		} else {
			
			request.setAttribute("errorEdit", errorEdit);
			return "editProfile.jsp";
		}
		
	}

}
