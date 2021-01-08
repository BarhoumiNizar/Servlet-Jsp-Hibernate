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

import metier.administrationImp;
import metier.administrationInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.Administration;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="Administrations", urlPatterns = { "/Administrations" })
public class Administrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private administrationInterface admins;
	public Administrations() {
		super();
		admins = new administrationImp();
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
		Administration etud = new Administration();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String matricule = request.getParameter("matricule");
				String et_email = request.getParameter("email");
				String et_nom = request.getParameter("nom");
				String et_prenom = request.getParameter("prenom");
				String et_date_naissance = request.getParameter("naissance");
				String et_sexe = request.getParameter("sexe");
				
				String et_nationalite = request.getParameter("nationalite");
				String et_num_tel = request.getParameter("tel");
				String et_adresse = request.getParameter("adresse");
				String et_dernier_etablissement = request.getParameter("etablissement");
				String id_class = request.getParameter("class");
				int classe=Integer.parseInt(id_class);
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
			
			  /* etud.setEt_adresse(et_adresse);
			   */
			  
				session.save(etud); 
				session.getTransaction().commit(); 
				System.out.println("etudiant ajouté avec succés");
			

		} 
		 else if (action.equalsIgnoreCase("connexion")) 
			{
			 String login = request.getParameter("login");
			 String password = request.getParameter("password");
			 List<Administration> ok = admins.verif_admin(login, password);
			 int taille=ok.size();
			if (taille>0) {
				String role=ok.get(0).getRole();
				String log=ok.get(0).getLogin();
				int id=ok.get(0).getId();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession session = request.getSession(false);
				 //save message in session
				 session.setAttribute("role", role);
				 session.setAttribute("login", log);
				 session.setAttribute("id", id);
				if(role.equalsIgnoreCase("doyen"))	
				{
				response.sendRedirect("Administration/doyen/index.jsp");
				}
				else if(role.equalsIgnoreCase("service_scolarite"))
				{
				response.sendRedirect("Administration/services_scolarite/index.jsp");
				}
				else if(role.equalsIgnoreCase("president"))
				{
				response.sendRedirect("Administration/president/index.jsp");
				}
					

				} else {
					response.sendRedirect("index.jsp");
					
				}
			}
		 else if (action.equalsIgnoreCase("modifier")) 
			{
			 PrintWriter affiche=response.getWriter();
			 String id = request.getParameter("id");
			 String pwd = request.getParameter("mdp");
			 String logs = request.getParameter("login");
			 String lg = request.getParameter("log");
			 int ids=Integer.parseInt(id);
			 List<Administration> ok = admins.rech_admin(ids);
			 int taille=ok.size();
			if (taille>0) {
				String mdp=ok.get(0).getPassword();
				if(mdp.equals(pwd))
				{
					if(logs.equals(lg))
					{
					etud.setLogin(logs);
					etud.setId(ids);
					admins.ModifierLogin(etud);
				
					affiche.println("<html><body><script>alert('Opération réussit');"
							+ "                  document.location.href='Administration/doyen/login.jsp'</script></body></html>");
						
					}
					else
					{
						affiche.println("<html><body><script>alert('Les deux champs ne sont pas cohérent');"
								+ "                  document.location.href='Administration/doyen/login.jsp'</script></body></html>");
						
					}
				}
				else
				{
					affiche.println("<html><body><script>alert('votre mot de passe incorrect');"
							+ "                  document.location.href='Administration/doyen/login.jsp'</script></body></html>");	
				}
			}
			
	}
		 
		 else if (action.equalsIgnoreCase("modifier_mdp")) 
			{
			 PrintWriter affiche=response.getWriter();
			 String id = request.getParameter("id");
			 String pwd = request.getParameter("mdp");
			 String mdps = request.getParameter("mdps");
			 String pwds = request.getParameter("pwds");
			 int ids=Integer.parseInt(id);
			 List<Administration> ok = admins.rech_admin(ids);
			 int taille=ok.size();
			if (taille>0) {
				String mdp=ok.get(0).getPassword();
				if(mdp.equals(pwd))
				{
					if(mdps.equals(pwds))
					{
					etud.setPassword(mdps);
					etud.setId(ids);
					admins.ModifierMdp(etud);
				
					affiche.println("<html><body><script>alert('Opération réussit');"
							+ "                  document.location.href='Administration/doyen/mdp.jsp'</script></body></html>");
						
					}
					else
					{
						affiche.println("<html><body><script>alert('Les deux champs ne sont pas cohérent');"
								+ "                  document.location.href='Administration/doyen/mdp.jsp'</script></body></html>");
						
					}
				}
				else
				{
					affiche.println("<html><body><script>alert('votre mot de passe incorrect');"
							+ "                  document.location.href='Administration/doyen/mdp.jsp'</script></body></html>");	
				}
			}
			
	}
/************/
		 else if (action.equalsIgnoreCase("modifier_presidentLogin")) 
			{
			 PrintWriter affiche=response.getWriter();
			 String id = request.getParameter("id");
			 String pwd = request.getParameter("mdp");
			 String logs = request.getParameter("login");
			 String lg = request.getParameter("log");
			 int ids=Integer.parseInt(id);
			 List<Administration> ok = admins.rech_admin(ids);
			 int taille=ok.size();
			if (taille>0) {
				String mdp=ok.get(0).getPassword();
				if(mdp.equals(pwd))
				{
					if(logs.equals(lg))
					{
					etud.setLogin(logs);
					etud.setId(ids);
					admins.ModifierLogin(etud);
				
					affiche.println("<html><body><script>alert('Opération réussit');"
							+ "                  document.location.href='Administration/president/login.jsp'</script></body></html>");
						
					}
					else
					{
						affiche.println("<html><body><script>alert('Les deux champs ne sont pas cohérent');"
								+ "                  document.location.href='Administration/president/login.jsp'</script></body></html>");
						
					}
				}
				else
				{
					affiche.println("<html><body><script>alert('votre mot de passe incorrect');"
							+ "                  document.location.href='Administration/president/login.jsp'</script></body></html>");	
				}
			}
			
	}
		 /************/
		 else if (action.equalsIgnoreCase("modifier_presidentMdp")) 
			{
			 PrintWriter affiche=response.getWriter();
			 String id = request.getParameter("id");
			 String pwd = request.getParameter("mdp");
			 String mdps = request.getParameter("mdps");
			 String pwds = request.getParameter("pwds");
			 int ids=Integer.parseInt(id);
			 List<Administration> ok = admins.rech_admin(ids);
			 int taille=ok.size();
			if (taille>0) {
				String mdp=ok.get(0).getPassword();
				if(mdp.equals(pwd))
				{
					if(mdps.equals(pwds))
					{
					etud.setPassword(mdps);
					etud.setId(ids);
					admins.ModifierMdp(etud);
				
					affiche.println("<html><body><script>alert('Opération réussit');"
							+ "                  document.location.href='Administration/president/mdp.jsp'</script></body></html>");
						
					}
					else
					{
						affiche.println("<html><body><script>alert('Les deux champs ne sont pas cohérent');"
								+ "                  document.location.href='Administration/president/mdp.jsp'</script></body></html>");
						
					}
				}
				else
				{
					affiche.println("<html><body><script>alert('votre mot de passe incorrect');"
							+ "                  document.location.href='Administration/president/mdp.jsp'</script></body></html>");	
				}
			}
			
	}
	}
}
