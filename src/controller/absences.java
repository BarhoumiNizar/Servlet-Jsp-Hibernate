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

import metier.absenceImp;
import metier.absenceInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.absence;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="absence", urlPatterns = { "/absence" })
public class absences extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private absenceInterface absence;
	public absences() {
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
		absence abs = new absence();
		if (action.equalsIgnoreCase("delete")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			absence.deleteAbsence(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("professeurs/supprimer_absence.jsp");
			
		}
		else // objet use pour envoyer l'id passé en parametre
			
			//String id = request.getParameter("id");

			 if (action.equalsIgnoreCase("ajout")) {
				 String seance = request.getParameter("seance");
				
				 String et_matricule = request.getParameter("et_matricule");
				 String classe = request.getParameter("classe");
				 String date = request.getParameter("date");
				 String prof = request.getParameter("prof");
					List<absence> ok=absence.verifabsence(classe, seance, et_matricule,date);
					int taille=ok.size();
					 PrintWriter affiche=response.getWriter();
					 if(taille==1)
					 {
							affiche.println("<html><body><script>alert('cette absence est déja enregistré');"
									+ "                  document.location.href='professeurs/absence.jsp'</script></body></html>");
					 }
					 else if(taille==0)
					 {
				 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
					session.beginTransaction();
					abs.setEt_matricule(et_matricule);
					abs.setSeance(seance);
					abs.setClasse(classe);
					abs.setDate(date);
					abs.setProf(prof);
					abs.setEtat("non");
				  
					session.save(abs); 
					session.getTransaction().commit(); 
					
					request.getRequestDispatcher("professeurs/absences.jsp").forward(request, response);
				

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
		absence abs = new absence();
		if (action.equalsIgnoreCase("ajout")) {
			 String seance = request.getParameter("seance");
			
			 String et_matricule = request.getParameter("et_matricule");
			 String classe = request.getParameter("classe");
			 String date = request.getParameter("date");
			 String prof = request.getParameter("prof");
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				abs.setEt_matricule(et_matricule);
				abs.setSeance(seance);
				abs.setClasse(classe);
				abs.setDate(date);
				abs.setProf(prof);
			  
			  
				session.save(abs); 
				session.getTransaction().commit(); 
				PrintWriter affiche=response.getWriter();
				request.getRequestDispatcher("professeurs/absences.jsp").forward(request, response);
			

		} 
		else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 String seance = request.getParameter("seance");
			 
			 String et_matricule = request.getParameter("et_matricule");
			 String classe = request.getParameter("classe");
			 String date = request.getParameter("date");
			 String prof = request.getParameter("prof");
				int test_update=Integer.parseInt(id);
				abs.setId(test_update);
				abs.setClasse(classe);
				abs.setDate(date);
				abs.setEt_matricule(et_matricule);
				abs.setSeance(seance);
				abs.setProf(prof);
				abs.setEtat("ok");
				absence.ModifierAbsence(abs);
				// pour faire l'actualisation de page accueil.jsp
				PrintWriter affiche=response.getWriter();
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='professeurs/modifier_absence.jsp'</script></body></html>");

			} 
		 
	}

}
