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

import metier.classeImp;
import metier.classeInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.classe;
import Model.departement;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="classe", urlPatterns = { "/classe" })
public class classes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private classeInterface classes;
	public classes() {
		super();
		classes = new classeImp();
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
			classes.deleteclasse(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("chef_departement/supprimer_classe.jsp");
			
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
		classe cl = new classe();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String class_nom = request.getParameter("class_nom");
			 String filiere = request.getParameter("id_filiere");
			 String departement = request.getParameter("departement");
			 List<classe> ok =classes.verifclasse(class_nom);
			 int taille=ok.size();
			 PrintWriter affiche=response.getWriter();
			 if(taille==1)
			 {
					affiche.println("<html><body><script>alert('classe existe');"
							+ "                  document.location.href='chef_departement/classe.jsp'</script></body></html>");
			 }
			 else if(taille==0)
			 {
				
				
				
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				cl.setClass_nom(class_nom);
				cl.setFiliere(filiere);
				cl.setEtat("non");
			    cl.setDepartement(departement);
			  
				session.save(cl); 
				session.getTransaction().commit(); 
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='chef_departement/classe.jsp'</script></body></html>");
			 }

		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 String classe_nom = request.getParameter("class_nom");
				int test_update=Integer.parseInt(id);
				 String filiere = request.getParameter("filiere");
				cl.setClass_nom(classe_nom);
				cl.setId(test_update);
				cl.setFiliere(filiere);
				cl.setEtat("non");
				classes.Modifierclasse(cl);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("chef_departement/modifier_classe.jsp");

			} 
		 
		 
	}

}
