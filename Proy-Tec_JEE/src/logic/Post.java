package logic;

import javax.servlet.http.HttpServletRequest;

//import java.util.Map;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Post {
	public static void addVehiculo(HttpServletRequest request) {
				
		System.out.println("Procesando la petición POST");
		
		String marca = (request.getParameter("marca") != null)?request.getParameter("marca"):null;
		String modelo = (request.getParameter("modelo") != null)?request.getParameter("modelo"):null;
		Integer precio = (Integer.parseInt(request.getParameter("precio")) >= 0)?Integer.parseInt(request.getParameter("precio")):0;
			
		Vehiculo v = new Vehiculo(marca, modelo, precio);
		
		Session vSession = HibernateUtil.getSession();		
    	vSession.beginTransaction();
    	vSession.save(v);
    	vSession.getTransaction().commit();
    	vSession.close();		
    	
    	System.out.println("Añadiendo el " + v);
		
	}	
}	




		

