package logic;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Post {
	Vehiculo v = new Vehiculo();
	v.setMarca("Fiat);
	v.setModelo("Panda");
	v.setPrecio(7600);

	Session session = HibernateUtil.getSession();

	session.beginTransaction();
	session.save(v);
	session.getTransaction().commit();

	session.close();

	System.out.println("Vehiculo insertado con éxito: " + v);
}
