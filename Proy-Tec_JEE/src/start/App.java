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

		System.out.println("Persona encontrada con éxito: " + p);
	}
}