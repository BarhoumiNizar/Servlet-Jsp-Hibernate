package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.EtudiantImp;
import metier.EtudiantInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.emploie_temps_prof;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="emploieProf", urlPatterns = { "/emploieProf" })
public class emlpoie_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private EtudiantInterface emploie_temps_profs;
	public emlpoie_prof() {
		super();
		emploie_temps_profs = new EtudiantImp();
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		// objet use pour envoyer l'id passé en parametre
		emploie_temps_prof emploie = new emploie_temps_prof();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String lundi = request.getParameter("lundi");
			 String mardi = request.getParameter("mardi");
			 String mercredi = request.getParameter("mercredi");
			 String jeudi = request.getParameter("jeudi");
			 String vendredi = request.getParameter("vendredi");
			 String samedi = request.getParameter("samedi");
			 String prof = request.getParameter("prof");
			
				
				
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				emploie.setLundi(lundi);
				emploie.setMardi(mardi);
				emploie.setMercredi(mercredi);
				emploie.setJeudi(jeudi);
				emploie.setVendredi(vendredi);
				emploie.setSamedi(samedi);
				emploie.setProf(prof);
				
			  
			  
				session.save(emploie); 
				session.getTransaction().commit(); 
				System.out.println("emploie ajouté avec succés");
			

		} 
		 
	}

}
