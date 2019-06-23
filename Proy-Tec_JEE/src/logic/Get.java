package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;


import dbm.HibernateUtil;
import model.Vehiculo;

public class Get {
	
	public static String getVehiculo(HttpServletRequest request) {
		
		System.out.println("Procesando la petición GET");
	
		Long index = Long.parseLong(request.getParameter("idVehiculo"));
		String resultado="";
		
		Session vSession = HibernateUtil.getSession();
		Vehiculo v = vSession.get(Vehiculo.class, index);
		vSession.close();
		
		System.out.println("Mostrar vehículo: " + v);
		resultado = v.toString();
		return resultado;
		
	}
}




