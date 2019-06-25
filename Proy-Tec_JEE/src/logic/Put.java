package logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dbm.HibernateUtil;
import model.Vehiculo;

public class Put {
	public static void edtVehiculo(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Procesando la petición PUT");

		Long index = Long.parseLong(request.getParameter("idVehiculo"));
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");

		Session vSession = HibernateUtil.getSession();
		Vehiculo v = vSession.get(Vehiculo.class, index);

		if (v == null) {
			throw new IndexOutOfBoundsException("Vehiculo no actualizable porque no existe.");
		}

		vSession.beginTransaction();

		if (marca != null) {
			v.setMarca(marca);
		}

		if (modelo != null) {
			v.setModelo(modelo);
		}

		if (request.getParameter("precio") == "") {
			v.setPrecio(0);
		} else {
			v.setPrecio(Integer.parseInt(request.getParameter("precio")));
		}

		vSession.update(v);
		vSession.getTransaction().commit();

		System.out.println("Actualizado con éxito el " + v);

	}
}
