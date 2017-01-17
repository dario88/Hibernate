package it.hibernate.mvc.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.hibernate.mvc.model.Libro;
import it.hibernate.mvc.model.LibroBean;

/**
 * Servlet implementation class ControllerLibro
 */
@WebServlet("/ControllerLibro")
public class ControllerLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private LibroBean libroBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("id");
		Long id = 0L;
		if (idStr != null && !idStr.equals(""))
			id = Long.parseLong(idStr);
		String action = request.getParameter("action");
		String titolo = request.getParameter("titolo");
		String isbn = request.getParameter("isbn");
		Float prezzo = 0F;
		String prezzoStr = request.getParameter("prezzo");
		if (prezzoStr != null && !prezzoStr.equals(""))
			prezzo = Float.parseFloat(prezzoStr);
		
		Libro libro = new Libro(titolo, isbn, prezzo);
		libro.setId(id);
		
		if ("Add".equalsIgnoreCase(action)) {
			libroBean.persist(libro);
		} else if ("Edit".equalsIgnoreCase(action)) {
			libroBean.update(libro);
		} else if ("Delete".equalsIgnoreCase(action)) {
			libroBean.delete(libro);
		} else if ("Find".equalsIgnoreCase(action)) {
			libro = libroBean.getById(id);
		}
		
		request.setAttribute("libro", libro);
		request.setAttribute("allLibri", libroBean.getAll());
		
		request.getRequestDispatcher("libro.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
