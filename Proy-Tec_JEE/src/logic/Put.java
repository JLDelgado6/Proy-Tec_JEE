package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Put {
	public static void edtVehiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Procesando la petición PUT");
		
		Long index = Long.parseLong(request.getParameter("idVehiculo"));
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		Integer precio = Integer.parseInt(request.getParameter("precio"));
		
		Session vSession = HibernateUtil.getSession();
		Vehiculo v = vSession.get(Vehiculo.class, index);
		
		
		vSession.beginTransaction();
		
		if (marca != null) {
			v.setMarca(marca);
		}

		if (modelo != null) {
			v.setModelo(modelo);
		}

		if (precio != null) {
			v.setPrecio(precio);
		} 
		
		vSession.update(v);
		vSession.getTransaction().commit();
		
		System.out.println("Actualizado con éxito el " + v);

	}
}
