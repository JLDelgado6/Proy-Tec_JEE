package logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Delete {
	  public static void delVehiculo(HttpServletRequest request) {
		
		    System.out.println("Procesando la petición DELETE");
				
			Long idVehiculo = Long.parseLong(request.getParameter("idVehiculo"));
			Session vSession = HibernateUtil.getSession();
			Vehiculo v = vSession.get(Vehiculo.class, idVehiculo);
			
			vSession.beginTransaction();
			vSession.delete(v);
			vSession.getTransaction().commit();
			vSession.close();
			
			System.out.println("Borrado con éxito el " + v);
		
	} 

}
