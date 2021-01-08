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

import metier.matiereImp;
import metier.matiereInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.classe;
import Model.matiere;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="matiere", urlPatterns = { "/matiere" })
public class matieres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private matiereInterface matieres;
	public matieres() {
		super();
		matieres = new matiereImp();
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
			matieres.deletematiere(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("chef_departement/supprimer_matieret.jsp");
			
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
		matiere mat= new matiere();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String mat_nom = request.getParameter("mat_nom");
			 String mat_mass_horaire = request.getParameter("mat_mass_horaire");
				int horaire=Integer.parseInt(mat_mass_horaire);
			 String classe = request.getParameter("id_classe");
			 String departement = request.getParameter("departement");
			 String mat_coefficient = request.getParameter("mat_coefficient");
				int coefficient=Integer.parseInt(mat_coefficient);	
				List<matiere> ok =matieres.verifmatiere(mat_nom, classe);
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('ce champ existe');"
								+ "                  document.location.href='chef_departement/matiere.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
					
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				mat.setClasse(classe);
				mat.setMat_coefficient(coefficient);
				mat.setMat_mass_horaire(horaire);
				mat.setMat_nom(mat_nom);
				mat.setEtat("non");
			    mat.setDepartement(departement);
			  
				session.save(mat); 
				session.getTransaction().commit(); 
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "document.location.href='chef_departement/matiere.jsp'</script></body></html>");
			
				 }
		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
				int test_update=Integer.parseInt(id);
			 String matiere_nom = request.getParameter("mat_nom");
			 String masse = request.getParameter("mat_mass_horaire");
				int masse_horaire=Integer.parseInt(masse);
				 String coeff = request.getParameter("mat_coefficient");
					int coefficient=Integer.parseInt(coeff);
					 String classe = request.getParameter("id_classe");
						
				mat.setClasse(classe);
				mat.setId(test_update);
				mat.setMat_coefficient(coefficient);
				mat.setMat_mass_horaire(masse_horaire);
			mat.setMat_nom(matiere_nom);
				
				matieres.Modifiermatiere(mat);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("chef_departement/modifier_matiere.jsp");

			} 
		 
		 
	}

}
