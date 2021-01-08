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

import metier.notificationImp;
import metier.notificationInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.notification;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="notification", urlPatterns = { "/notification" })
public class notifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private notificationInterface notifications;
	public notifications() {
		super();
		notifications = new notificationImp();
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
			notifications.deleteNotification(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("professeurs/supprimer_notification.jsp");
			
		}
		else if (action.equalsIgnoreCase("vu")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			notifications.VuNotification(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("etudiants/notifications.jsp");
			
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
		notification ntf = new notification();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String date = request.getParameter("date_notification");
			
			 String type = request.getParameter("type");
			 String contenu = request.getParameter("contenu");
			 String classe = request.getParameter("class");
			// String etat = request.getParameter("etat");
			 String prof = request.getParameter("prof");
			List<notification> ok=notifications.verifnotification(classe, type, date);
			int taille=ok.size();
			PrintWriter affiche=response.getWriter();
			 if(taille==1)
			 {
					affiche.println("<html><body><script>alert('Cette notification est déja enregistré');"
							+ "                  document.location.href='professeurs/notifications.jsp'</script></body></html>");
			 }
			 else if(taille==0)
			 {
			 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				ntf.setContenu(contenu);
				ntf.setDate_notification(date);
				ntf.setType(type);
				ntf.setClasse(classe);
				ntf.setEtat("non");
			    ntf.setProf(prof);
			  
				session.save(ntf); 
				session.getTransaction().commit(); 
			
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "                  document.location.href='professeurs/notifications.jsp'</script></body></html>");
			 }

		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
			 String prof = request.getParameter("prof");
				int test_update=Integer.parseInt(id);
				String date = request.getParameter("date_notification");
				
				 String type = request.getParameter("type");
				 String contenu = request.getParameter("contenu");
				 String classe = request.getParameter("classe");
				 List<notification> ok=notifications.verifnotification(classe, type, date);
					int taille=ok.size();
					PrintWriter affiche=response.getWriter();
					 if(taille==1)
					 {
							affiche.println("<html><body><script>alert('Cette notification est déja enregistré');"
									+ "                  document.location.href='professeurs/modifier_notification.jsp'</script></body></html>");
					 }
					 else if(taille==0)
					 {
				 ntf.setContenu(contenu);
					ntf.setDate_notification(date);
					ntf.setType(type);
					ntf.setClasse(classe);
					ntf.setId(test_update);
					ntf.setProf(prof);
					ntf.setEtat("ok");
					notifications.ModifierNotification(ntf);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("professeurs/modifier_notification.jsp");
					 }
			} 
		 
	}

}
