package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;


import dbm.HibernateUtil;
import model.Vehiculo;

public class Get {
	public static String getVehiculo(HttpServletRequest request) {
		Long ind = 1L;
		String resultado="";
		Session session = HibernateUtil.getSession();
		Vehiculo v = session.get(Vehiculo.class, ind);
		session.close();
		System.out.println("Veh�culo recuperado con �xito: " + v);
		resultado = v.toString();
		return resultado;
		
	}
}
