package logic;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

@SuppressWarnings("unused")
public class Delete {
	public static void delVehiculo(HttpServletRequest request) throws IndexOutOfBoundsException {
		Long ind = 1L;

		Session session = HibernateUtil.getSession();
		Vehiculo v = session.get(Vehiculo.class, ind);

		session.beginTransaction();
		session.delete(v);
		session.getTransaction().commit();

		session.close();

		System.out.println("Vehiculo eliminado con éxito: " + v);

	}
}
