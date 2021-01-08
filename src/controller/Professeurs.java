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

import metier.professeursImp;
import metier.professeursInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.Etudiant;
import Model.Professeur;
import Model.departement;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="professeurs", urlPatterns = { "/professeurs" })
public class Professeurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private professeursInterface Professeur;
	public Professeurs() {
		super();
		Professeur = new professeursImp();
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
			Professeur.deleteprof(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("chef_departement/supprimer_professeur.jsp");
			
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
		Professeur prof = new Professeur();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String pf_nom = request.getParameter("pf_nom");
			 String password = request.getParameter("password");
				String pf_prenom = request.getParameter("pf_prenom");
				String adresse = request.getParameter("adresse");
				String pf_email = request.getParameter("pf_email");
				String pf_num_tel = request.getParameter("pf_num_tel");
				String departement = request.getParameter("departement");
				List<Professeur> ok =Professeur.verifprof(pf_email,pf_num_tel); 
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('ce Prof existe');"
								+ "                  document.location.href='chef_departement/professeur.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
					
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				prof.setAdresse(adresse);
				prof.setPassword(password);
				prof.setPf_email(pf_email);
				prof.setPf_nom(pf_nom);
				prof.setPf_num_tel(pf_num_tel);
				prof.setPf_prenom(pf_prenom);
			    prof.setEtat("non");
			    prof.setDepartement(departement);
				session.save(prof); 
				session.getTransaction().commit(); 
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='chef_departement/professeur.jsp'</script></body></html>");
				 }

		} 
		 else if (action.equalsIgnoreCase("connexion")) 
			{
			 String email = request.getParameter("email");
			 String password = request.getParameter("password");
			 List<Professeur> ok = Professeur.verif_prof(email, password);
			 int taille=ok.size();
			if (taille>0) {
				String nom=ok.get(0).getPf_nom();
				int idprof=ok.get(0).getId();
				String prenom=ok.get(0).getPf_prenom();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession session = request.getSession(false);
				 //save message in session
				 session.setAttribute("matricule", email);
				 session.setAttribute("nom", nom);
				 session.setAttribute("prenom", prenom);
				 session.setAttribute("idprof", idprof);
				System.out.println(idprof);
				//response.sendRedirect("professeurs/index.jsp");
					
					

				} else {
					response.sendRedirect("index.jsp");
					
				}
			}
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			
				int test_update=Integer.parseInt(id);
				String pf_nom = request.getParameter("pf_nom");
				String pf_prenom = request.getParameter("pf_prenom");
				String adresse = request.getParameter("adresse");
				String pf_email = request.getParameter("pf_email");
				String pf_num_tel = request.getParameter("pf_num_tel");
				prof.setId(test_update);
				prof.setAdresse(adresse);
				prof.setPf_email(pf_email);
				prof.setPf_nom(pf_nom);
				prof.setPf_num_tel(pf_num_tel);
				prof.setPf_prenom(pf_prenom);
				
				Professeur.ModifierProf(prof);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("chef_departement/modifier_professeur.jsp");

			} 
		 
		 //Modifier PAssword
		 else if (action.equalsIgnoreCase("modifier_mdp")) 
			{
			 PrintWriter affiche=response.getWriter();
			 String id = request.getParameter("id");
			 String pwd = request.getParameter("mdp");
			 String mdps = request.getParameter("mdps");
			 String pwds = request.getParameter("pwds");
			 int ids=Integer.parseInt(id);
			 List<Professeur> ok = Professeur.rech_prof(ids);
			 int taille=ok.size();
			if (taille>0) {
				String mdp=ok.get(0).getPassword();
				if(mdp.equals(pwd))
				{
					if(mdps.equals(pwds))
					{
					prof.setPassword(mdps);
					prof.setId(ids);
					Professeur.ModifierMdp(prof);
				
					affiche.println("<html><body><script>alert('Opération réussit');"
							+ "                  document.location.href='professeurs/mdp.jsp'</script></body></html>");
						
					}
					else
					{
						affiche.println("<html><body><script>alert('Les deux champs ne sont pas cohérent');"
								+ "                  document.location.href='professeurs/mdp.jsp'</script></body></html>");
						
					}
				}
				else
				{
					affiche.println("<html><body><script>alert('votre mot de passe incorrect');"
							+ "                  document.location.href='professeurs/mdp.jsp'</script></body></html>");	
				}
			}
			
	}
		 /********/
	}

}
