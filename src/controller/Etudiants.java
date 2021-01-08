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

import metier.EtudiantImp;
import metier.EtudiantInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.Administration;
import Model.Etudiant;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="etudiant", urlPatterns = { "/etudiant" })
public class Etudiants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private EtudiantInterface Etudiants;
	public Etudiants() {
		super();
		Etudiants = new EtudiantImp();
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
			Etudiants.deleteEtudiant(idDelete);
			
			response.sendRedirect("Administration/services_scolarite/etudiant_supprimer.jsp");
			
		}
		else if (action.equalsIgnoreCase("valider")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			Etudiants.ValiderEtudiant(idDelete);
			
			response.sendRedirect("Administration/services_scolarite/etudiant_valider.jsp");
			
		}
		else if (action.equalsIgnoreCase("statistique")) 
		{
		
		 List<Etudiant> ok = Etudiants.StatistiqueSexeMasculin();
		 List<Etudiant> fm = Etudiants.StatistiqueSexeFeminin();
		 List<Etudiant> tot = Etudiants.getALLEtudiants();
		 int masculin=ok.size();
		 int feminin=fm.size();
		 int total=tot.size();
		if (masculin>0) {
			String classe=ok.get(0).getClasse();
			
			//if request is not from HttpServletRequest, you should do a typecast before
			 HttpSession session = request.getSession(false);
			 //save message in session
			
			String prMas="Pourcentage des masculin = "+(100*masculin)/total+"%\n";
			String prFm="Pourcentage des Feminins = "+(100*feminin)/total+"%\n";
			//System.out.println(prMas);
			request.setAttribute("prMas", prMas);
				request.getRequestDispatcher("Administration/president/statistiqueSexe.jsp").forward(request, response);
				

			} else {
				response.sendRedirect("index.jsp");
				
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
		
		// objet use pour envoyer l'id passé en parametre
		Etudiant etud = new Etudiant();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String matricule = request.getParameter("matricule");
				String et_email = request.getParameter("email");
				String et_nom = request.getParameter("nom");
				String password = request.getParameter("password");
				String et_prenom = request.getParameter("prenom");
				String et_date_naissance = request.getParameter("naissance");
				String et_sexe = request.getParameter("sexe");
				String etat = request.getParameter("etat");
				String et_nationalite = request.getParameter("nationalite");
				String et_num_tel = request.getParameter("tel");
				String et_adresse = request.getParameter("adresse");
				String et_dernier_etablissement = request.getParameter("etablissement");
				String classe = request.getParameter("class");
				String etudiant = request.getParameter("etudiant");
				String filiere = request.getParameter("filiere");
				List<Etudiant> ok = Etudiants.verif_etudiants(matricule, et_email,et_num_tel);
				 int taille=ok.size();
				 PrintWriter affiche=response.getWriter();
				 if(taille==1)
				 {
					 if(etudiant.equalsIgnoreCase("etudiant"))
						{affiche.println("<html><body><script>alert('Etudiant Existe');"
								+ "                  document.location.href='index.jsp'</script></body></html>");}
						if(etudiant.equalsIgnoreCase("etudiants"))
						{affiche.println("<html><body><script>alert('Etudiant Existe');"
								+ "                  document.location.href='Administration/services_scolarite/etudiant_inscription.jsp'</script></body></html>");}
					
						 
				 }
				 else if(taille==0)
				 {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
			
			   etud.setEt_adresse(et_adresse);
			   etud.setEt_date_naissance(et_date_naissance);
			   etud.setEt_dernier_etablissement(et_dernier_etablissement);
			   etud.setEt_email(et_email);
			   etud.setEt_nationalite(et_nationalite);
			   etud.setEt_nom(et_nom);
			   etud.setPassword(password);
			   etud.setEt_num_tel(et_num_tel);
			   etud.setEt_prenom(et_prenom);
			   etud.setEt_sexe(et_sexe);
			   etud.setClasse(classe);
			   etud.setMatricule(matricule);
			   etud.setEtat(etat);
			   etud.setFiliere(filiere);
			   etud.setEtats("non");
				session.save(etud); 
				session.getTransaction().commit(); 
				
				if(etudiant.equalsIgnoreCase("etudiant"))
				{affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='index.jsp'</script></body></html>");}
				if(etudiant.equalsIgnoreCase("etudiants"))
				{affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='Administration/services_scolarite/etudiant_inscription.jsp'</script></body></html>");}
			
				 }
		} 
		 else if (action.equalsIgnoreCase("connexion")) 
			{
			 String matricule = request.getParameter("matricule");
			 String password = request.getParameter("password");
			 List<Etudiant> ok = Etudiants.verif_etudiant(matricule, password);
			 int taille=ok.size();
			if (taille>0) {
				String classe=ok.get(0).getClasse();
				String prenom=ok.get(0).getEt_prenom();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession session = request.getSession(false);
				 //save message in session
				 session.setAttribute("matricule", matricule);
				 session.setAttribute("classe", classe);
				 session.setAttribute("prenom", prenom);
				
				 // System.out.println(taille);
				response.sendRedirect("etudiants/index.jsp");
					
					

				} else {
					response.sendRedirect("index.jsp");
					
				}
			}
		 
		 else if (action.equalsIgnoreCase("update")) {
			 String idmodif = request.getParameter("id");
			 String matricule = request.getParameter("matricule");
				String et_email = request.getParameter("email");
				String et_nom = request.getParameter("nom");
				String et_prenom = request.getParameter("prenom");
				String et_date_naissance = request.getParameter("naissance");
				String et_sexe = request.getParameter("sexe");
				String etat = request.getParameter("etat");
				String et_nationalite = request.getParameter("nationalite");
				String et_num_tel = request.getParameter("tel");
				String et_adresse = request.getParameter("adresse");
				String et_dernier_etablissement = request.getParameter("etablissement");
				String classe = request.getParameter("class");
				
				int test_update=Integer.parseInt(idmodif);
				List<Etudiant> okmodif = Etudiants.verif_etudiant_modif(et_email, et_num_tel);
				 int taillemodif=okmodif.size();
				 PrintWriter affiche=response.getWriter();
				 if(taillemodif==1)
				 {
					 affiche.println("<html><body><script>alert('Etudiant Existe');"
								+ "                  document.location.href='Administration/services_scolarite/etudiant_modifier.jsp'</script></body></html>");
					
						 
				 }
				 else if(taillemodif==0)
				 {
				etud.setId(test_update);
				 etud.setEt_adresse(et_adresse);
				   etud.setEt_date_naissance(et_date_naissance);
				   etud.setEt_dernier_etablissement(et_dernier_etablissement);
				   etud.setEt_email(et_email);
				   etud.setEt_nationalite(et_nationalite);
				   etud.setEt_nom(et_nom);
				   etud.setEt_num_tel(et_num_tel);
				   etud.setEt_prenom(et_prenom);
				   etud.setEt_sexe(et_sexe);
				   etud.setClasse(classe);
				   etud.setMatricule(matricule);
				   
				   Etudiants.ModifierEtudiant(etud);
				// pour faire l'actualisation de page accueil.jsp
				   affiche.println("<html><body><script>alert('Etudiant Modifié');"
							+ "document.location.href='Administration/services_scolarite/etudiant_modifier.jsp'</script></body></html>");
					 //}
			} 
		 //Modifier PAssword
		 else if (action.equalsIgnoreCase("modifier_mdp")) 
			{
			
			 String id = request.getParameter("id");
			 String pwd = request.getParameter("mdp");
			 String mdps = request.getParameter("mdps");
			 String pwds = request.getParameter("pwds");
			 int ids=Integer.parseInt(id);
			 List<Etudiant> ok = Etudiants.rech_etudiant(ids);
			 int taille=ok.size();
		
			if (taille>0) {
				String mdp=ok.get(0).getPassword();
				if(mdp.equals(pwd))
				{
					if(mdps.equals(pwds))
					{
					etud.setPassword(mdps);
					etud.setId(ids);
					Etudiants.ModifierMdp(etud);
				
					affiche.println("<html><body><script>alert('Opération réussit');"
							+ "                  document.location.href='etudiants/mdp.jsp'</script></body></html>");
						
					}
					else
					{
						affiche.println("<html><body><script>alert('Les deux champs ne sont pas cohérent');"
								+ "                  document.location.href='etudiants/mdp.jsp'</script></body></html>");
						
					}
				}
				else
				{
					affiche.println("<html><body><script>alert('votre mot de passe incorrect');"
							+ "                  document.location.href='etudiants/mdp.jsp'</script></body></html>");	
				}
			}
			
	}
		 
	}

	}}
