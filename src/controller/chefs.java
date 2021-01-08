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

import metier.chefImp;
import metier.chefInterface;

import org.hibernate.Session;

import util.HibernateUtil;

import Model.chef;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="chefcontroller", urlPatterns = { "/chefcontroller" })
public class chefs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private chefInterface chefs;
	public chefs() {
		super();
		chefs = new chefImp();
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
			chefs.deletechef(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("Administration/doyen/supprimerchef.jsp");
			
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
		chef cf = new chef();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String nom = request.getParameter("nom");
			 String password = request.getParameter("password");
				String prenom = request.getParameter("prenom");
				String adresse = request.getParameter("adresse");
				String email = request.getParameter("email");
				String num_tel = request.getParameter("num_tel");
				String departement = request.getParameter("departement");
				
				List<chef> ok =chefs.verifchef(email,num_tel,departement); 
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('ce chef de département existe');"
								+ "                  document.location.href='Administration/doyen/Ajoutchef.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
					
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				cf.setAdresse(adresse);
				cf.setPassword(password);
				cf.setEmail(email);
				cf.setNom(nom);
				cf.setNum_tel(num_tel);
				cf.setPrenom(prenom);
				cf.setDepartement(departement);
			    cf.setEtat("non");
				session.save(cf); 
				session.getTransaction().commit(); 
				
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='Administration/doyen/Ajoutchef.jsp'</script></body></html>");
				 }

		} 
		 else if (action.equalsIgnoreCase("connexion")) 
			{
			 String email = request.getParameter("email");
			 String password = request.getParameter("password");
			 List<chef> ok = chefs.verif_chef(email, password);
			 int taille=ok.size();
			if (taille>0) {
				String nom=ok.get(0).getNom();
				int idchef=ok.get(0).getId();
				String prenom=ok.get(0).getPrenom();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession session = request.getSession(false);
				 //save message in session
				 session.setAttribute("matricule", email);
				 session.setAttribute("nom", nom);
				 session.setAttribute("prenom", prenom);
				 session.setAttribute("idchef", idchef);
				//System.out.println(idprof);
				//response.sendRedirect("professeurs/index.jsp");
					
					

				} else {
					response.sendRedirect("index.jsp");
					
				}
			}
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			
				int test_update=Integer.parseInt(id);
				String nom = request.getParameter("nom");
				 String password = request.getParameter("password");
					String prenom = request.getParameter("prenom");
					String adresse = request.getParameter("adresse");
					String email = request.getParameter("email");
					String num_tel = request.getParameter("num_tel");
					String departement = request.getParameter("departement");
				cf.setId(test_update);
				cf.setAdresse(adresse);
				cf.setPassword(password);
				cf.setEmail(email);
				cf.setNom(nom);
				cf.setNum_tel(num_tel);
				cf.setPrenom(prenom);
				cf.setDepartement(departement);
				
				chefs.Modifierchef(cf);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("Administration/doyen/modifierchef.jsp");

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
			 List<chef> ok = chefs.rech_chef(ids);
			 int taille=ok.size();
			if (taille>0) {
				String mdp=ok.get(0).getPassword();
				if(mdp.equals(pwd))
				{
					if(mdps.equals(pwds))
					{
					cf.setPassword(mdps);
					cf.setId(ids);
					chefs.ModifierMdp(cf);
				
					affiche.println("<html><body><script>alert('Opération réussit');"
							+ "                  document.location.href='chef_departement/mdp.jsp'</script></body></html>");
						
					}
					else
					{
						affiche.println("<html><body><script>alert('Les deux champs ne sont pas cohérent');"
								+ "                  document.location.href='chef_departement/mdp.jsp'</script></body></html>");
						
					}
				}
				else
				{
					affiche.println("<html><body><script>alert('votre mot de passe incorrect');"
							+ "                  document.location.href='chef_departement/mdp.jsp'</script></body></html>");	
				}
			}
			
	}
		 /********/
	}

}
