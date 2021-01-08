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


import metier.payementImp;
import metier.payementInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.Payement;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="payement", urlPatterns = { "/payement" })
public class payements extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private payementInterface payements;
	public payements() {
		super();
		payements = new payementImp();
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
			payements.deletepayement(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("Administration/services_scolarite/supprimer_payement.jsp");
			
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
		Payement payer= new Payement();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String py_tranche = request.getParameter("py_tranche");
			 String py_date = request.getParameter("py_date");
			
			 String et_matricule = request.getParameter("et_matricule");
				
			 List<Payement> ok =payements.verifPayement(et_matricule);
			 int taille=ok.size();
			 PrintWriter affiche=response.getWriter();
			 if(taille==1)
			 {
					affiche.println("<html><body><script>alert('Payement existe');"
							+ "                  document.location.href='Administration/services_scolarite/payement.jsp'</script></body></html>");
			 }
			 else if(taille==0)
			 {
				
				
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				payer.setEt_matricule(et_matricule);
				payer.setPy_date(py_date);
				payer.setPy_tranche(py_tranche);
			    payer.setEtat("non");
			  
				session.save(payer); 
				session.getTransaction().commit(); 
				//PrintWriter affiche=response.getWriter();
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='Administration/services_scolarite/payement.jsp'</script></body></html>");
			 }

		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 
				int test_update=Integer.parseInt(id);
				String py_tranche = request.getParameter("py_tranche");
				 String py_date = request.getParameter("py_date");
				
				 String et_matricule = request.getParameter("et_matricule");
				 payer.setId(test_update);
				payer.setEt_matricule(et_matricule);
				payer.setPy_date(py_date);
				payer.setPy_tranche(py_tranche);
				payements.Modifierpayement(payer);
				// pour faire l'actualisation de page accueil.jsp
				PrintWriter affiche=response.getWriter();
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='Administration/services_scolarite/modifier_payement.jsp'</script></body></html>");

			} 
		 
	}

}
