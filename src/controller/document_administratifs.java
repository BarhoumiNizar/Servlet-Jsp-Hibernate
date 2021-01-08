package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.documentsImp;
import metier.documentsInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.document_administratif;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="document_administratif", urlPatterns = { "/document_administratif" })
public class document_administratifs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private documentsInterface documents;
	public document_administratifs() {
		super();
		documents = new documentsImp();
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
		document_administratif document = new document_administratif();
		if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 String etat = request.getParameter("etat");
			 String date = request.getParameter("date");
				int test_update=Integer.parseInt(id);
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				  String now=sdf.format(new Date());
				document.setId(test_update);
				document.setEtat(etat);
				document.setDate(date);
				document.setDate_validation(now);
				System.out.println(now);
				documents.RepondreDemande(document, etat,now);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("Administration/services_scolarite/documents_Administratifs.jsp");

			} 
		else if (action.equalsIgnoreCase("vu")) {
			 String id = request.getParameter("id");
			 String etat = request.getParameter("etat");
				int test_update=Integer.parseInt(id);
				document.setId(test_update);
				document.setEtat(etat);
				System.out.println(test_update);
				documents.consulterDemande(document, etat);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("etudiants/etat_demande.jsp");

			} 
		else if (action.equalsIgnoreCase("delete")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			documents.deletedocument(idDelete);;
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("Administration/services_scolarite/supprimer_document.jsp");
			
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
		document_administratif document = new document_administratif();
		//String id = request.getParameter("id");
		PrintWriter affiche=response.getWriter();
		 if (action.equalsIgnoreCase("ajout")) {
			 String etudiant = request.getParameter("etudiant");
			 String type_document = request.getParameter("type_document");
			 String etat = request.getParameter("etat");
			 String date = request.getParameter("date");
			List<document_administratif> ok=documents.verifdemande(etudiant, type_document);
				int taille=ok.size();
				System.out.println(taille);
				if(type_document.equalsIgnoreCase("attestation inscription"))
				{
					if(taille==1)
					{
						affiche.println("<html><body><script>alert('Vous avez dépassé la limite de demande autorisé');"
								+ "                  document.location.href='etudiants/attestation.jsp'</script></body></html>");
					}
					else if(taille==0)
					{
						Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
						session.beginTransaction();
						document.setEtat(etat);
						document.setEtudiant(etudiant);
						document.setType_document(type_document);
						document.setVu("en cour");
					    document.setDate(date);
					    document.setDate_validation("non_valide");
					    document.setEtats("non");
						session.save(document); 
						session.getTransaction().commit();
						affiche.println("<html><body><script>alert('Votre demande est enregistrée');"
								+ "                  document.location.href='etudiants/attestation.jsp'</script></body></html>");
					}
				}
			else if(type_document.equalsIgnoreCase("attestation presence"))
				{
				if(taille<3)
				{
					Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
					session.beginTransaction();
					document.setEtat(etat);
					document.setEtudiant(etudiant);
					document.setType_document(type_document);
					document.setVu("en cour");
				    document.setDate(date);
				    document.setDate_validation("non_valide");
				    document.setEtats("non");
					session.save(document); 
					session.getTransaction().commit();
					affiche.println("<html><body><script>alert('Votre demande est enregistrée');"
							+ "                  document.location.href='etudiants/attestation.jsp'</script></body></html>");
				}
				else 
					{
						affiche.println("<html><body><script>alert('Vous avez dépassé la limite de demande autorisé');"
								+ "                  document.location.href='etudiants/attestation.jsp'</script></body></html>");
					}
					 
				}
				
			else if(type_document.equalsIgnoreCase("attesation de reussite"))
			{
			if(taille==0)
			{
				Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				document.setEtat(etat);
				document.setEtudiant(etudiant);
				document.setType_document(type_document);
				document.setVu("en cour");
			    document.setDate(date);
			    document.setDate_validation("non_valide");
			    document.setEtats("non");
				session.save(document); 
				session.getTransaction().commit();
				affiche.println("<html><body><script>alert('Votre demande est enregistrée');"
						+ "                  document.location.href='etudiants/attestation.jsp'</script></body></html>");
			}
			else 
				{
					affiche.println("<html><body><script>alert('Vous avez dépassé la limite de demande autorisé');"
							+ "                  document.location.href='etudiants/attestation.jsp'</script></body></html>");
				}
				 
			}
		

		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 String type_document = request.getParameter("type_document");
			 String date = request.getParameter("date");
			 
			  String classe=request.getParameter("classe");
			  
				int test_update=Integer.parseInt(id);
				document.setType_document(type_document);
				document.setId(test_update);
				document.setDate(date);
				
				documents.Modifierdocument(document);
				// pour faire l'actualisation de page accueil.jsp

				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='etudiants/modifier_document.jsp'</script></body></html>");

			} 
		 
		 
	}

}
