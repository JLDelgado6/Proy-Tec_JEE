package start;

import java.util.List;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class App {

	public static void main(String[] args) {

		
		logic.Post.addVehiculo();
		logic.GestListaVehiculo.lstVehiculo();
		
	}
}