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

import metier.salleImp;
import metier.salleInterface;

import org.hibernate.Session;

import util.HibernateUtil;

import Model.Salle;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="salle", urlPatterns = { "/salle" })
public class salle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private salleInterface sales;
	public salle() {
		super();
		sales = new salleImp();
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
		Salle sal = new Salle();
		if (action.equalsIgnoreCase("delete")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			sales.deletesalle(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("Administration/services_scolarite/supprimer_salle.jsp");
			
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
		Salle sl = new Salle();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String type = request.getParameter("type");
				String nom = request.getParameter("nom");
				
				
				String etages = request.getParameter("etage");
				int etage=Integer.parseInt(etages);
				String immeuble = request.getParameter("immeuble");
				
				List<Salle> ok =sales.verifsalle(nom);
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('cette salle existe');"
								+ "                  document.location.href='Administration/services_scolarite/ajouter_salle.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				
				sl.setSall_etage(etage);
				sl.setSall_immeuble(immeuble);
				sl.setSall_nom(nom);
				sl.setSall_type(type);
			    sl.setEtat("non");
			  
				session.save(sl); 
				session.getTransaction().commit(); 
				affiche.println("<html><body><script>alert('operation réussit');"
						+ "                  document.location.href='Administration/services_scolarite/ajouter_salle.jsp'</script></body></html>");
				 }

		} 
		 else if (action.equalsIgnoreCase("modidier")) 
			{
			 String id = request.getParameter("id");
			 int test_update=Integer.parseInt(id);
			 String type = request.getParameter("type");
				String nom = request.getParameter("nom");
				
				
				String etages = request.getParameter("etage");
				int etage=Integer.parseInt(etages);
				String immeuble = request.getParameter("immeuble");
				
				List<Salle> ok =sales.verifsalle(nom);
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('cette salle existe');"
								+ "                  document.location.href='Administration/services_scolarite/modifier_salle.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
					 sl.setId(test_update);   
					 sl.setSall_etage(etage);
						sl.setSall_immeuble(immeuble);
						sl.setSall_nom(nom);
						sl.setSall_type(type);
					    sl.setEtat("oui");
					sales.Modifiersalle(sl);
					 affiche.println("<html><body><script>alert('operation réussit');"
								+ "                  document.location.href='Administration/services_scolarite/modifier_salle.jsp'</script></body></html>");
				 }
			}
	}

}
