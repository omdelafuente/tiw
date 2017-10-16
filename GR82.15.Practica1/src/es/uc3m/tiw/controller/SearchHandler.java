package es.uc3m.tiw.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.tiw.model.EventBean;


public class SearchHandler implements IRequestHandler {

	private static ArrayList<EventBean> EventList = new ArrayList<EventBean>();
	
	static{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date[] date = new Date[20];
		
		try {
			date[0] = formatter.parse("02-12-2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		EventList.add(new EventBean("Kase-O en concierto","Conciertos",18.00f, date[0], 
				null, "resources/kaseo.jpg", "WiZink Center, Madrid", "Gira EL C�RCULO 2016-2017 "
						+ "KASE.O llega a conquistar el m�tico Palacio de los Deportes de Madrid. "
			   +"Despu�s de batir todos los records en la gira m�s importante de la historia de HIP-HOP en Espa�a, KASE.O quiere reunir a todos sus seguidores en un concierto m�tico con colabos y sorpresas que se ir�n anunciando, y que ser� el colof�n de su TOUR EL C�RCULO 2017."
			   +"La apertura de puertas ser� a las 19:30 horas, EL MOMO 20:30 horas y el inicio del concierto de KASE.O a las 21:30 horas.", 500, "Disponible"));
		EventList.add(new EventBean("Kase-O en concierto","Conciertos",18.00f, date[0], 
				null, "resources/kaseo.jpg", "WiZink Center, Madrid", "Gira EL C�RCULO 2016-2017 "
						+ "KASE.O llega a conquistar el m�tico Palacio de los Deportes de Madrid. "
			   +"Despu�s de batir todos los records en la gira m�s importante de la historia de HIP-HOP en Espa�a, KASE.O quiere reunir a todos sus seguidores en un concierto m�tico con colabos y sorpresas que se ir�n anunciando, y que ser� el colof�n de su TOUR EL C�RCULO 2017."
			   +"La apertura de puertas ser� a las 19:30 horas, EL MOMO 20:30 horas y el inicio del concierto de KASE.O a las 21:30 horas.", 500, "Disponible"));
		EventList.add(new EventBean("Kase-O en concierto","Conciertos",18.00f, date[0], 
				null, "resources/kaseo.jpg", "WiZink Center, Madrid", "Gira EL C�RCULO 2016-2017 "
						+ "KASE.O llega a conquistar el m�tico Palacio de los Deportes de Madrid. "
			   +"Despu�s de batir todos los records en la gira m�s importante de la historia de HIP-HOP en Espa�a, KASE.O quiere reunir a todos sus seguidores en un concierto m�tico con colabos y sorpresas que se ir�n anunciando, y que ser� el colof�n de su TOUR EL C�RCULO 2017."
			   +"La apertura de puertas ser� a las 19:30 horas, EL MOMO 20:30 horas y el inicio del concierto de KASE.O a las 21:30 horas.", 500, "Disponible"));
		
		
	
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<EventBean> results = new ArrayList<EventBean>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		for(int i = 0; i < EventList.size(); i++){
			
			
			results.add(EventList.get(i));
			
			
		}
		
		request.setAttribute("retrievedEvents", results);
		
		return "searchResults.jsp";
	}

}
