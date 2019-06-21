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

@WebServlet("/GestionaVehiculo")
public class GestionaVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionaVehiculo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (logic.ChkApikey.isApiKeyGET(request.getParameter("APIKEY")) || logic.ChkApikey.isApiKeyALL(request.getParameter("APIKEY"))) {
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
		if (logic.ChkApikey.isApiKeyALL(request.getParameter("APIKEY"))) {
		try {
			Post.addVehiculo(request);
		} catch (Exception precNeg) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (logic.ChkApikey.isApiKeyALL(request.getParameter("APIKEY"))) {
		try {
			Put.edtVehiculo(request);
		} catch (IndexOutOfBoundsException e1) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} catch (Exception precNeg) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (logic.ChkApikey.isApiKeyALL(request.getParameter("APIKEY"))) {
		try {
			Delete.delVehiculo(request);
		} catch (IndexOutOfBoundsException e1) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
