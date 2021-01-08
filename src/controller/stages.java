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

import metier.stageImp;
import metier.stageInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.stage;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="stage", urlPatterns = { "/stage" })
public class stages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private stageInterface stages;
	public stages() {
		super();
		stages = new stageImp();
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
			stages.deletestage(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("professeurs/supprimer_stage.jsp");
			
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
		stage stg = new stage();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String stg_sujet = request.getParameter("stg_sujet");
				String stg_type = request.getParameter("stg_type");
				
				String stg_entreprise = request.getParameter("stg_entreprise");
				String prof = request.getParameter("id_pf");
				
				String classe = request.getParameter("classe");
				
				String stg_date_debut = request.getParameter("stg_date_debut");
				String stg_date_fin = request.getParameter("stg_date_fin");
				List<stage> ok=stages.verifStage(classe, stg_type, stg_sujet);
				int taille=ok.size();
				PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('Ce stage est déja enregistré');"
								+ "                  document.location.href='professeurs/depot_stage.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
				
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				stg.setClasse(classe);
				stg.setProf(prof);
				stg.setStg_date_debut(stg_date_debut);
				stg.setStg_date_fin(stg_date_fin);
				stg.setStg_entreprise(stg_entreprise);
				stg.setStg_sujet(stg_sujet);
				stg.setStg_type(stg_type);
			    stg.setEtat("non");
			  
				session.save(stg); 
				session.getTransaction().commit(); 
				
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='professeurs/depot_stage.jsp'</script></body></html>");
				 }
				
		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 int test_update=Integer.parseInt(id);
			 String stg_sujet = request.getParameter("stg_sujet");
				String stg_type = request.getParameter("stg_type");
				
				String stg_entreprise = request.getParameter("stg_entreprise");
				String prof = request.getParameter("id_pf");
				
				String classe = request.getParameter("classe");
				
				String stg_date_debut = request.getParameter("stg_date_debut");
				String stg_date_fin = request.getParameter("stg_date_fin");
			 
				List<stage> ok=stages.verifStage(classe, stg_type, stg_sujet);
				int taille=ok.size();
				PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('Ce stage est déja enregistré');"
								+ "                  document.location.href='professeurs/modifier_stage.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
				stg.setId(test_update);
				stg.setClasse(classe);
				stg.setProf(prof);
				stg.setStg_date_debut(stg_date_debut);
				stg.setStg_date_fin(stg_date_fin);
				stg.setStg_entreprise(stg_entreprise);
				stg.setStg_sujet(stg_sujet);
				stg.setStg_type(stg_type);
				stg.setEtat("ok");
				stages.Modifierstage(stg);
				// pour faire l'actualisation de page accueil.jsp
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='professeurs/modifier_stage.jsp'</script></body></html>");
				 }
			} 
		 
	}

}
