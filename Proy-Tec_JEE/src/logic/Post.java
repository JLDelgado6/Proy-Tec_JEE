package logic;

import javax.servlet.http.HttpServletRequest;


import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Post {
	public static void addVehiculo(HttpServletRequest request) {
				
		System.out.println("Procesando la petición POST");
		
		String marca = (request.getParameter("marca") != null)?request.getParameter("marca"):null;
		String modelo = (request.getParameter("modelo") != null)?request.getParameter("modelo"):null;
		Integer precio = null;

        if(request.getParameter("precio")=="") {
	         precio = 0;
        } else {
	         precio = Integer.parseInt(request.getParameter("precio"));
        }
	     
		Vehiculo v = new Vehiculo(marca, modelo, precio);
		
		Session vSession = HibernateUtil.getSession();		
    	vSession.beginTransaction();
    	vSession.save(v);
    	vSession.getTransaction().commit();
    	vSession.close();		
    	
    	System.out.println("Añadiendo el " + v);
		
	}	
}	




		

