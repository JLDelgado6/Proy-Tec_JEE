package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Delete;
import logic.Get;
import logic.Post;
import logic.Put;
import logic.ChkApikey;


@WebServlet("/GestionaVehiculo")
public class GestionaVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionaVehiculo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ChkApikey.isApiKeyGET(request.getParameter("apiKey")) || ChkApikey.isApiKeyALL(request.getParameter("apiKey"))) {
			try {
				response.getWriter().append(Get.getVehiculo(request));
			} catch (IndexOutOfBoundsException e) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if(ChkApikey.isApiKeyALL(request.getParameter("apiKey"))) {
				if (Integer.parseInt(request.getParameter("precio")) > 0) {
					
					Post.addVehiculo(request);
					
				} else {
					
				    System.out.println("Se ha producido un error 400");
				    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			    }
			} else {
				
				System.out.println("Se ha producido un error 401");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			
			System.out.println("Se ha producido un error 503");
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
		}
	}
		
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if(ChkApikey.isApiKeyALL(request.getParameter("apiKey"))) {
				try {
					if (Integer.parseInt(request.getParameter("precio")) > 0) {
						Put.edtVehiculo(request,response);
					} else {
						
					    System.out.println("Se ha producido un error 400");
					    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				    }
					
			    } catch (IllegalArgumentException e) {
			    	
			    	System.out.println("Se ha producido un error 404");
			    	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			    }
				
			} else {
				
				System.out.println("Se ha producido un error 401");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			
			System.out.println("Se ha producido un error 503");
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
		}
	}
	    

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			if(ChkApikey.isApiKeyALL(request.getParameter("apiKey"))) {
				try {
					
					Delete.delVehiculo(request);
					
				} catch (IllegalArgumentException e) {
				
				    System.out.println("Se ha producido un error 404");
				    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			    }
			} else {
				
				System.out.println("Se ha producido un error 401");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			
			System.out.println("Se ha producido un error 503");
			response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
		}
	
	}
}




		
