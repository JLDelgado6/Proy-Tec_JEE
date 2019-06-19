package logic;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Post {
	public static void addVehiculo() {
		Vehiculo v = new Vehiculo();
		v.setMarcaVeh("Fiat");
		v.setModeloVeh("Panda");
		v.setPrecioVeh(7600);

		Session session = HibernateUtil.getSession();
		if (v.getPrecioVeh() >= 0) {
			session.beginTransaction();
			session.save(v);
			session.getTransaction().commit();

			session.close();

			System.out.println("Vehiculo insertado con éxito: " + v);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
