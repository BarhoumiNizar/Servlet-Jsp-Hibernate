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

import metier.filiereImp;
import metier.filiereInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.Etudiant;
import Model.Filiere;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="filiere", urlPatterns = { "/filiere" })
public class filieres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private filiereInterface filieres;
	public filieres() {
		super();
		filieres = new filiereImp();
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
			filieres.deletefiliere(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("chef_departement/supprimer_filiere.jsp");
			
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
		Filiere fil = new Filiere();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String flr_nom = request.getParameter("flr_nom");
			 String departement = request.getParameter("id_dep");
			 List<Filiere> ok = filieres.veriffiliere(flr_nom, departement);
			 int taille=ok.size();
			 PrintWriter affiche=response.getWriter();
			 if(taille==1)
			 {
					affiche.println("<html><body><script>alert('Filiere existe');"
							+ "                  document.location.href='chef_departement/filieres.jsp'</script></body></html>");
			 }
			 else if(taille==0)
			 {
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				fil.setFlr_nom(flr_nom);
				fil.setDep(departement);
				fil.setEtat("non");
			  
			  
				session.save(fil); 
				session.getTransaction().commit(); 
			 
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='chef_departement/filieres.jsp'</script></body></html>");
			}

			 
		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 String fl_nom = request.getParameter("flr_nom");
			 String departement = request.getParameter("id_dep");
				int test_update=Integer.parseInt(id);
				List<Filiere> ok = filieres.veriffiliere(fl_nom, departement);
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				/* if(taille==1)
				 {
						affiche.println("<html><body><script>alert('Filiere existe');"
								+ "                  document.location.href='Administration/doyen/modifier_filiere.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {*/
					
				fil.setFlr_nom(fl_nom);
				fil.setId(test_update);
				fil.setDep(departement);
				filieres.Modifierfiliere(fil);
				// pour faire l'actualisation de page accueil.jsp
				
				affiche.println("<html><body><script>alert('Filiere modifié');"
						+ "                  document.location.href='chef_departement/modifier_filiere.jsp'</script></body></html>");
				//response.sendRedirect("Administration/doyen/modifier_filiere.jsp");
				// }
			} 
		 
	}

}
