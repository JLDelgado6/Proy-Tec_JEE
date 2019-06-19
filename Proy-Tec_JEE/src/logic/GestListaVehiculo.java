package logic;

import java.util.List;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class GestListaVehiculo {

@SuppressWarnings("unchecked")
public static void lstVehiculo() {
	Session session = HibernateUtil.getSession();
	String query = "FROM Vehiculo";
	List<Vehiculo> listado = session.createQuery(query).list();
	session.close();

	for (Vehiculo v : listado) {
		System.out.println(v);
	}
}

public static void schVehiculo() {
	Session session = HibernateUtil.getSession();
	String query = "FROM Vehiculo where precio=100";
	Vehiculo v = (Vehiculo) session.createQuery(query).uniqueResult();
	session.close();

	System.out.println("Vehículo encontrado con éxito: " + v);
}

}
