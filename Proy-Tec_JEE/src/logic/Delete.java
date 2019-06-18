package logic;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Delete {
	Long ind = 1L;
	
	Session session = HibernateUtil.getSession();
	Vehiculo v = session.get(Vehiculo.class, ind);

	session.beginTransaction();
	session.delete(v);
	session.getTransaction().commit();
	
	session.close();

	System.out.println("Vehiculo eliminado con éxito: " + v);

}
