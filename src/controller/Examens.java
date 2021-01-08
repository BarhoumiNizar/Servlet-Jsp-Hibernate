package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.notesImp;
import metier.notesInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.Examen;
import Model.Professeur;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="notes", urlPatterns = { "/notes" })
public class Examens extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private notesInterface Examens;
	public Examens() {
		super();
		Examens = new notesImp();
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
		Examen exam = new Examen();
		if (action.equalsIgnoreCase("delete")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			Examens.deletenote(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("professeurs/supprimer_note.jsp");
			
		}
		else if (action.equalsIgnoreCase("ajout")) {
			 String examen_type = request.getParameter("type");
				String examen_date = request.getParameter("date");
				String examen_heure_debut = request.getParameter("examen_heure_debut");
				String examen_heure_fin = request.getParameter("examen_heure_fin");
				String examen_note = request.getParameter("note");
				String prof = request.getParameter("prof");
				String classe = request.getParameter("classe");
			
				String mat = request.getParameter("matiere");
				
				String id_salle = request.getParameter("salle");
				int salle=Integer.parseInt(id_salle);
				String examen_coefficient = request.getParameter("coefficient");
				int coefficient=Integer.parseInt(examen_coefficient);
				String etudiant = request.getParameter("etudiant");
				List<Examen> ok =Examens.verifiernote(etudiant, classe, examen_type, mat); 
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('cette note est déja enregistré');"
								+ "                  document.location.href='professeurs/depot_notes.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
			   exam.setExamen_coefficient(coefficient);
			   exam.setExamen_date(examen_date);
			   exam.setExamen_heure_debut(examen_heure_debut);
			   exam.setExamen_heure_fin(examen_heure_fin);
			   exam.setExamen_note(examen_note);
			   exam.setExamen_type(examen_type);
			   exam.setMat(mat);
			   exam.setProf(prof);
			   exam.setId_salle(salle);
			   exam.setEtudiant(etudiant);
			   exam.setClasse(classe);
			   exam.setEtat("non");
			  
				session.save(exam); 
				session.getTransaction().commit(); 
			/*	PrintWriter affiche=response.getWriter();
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  </script></body></html>");*/
				request.getRequestDispatcher("professeurs/depot_note.jsp").forward(request, response);
				
				
				 }
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		// objet use pour envoyer l'id passé en parametre
		Examen exam = new Examen();
		//String id = request.getParameter("id");

		 
		  if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			
				int test_update=Integer.parseInt(id);
				String examen_type = request.getParameter("type");
				String examen_date = request.getParameter("date");
				String examen_heure_debut = request.getParameter("examen_heure_debut");
				String examen_heure_fin = request.getParameter("examen_heure_fin");
				String examen_note = request.getParameter("note");
				String prof = request.getParameter("prof");
				String classe = request.getParameter("classe");
			
				String mat = request.getParameter("matiere");
				
				String id_salle = request.getParameter("salle");
				int salle=Integer.parseInt(id_salle);
				String examen_coefficient = request.getParameter("coefficient");
				int coefficient=Integer.parseInt(examen_coefficient);
				String etudiant = request.getParameter("etudiant");
				exam.setId(test_update);
				exam.setExamen_coefficient(coefficient);
				   exam.setExamen_date(examen_date);
				   exam.setExamen_heure_debut(examen_heure_debut);
				   exam.setExamen_heure_fin(examen_heure_fin);
				   exam.setExamen_note(examen_note);
				   exam.setExamen_type(examen_type);
				   exam.setMat(mat);
				   exam.setProf(prof);
				   exam.setId_salle(salle);
				   exam.setEtudiant(etudiant);
				   exam.setClasse(classe);
				   exam.setEtat("ok");
				   Examens.Modifiernote(exam);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("professeurs/modifier_note.jsp");

			} 
		 
		 
	}

}
