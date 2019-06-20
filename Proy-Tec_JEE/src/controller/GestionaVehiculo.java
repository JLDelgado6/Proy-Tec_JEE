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
		response.getWriter().append(Get.getVehiculo(request).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post.addVehiculo(request);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Put.edtVehiculo(request);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Delete.delVehiculo(request);
	}

}
