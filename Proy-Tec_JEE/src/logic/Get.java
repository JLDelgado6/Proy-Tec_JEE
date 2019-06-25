package logic;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dbm.HibernateUtil;
import model.Vehiculo;

import com.google.gson.Gson;

public class Get {

	public static String getVehiculo(HttpServletRequest request) {

        System.out.println("Procesando la petición GET");
		
        Long idVehiculo = (request.getParameter("idVehiculo")!= null)
        		      ?Long.parseLong(request.getParameter("idVehiculo")):null;
        String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		Integer precio = (request.getParameter("precio")!= null)
				         ?Integer.parseInt(request.getParameter("precio")):null;
		Long from = (request.getParameter("from") != null)
						 ?Long.parseLong(request.getParameter("from")):null;
	    Long to = (request.getParameter("to")!= null)
					 ?Long.parseLong(request.getParameter("to")):null;
		String sort = request.getParameter("sort"); 
							
									 
		
		//Definición de la queryString para definir la consulta en SQL					 
		String queryString = "";
		
		if(idVehiculo != null) {
		                    	  
			queryString = "SELECT v FROM Vehiculo v WHERE v.idVehiculo =:idVehiculo";

		}else {

			queryString = "SELECT v FROM Vehiculo v WHERE 1=1";
			
			if(marca != null) {queryString += " and v.marca = :marca";}

			if(modelo != null) {queryString += " and v.modelo = :modelo";}

			if(precio != null) {queryString += " and v.precio = :precio";}

            if(from != null) {queryString += " and v.idVehiculo >= :from";}

			if(to != null) {queryString += " and v.idVehiculo <= :to";}
			
			if(sort != null) {queryString += " ORDER BY :sort";}
			
		}
				 
		System.out.println(queryString);					 
		Session vSession = HibernateUtil.getSession();
		Query query = vSession.createQuery(queryString);
		
		if(idVehiculo != null) {

			query.setParameter("idVehiculo",idVehiculo);

		}else {

			if(marca != null) {query.setParameter("marca", marca);}

			if(modelo != null) {query.setParameter("modelo", modelo);}

			if(precio != null) {query.setParameter("precio", precio);}

			if(from != null) {query.setParameter("from", from);}

			if(to != null) {query.setParameter("to", to);}
			
			if(sort != null) {query.setParameter("sort", sort);}

		}
		
		List<Vehiculo> listaVehiculos = query.list();
		vSession.close();
		
		System.out.println("Mostrando la petición deseada" );

		return new Gson().toJson(listaVehiculos);
		
		}

}
