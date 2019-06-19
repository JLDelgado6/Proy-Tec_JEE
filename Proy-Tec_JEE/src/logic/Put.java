package logic;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Put {
	public static void edtVehiculo() {
		Long ind = 1L;

		Session session = HibernateUtil.getSession();
		Vehiculo v = session.get(Vehiculo.class, ind);
		// v.setSalario(100);

		session.beginTransaction();
		session.update(v);
		session.getTransaction().commit();

		session.close();

		System.out.println("Vehiculo editado con éxito: " + v);
	}
}
