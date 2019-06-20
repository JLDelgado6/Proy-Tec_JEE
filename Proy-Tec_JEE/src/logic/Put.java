package logic;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;
import controller.GestionaVehiculo;

public class Put {
	public static void edtVehiculo(HttpServletRequest request) {
		Long ind = 1L;

		Session session = HibernateUtil.getSession();
		Vehiculo v = session.get(Vehiculo.class, ind);
		// v.setSalario(100);

		try {
			session.beginTransaction();
			if (v.getPrecioVeh() >= 0) {
				session.update(v);
				session.getTransaction().commit();

				session.close();

				System.out.println("Vehiculo editado con éxito: " + v);
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
