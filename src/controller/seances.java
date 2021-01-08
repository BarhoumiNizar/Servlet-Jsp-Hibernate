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

import metier.seanceImp;
import metier.seanceInterface;

import org.hibernate.Session;

import util.HibernateUtil;
import Model.Professeur;
import Model.seance;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name ="seance", urlPatterns = { "/seance" })
public class seances extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private carriereInterface carrieres;
	private seanceInterface seances;
	public seances() {
		super();
		seances = new seanceImp();
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
			seances.deleteseance(idDelete);
			//request.setAttribute("users", userinterface.getALLUsers());
			//page = "/accueil.jsp";
			//request.getRequestDispatcher("accueil.jsp").forward(request, response);
			response.sendRedirect("Administration/services_scolarite/supprimer_seance.jsp");
			
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
		seance sean = new seance();
		//String id = request.getParameter("id");

		 if (action.equalsIgnoreCase("ajout")) {
			 String date_debut = request.getParameter("date_debut");
				String date_fin = request.getParameter("date_fin");
				String jours = request.getParameter("jours");
				String prof = request.getParameter("id_prof");
				
				String salle = request.getParameter("id_salle");
				
				String matiere = request.getParameter("id_matiere");
				
				String classe = request.getParameter("id_classe");
				List<seance> ok =seances.verifseance(matiere, classe,jours);
				List<seance> okseance =seances.verifseances(prof,jours);
				List<seance> oksalle =seances.verifsalle(salle, jours);
				 int taille=ok.size();
				 int taillesalle=oksalle.size();
				 int tailleseance=okseance.size();
				 PrintWriter affiche=response.getWriter();
				 System.out.println("taille seance "+tailleseance+" taille salle "+taillesalle);
				 if(taille==1)
				 {
						affiche.println("<html><body><script>alert('cette seance existe');"
								+ "                  document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");
				 }
				 else if(taille==0)
				 {
					
						 
			 if(tailleseance>0)
          {
        	 String debut= okseance.get(0).getDate_debut();
        	 String fin=okseance.get(0).getDate_fin();
        	 String[] dbtab=debut.split(":");
        	 String[] dbtabFin=fin.split(":");
        	 String[] dbform=date_debut.split(":");
        	 String[] dfform=date_fin.split(":");
        	 int dbtableH=Integer.parseInt(dbtab[0]);
        	 int dbtableFinH=Integer.parseInt(dbtabFin[0]);
        	 int dbformeH=Integer.parseInt(dbform[0]);
        	 int dfformeH=Integer.parseInt(dfform[0]);
        	 /**********/
        	 int dbtableM=Integer.parseInt(dbtab[1]);
        	 int dbtableFinM=Integer.parseInt(dbtabFin[1]);
        	 int dbformeM=Integer.parseInt(dbform[1]);
        	 int dfformeM=Integer.parseInt(dfform[1]);
            /***debut formulaire****/
        	 double dbfm=(double)dbformeM/100;
        	 double dbfom=((double)dbformeH+dbfm);
        	 /***fin formulaire****/
        	 double dbFfm=(double)dfformeM/100;
        	 double dbFfom=((double)dfformeH+dbFfm);
        	 
        	 /***debut table****/
        	 double dbtable=(double)dbtableM/100;
        	 double dbtbl=((double)dbtableH+dbtable);
        	 double diff=dbfom-dbtbl;
        	 /***fin table****/
        	 double dftable=(double)dbtableFinM/100;
        	 double dftbl=((double)dbtableFinH+dftable);
        	 double dif=dftbl-dbfom;
        	// System.out.println("debut form "+dbfom+"\n debut date "+dbtbl+"\n fin form "+dbFfom);
        	 if(dbtbl>dbfom || dftbl<dbfom)
        	 {
        		if(dbtbl>dbFfom || dftbl<dbFfom)
        		{
        		  	/*******test disponibilité salle******/
        		
        			 if(taillesalle>0) 
					 {
        				 
					/*******traitement seance**********/
						 String debutsalle= oksalle.get(0).getDate_debut();
			        	 String finsalle=oksalle.get(0).getDate_fin();
			        	 String[] dbtabsalle=debutsalle.split(":");
			        	 String[] dbtabFinsalle=finsalle.split(":");
			        	 String[] dbformsalle=date_debut.split(":");
			        	 String[] dfformsalle=date_fin.split(":");
			        	 int dbtableHsalle=Integer.parseInt(dbtabsalle[0]);
			        	 int dbtableFinHsalle=Integer.parseInt(dbtabFinsalle[0]);
			        	 int dbformeHsalle=Integer.parseInt(dbformsalle[0]);
			        	 int dfformeHsalle=Integer.parseInt(dfformsalle[0]);
			        	 /**********/
			        	 int dbtableMsalle=Integer.parseInt(dbtabsalle[1]);
			        	 int dbtableFinMsalle=Integer.parseInt(dbtabFinsalle[1]);
			        	 int dbformeMsalle=Integer.parseInt(dbformsalle[1]);
			        	 int dfformeMsalle=Integer.parseInt(dfformsalle[1]);
			            /***debut formulaire****/
			        	 double dbfmsalle=(double)dbformeMsalle/100;
			        	 double dbfomsalle=((double)dbformeHsalle+dbfmsalle);
			        	 /***fin formulaire****/
			        	 double dbFfmsalle=(double)dfformeMsalle/100;
			        	 double dbFfomsalle=((double)dfformeHsalle+dbFfmsalle);
			        	 
			        	 /***debut table****/
			        	 double dbtablesalle=(double)dbtableMsalle/100;
			        	 double dbtblsalle=((double)dbtableHsalle+dbtablesalle);
			        	 double diffsalle=dbfomsalle-dbtblsalle;
			        	 /***fin table****/
			        	 double dftablesalle=(double)dbtableFinMsalle/100;
			        	 double dftblsalle=((double)dbtableFinHsalle+dftablesalle);
			        	 double difsalle=dftblsalle-dbfomsalle;
			        	// System.out.println("debut form "+dbfom+"\n debut date "+dbtbl+"\n fin form "+dbFfom);
			        	 if(dbtblsalle>dbfomsalle || dftblsalle<dbfomsalle)
			        	 {
			        		if(dbtblsalle>dbFfomsalle || dftblsalle<dbFfomsalle)
			        		{
			        			/*****Ajout seance*********/
			        			
			        			/****Traitement Ajout de seance****/
			        			
			        			Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			    				session.beginTransaction();
			    				sean.setDate_debut(date_debut);
			    				sean.setDate_fin(date_fin);
			    				sean.setClasse(classe);
			    				sean.setMatiere(matiere);
			    				sean.setProf(prof);
			    				sean.setSalle(salle);
			    				sean.setJours(jours);
			    				sean.setEtat("non");
			    			  
			    				session.save(sean); 
			    				session.getTransaction().commit(); 
			    		
			    				affiche.println("<html><body><script>alert('Opération réussit');"
			    						+ "document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");
			        			
			        		/*****Fin traitement de seance*************************/

			        			/******Fin Ajout seance***********/
			        		}
			        	 }
			        	 else{
			        		 System.out.println("not ajout");
			        	 }
			        		}
        			 /******si salle n'existe pas********/
        			 else{
        				 
        				///traitement Ajout salle
        				 if(dbtbl>dbfom || dftbl<dbfom)
        	        	 {
        	        		if(dbtbl>dbFfom || dftbl<dbFfom)
        	        		{
        				 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		    				session.beginTransaction();
		    				sean.setDate_debut(date_debut);
		    				sean.setDate_fin(date_fin);
		    				sean.setClasse(classe);
		    				sean.setMatiere(matiere);
		    				sean.setProf(prof);
		    				sean.setSalle(salle);
		    				sean.setJours(jours);
		    				sean.setEtat("non");
		    			  
		    				session.save(sean); 
		    				session.getTransaction().commit(); 
		    		
		    				affiche.println("<html><body><script>alert('Opération réussit');"
		    						+ "document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");
        				 
        				 
        				 ///Fin traitement Ajout
        	        		}}
        			 }
						 
						 
						 
						 
						 
						 
						 
					/*****************/
        			
        			
        			
        			
        			/********Fin test disponibilité de salle******************/
        		}
        		 else
		           	 {
		           		 System.out.println("non non non ");
		           	 }
        	 }
        	 else
        	 {
        		 affiche.println("<html><body><script>alert('Ce proffesseur est occupé');"
    						+"document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");
        	 }
        	  //System.out.println(dbtab[0]+"\n"+dbform[0]+"\n"+dfform[0]);
          }
          else
          {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
				session.beginTransaction();
				sean.setDate_debut(date_debut);
				sean.setDate_fin(date_fin);
				sean.setClasse(classe);
				sean.setMatiere(matiere);
				sean.setProf(prof);
				sean.setSalle(salle);
				sean.setJours(jours);
				sean.setEtat("non");
			  
				session.save(sean); 
				session.getTransaction().commit(); 
		
				affiche.println("<html><body><script>alert('Opération réussit');"
						+ "document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");
          }
				 }	

		} 
		 else if (action.equalsIgnoreCase("update")) {
			 String id = request.getParameter("id");
				int test_update=Integer.parseInt(id);
				String date_debut = request.getParameter("date_debut");
				String date_fin = request.getParameter("date_fin");
				String prof = request.getParameter("id_prof");
				String jours = request.getParameter("jours");
				
				String salle = request.getParameter("id_salle");
				
				String matiere = request.getParameter("id_matiere");
				
				String classe = request.getParameter("id_classe");
				
				String nom = request.getParameter("nom");
				sean.setDate_debut(date_debut);
				sean.setDate_fin(date_fin);
				sean.setClasse(classe);
				sean.setMatiere(matiere);
				sean.setProf(prof);
				sean.setSalle(salle);
				sean.setJours(jours);
				sean.setId(test_update);
				sean.setEtat("ok");
				
				seances.Modifierseance(sean);
				// pour faire l'actualisation de page accueil.jsp
				response.sendRedirect("Administration/services_scolarite/modifier_seance.jsp");

			} 
		/* else if (action.equalsIgnoreCase("recherche")) 
			{
			 String jour = request.getParameter("jour");
			
			 List<seance> ok = seances.Emploiseance(jour);
			 int taille=ok.size();
			if (taille>0) {
				

				} else {
					response.sendRedirect("index.jsp");
					
				}
			}*/

	}

}
