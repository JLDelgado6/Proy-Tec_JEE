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
import logic.ChkApiKey;

@WebServlet("/GestionaVehiculo")
public class GestionaVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionaVehiculo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			if (ChkApiKey.isApiKeyALL(request.getParameter("apiKey"))) {
		

					response.getWriter().append(Get.getVehiculo(request));

			
				
			} else {

				System.out.println("Se ha producido un error 401");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (ChkApiKey.isApiKeyALL(request.getParameter("apiKey"))) {
				if (Integer.parseInt(request.getParameter("precio")) >= 0) {

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

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigoRespuesta = 200;
		String mensaje = "Todo OK";

		if (ChkApiKey.isApiKeyALL(request.getParameter("apiKey"))) {
			try {
				if (Integer.parseInt(request.getParameter("precio")) > 0) {
					Put.edtVehiculo(request, response);
				} else {

					mensaje = "Se ha producido un error 400";
					codigoRespuesta = HttpServletResponse.SC_BAD_REQUEST;
				}
			} catch (IllegalArgumentException e1) {

				mensaje = "Se ha producido un error 503";
				codigoRespuesta = HttpServletResponse.SC_SERVICE_UNAVAILABLE;

			} catch (IndexOutOfBoundsException e) {

				mensaje = "Se ha producido un error 404";
				codigoRespuesta = HttpServletResponse.SC_NOT_FOUND;

			}

		} else {

			mensaje = "Se ha producido un error 401";
			codigoRespuesta = HttpServletResponse.SC_UNAUTHORIZED;
		}

		System.out.println(mensaje);
		response.setStatus(codigoRespuesta);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (ChkApiKey.isApiKeyALL(request.getParameter("apiKey"))) {
			try {

				Delete.delVehiculo(request);

			} catch (IndexOutOfBoundsException e) {

				System.out.println("Se ha producido un error 404");
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);

			} catch (IllegalArgumentException e1) {

				System.out.println("Se ha producido un error 503");
				response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

			}

		} else {

			System.out.println("Se ha producido un error 401");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}

	}
}
