package logic;

import org.hibernate.Session;

import controller.HttpServletRequest;
import dbm.HibernateUtil;
import model.Vehiculo;

public class Get {
	public static void getVehiculo(HttpServletRequest request) {
		Long ind = 1L;

		Session session = HibernateUtil.getSession();
		Vehiculo v = session.get(Vehiculo.class, ind);
		session.close();

		System.out.println("Vehículo recuperado con éxito: " + v);
	}
}
