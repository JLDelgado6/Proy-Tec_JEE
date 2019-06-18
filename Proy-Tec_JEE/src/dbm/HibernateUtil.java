package dbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Persona;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	private static void buildSessionFactory() {
		try {
			sessionFactory = new Configuration()
					.addAnnotatedClass(Persona.class)
					.configure()
					.buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error al conectar con la BD. " + e.getMessage());
		}
	}

	private static SessionFactory getSessionFactory() {
		buildSessionFactory();
		return sessionFactory;
	}

	public static Session getSession() {
		if (session != null && session.isOpen()) {
			return session;
		} else {
			session = getSessionFactory().openSession();
			return session;
		}
	}

}