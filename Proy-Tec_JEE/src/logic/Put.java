package logic;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;
import controller.GestionaVehiculo;

@SuppressWarnings("unused")
public class Put {
	public static void edtVehiculo(HttpServletRequest request) throws IndexOutOfBoundsException, Exception {
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
				throw new Exception("Precio no válido");
			}
		} catch (Exception e) {
			
		}
	}
}
