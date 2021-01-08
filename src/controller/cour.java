package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import metier.absenceImp;
import metier.absenceInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.cours;

/**
 * Servlet implementation class AdminServlet
 */

public class cour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final int TAILLE_TAMPON = 10240;
	    public static final String CHEMIN_FICHIERS = "/uploader/"; // A changer
	//private carriereInterface carrieres;
	private absenceInterface absence;
	public cour() {
		super();
		absence = new absenceImp();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			absence.deleteAbsence(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("Administration/services_scolarite/supprimer_absence.jsp");
			
		}
		 //this.getServletContext().getRequestDispatcher("/professeurs/depot_cours.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
	
		}
}
			
				
				
				
			
