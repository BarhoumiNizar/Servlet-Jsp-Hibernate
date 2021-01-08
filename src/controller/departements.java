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

import metier.departementImp;
import metier.departementInterface;

import org.hibernate.Session;

import util.HibernateUtil;

import Model.departement;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="departement", urlPatterns = { "/departement" })
public class departements extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private departementInterface departement;
	public departements() {
		super();
		departement = new departementImp();
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
			departement.deletedepartement(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("Administration/doyen/supprimer_departement.jsp");
			
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
		departement dep = new departement();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String dp_nom = request.getParameter("dp_nom");
			 List<departement> ok =departement.verifdepartement(dp_nom); 
			 int taille=ok.size();
			 PrintWriter affiche=response.getWriter();
			 if(taille==1)
			 {
					affiche.println("<html><body><script>alert('Departement existe');"
							+ "                  document.location.href='Administration/doyen/departement.jsp'</script></body></html>");
			 }
			 else if(taille==0)
			 {
				
				
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				dep.setDp_nom(dp_nom);
				  dep.setEtat("non");
			  
			  
				session.save(dep); 
				session.getTransaction().commit(); 
				//System.out.println("departement ajouté avec succés");
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='Administration/doyen/departement.jsp'</script></body></html>");
			
			 }
		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 String dp_nom = request.getParameter("dp_nom");
				int test_update=Integer.parseInt(id);
				dep.setId(test_update);
				dep.setDp_nom(dp_nom);
				
				departement.ModifierDepartement(dep);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("Administration/doyen/modifier_departement.jsp");

			} 
		 
	}

}
