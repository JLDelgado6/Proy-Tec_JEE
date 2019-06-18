package start;

import java.util.List;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Persona;

public class App {

	public static void main(String[] args) {

		//addPersona();
		//getPersona();
		//edtPersona();
		//delPersona();
		//lstPersona();
		//schPersona();

	}

	private static void addPersona() {

		Persona p = new Persona();
		p.setNombre("luis");
		p.setApellidos("Gonzalez");
		p.setSalario(7600);

		Session session = HibernateUtil.getSession();

		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();

		session.close();

		System.out.println("Persona insertada con �xito: " + p);
	}

	private static void getPersona() {
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Persona p = session.get(Persona.class, indice);
		session.close();

		System.out.println("Persona recuperada con �xito: " + p);
	}

	private static void edtPersona() {
		Long indice = 1L;

		Session session = HibernateUtil.getSession();
		Persona p = session.get(Persona.class, indice);
		p.setSalario(100);

		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
		session.close();

		System.out.println("Persona editada con �xito: " + p);
	}

	private static void delPersona() {
		Long indice = 1L;
		
		Session session = HibernateUtil.getSession();
		Persona p = session.get(Persona.class, indice);

		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
		
		session.close();

		System.out.println("Persona eliminada con �xito: " + p);
	}

	@SuppressWarnings("unchecked")
	private static void lstPersona() {
		Session session = HibernateUtil.getSession();
		String query = "FROM Persona";
		List<Persona> listado = session.createQuery(query).list();
		session.close();

		for(Persona p : listado) {
			System.out.println(p);	
		}
	}

	private static void schPersona() {
		Session session = HibernateUtil.getSession();
		String query = "FROM Persona where salario=100";
		Persona p = (Persona) session.createQuery(query).uniqueResult();
		session.close();

		System.out.println("Persona encontrada con �xito: " + p);
	}
}