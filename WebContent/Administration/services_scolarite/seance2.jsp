<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="Model.seance"%>
            <%@page import="metier.seanceImp"%>
             <%@page import="metier.seanceInterface"%>
             
              <%@page import="Model.Salle"%>
            <%@page import="metier.salleImp"%>
             <%@page import="metier.salleInterface"%>
             
    <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>
 <%@page import="metier.professeursImp"%>
<%@page import="Model.Professeur"%>
<%@page import="metier.professeursInterface"%>
 <%@page import="metier.matiereImp"%>
<%@page import="Model.matiere"%>
<%@page import="metier.matiereInterface"%>
<%@page import="java.util.*" %>
<%@page import="org.hibernate.*" %>
<%@page import="util.HibernateUtil" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>UAS</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <style type="text/css">
	#test{
    animation: Test 1s infinite;
}
@keyframes Test{
    0%{opacity: 1;}
    50%{opacity: 0;}
    100%{opacity: 1;}
}
    
 
    </style>
  <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" href="../../css/formulaire.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../../plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="../../plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="../../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="../../plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="../../plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>U</b>AS</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>UAS</b>Université</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
         
          
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
             
               <span class="hidden-xs"><%out.println(session.getAttribute("role")); %></span>
            </a>
            <ul class="dropdown-menu">
              
              <!-- Menu Footer-->
              <li class="user-footer">
                
                <div class="pull-right">
                  <a href="deconnexion.jsp" class="btn btn-default btn-flat">Déconnexion</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar" style="width:300px;">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image" style="height:20px;">
          
        </div>
        <div class="pull-left info">
         
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
     
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      
      <%@ include file="menu.jsp" %>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="background:url('../../images/scolarité_fond.jpg');">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
      
    </section>
    <!-- Bloc container -->
    <div style="width:900px;margin: auto">
       
       <!-- Le contenu -->
       <hgroup>
  <%seance sean = new seance();
  String action = request.getParameter("action");
  if (action!=null) {
	   Session sessions = HibernateUtil.getSessionFactory().getCurrentSession(); 
	   seanceInterface seances = new seanceImp();
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
			
			 System.out.println("taille seance "+tailleseance+" taille salle "+taillesalle);
			 if(taille==1)
			 {
					/*affiche.println("<html><body><script>alert('cette seance existe');"
							+ "                  document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");*/
							 
 				%>
 					<h1 style="color:red;" id="test">Cette seance existe</h1>
 				
 				
 				<%
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
		        			
		        			
		    				sessions.beginTransaction();
		    				sean.setDate_debut(date_debut);
		    				sean.setDate_fin(date_fin);
		    				sean.setClasse(classe);
		    				sean.setMatiere(matiere);
		    				sean.setProf(prof);
		    				sean.setSalle(salle);
		    				sean.setJours(jours);
		    				sean.setEtat("non");
		    			  
		    				//sessions.save(sean); 
		    				//sessions.getTransaction().commit(); 
		    				 
		     				%>
		     					<h1 style="color:green;" id="test">salle occupé</h1>
		     				
		     				
		     				<%
		    			/*	affiche.println("<html><body><script>alert('Opération réussit');"
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
 				 //Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
	    				sessions.beginTransaction();
	    				sean.setDate_debut(date_debut);
	    				sean.setDate_fin(date_fin);
	    				sean.setClasse(classe);
	    				sean.setMatiere(matiere);
	    				sean.setProf(prof);
	    				sean.setSalle(salle);
	    				sean.setJours(jours);
	    				sean.setEtat("non");
	    			  
	    				sessions.save(sean); 
	    				sessions.getTransaction().commit(); 
	    				
	    				/*affiche.println("<html><body><script>alert('Opération réussit');"
	    						+ "document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");*/
 				 
 				%>
 					<h1 style="color:green;" id="test">Ajout de seance réussit</h1>
 				
 				
 				<%
 				 ///Fin traitement Ajout
 	        		}}
 			 }
					 
					 
					 
					 
					 
					 
					 
				/*****************/
 			
 			
 			
 			
 			/********Fin test disponibilité de salle******************/
 		}
 		 else
	           	 {
 			%>
				<h1 style="color:red;" id="test">salle occupé</h1>
			
			
			<%
	           	 }
 	 }
 	 else
 	 {
 		/* affiche.println("<html><body><script>alert('Ce proffesseur est occupé');"
						+"document.location.href='Administration/services_scolarite/seance.jsp'</script></body></html>");*/
						%>
						<h1 style="color:red;" id="test">Proffesseur occupé entre <%=debut %> et <%=fin %></h1>
						<%
 	 }
 	  //System.out.println(dbtab[0]+"\n"+dbform[0]+"\n"+dfform[0]);
   }
				   else // si tailleseance ==0
				   {
					   //test taille salle
					      if(taillesalle>0)
					      {
					    	  String debut= oksalle.get(0).getDate_debut();
					        	 String fin=oksalle.get(0).getDate_fin();
					        	 %>
									<h1 style="color:red;" id="test">salle occupé entre <%=debut %> et <%=fin %></h1>
									<% 
					    	  
					    	  
					      }
					      else  // si taillesalle ==0
					      {
					    	  if(tailleseance==0)
					    	  {
					    	  /// Il va ajouter
					    	  sessions.beginTransaction();
								sean.setDate_debut(date_debut);
								sean.setDate_fin(date_fin);
								sean.setClasse(classe);
								sean.setMatiere(matiere);
								sean.setProf(prof);
								sean.setSalle(salle);
								sean.setJours(jours);
								sean.setEtat("non");
							  
								sessions.save(sean); 
								sessions.getTransaction().commit(); 
								 
									%>
										<h1 style="color:green;" id="test">Ajout de seance réussit</h1>
									
									
									<%
					    	  
					    	  
					      }
					    	  else // taille salle !=0
							   {
					    		  String debut= okseance.get(0).getDate_debut();
						        	 String fin=okseance.get(0).getDate_fin();
						        	 %>
										<h1 style="color:red;" id="test">Prof occupé entre <%=debut %> et <%=fin %></h1>
										<% 
					    		  
					    		  
							   }
					      }
					   
				   }
	}	

	} 
	 
  
  %>
 
</hgroup>
<table width="30%" align="left">
<tr>
<td valign="top" colspan="2">
<form method="get"  id="form" style="float: left; width: 400px;height: 150px">
<div class="group">
   <label style="position: relative; top: 0px">Classe</label>
    <select name="id_classes" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				classeInterface cl=new classeImp();
				for(classe cls:cl.getALLClasses())
				{
				
				%>
    <option ><%=cls.getClass_nom() %></option>
  <%
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <button type="submit" class="button buttonBlue">Valider
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
  </form>
  </td>
  </tr>
  </table>
   <%
   
  String classes=request.getParameter("id_classes");
  



  if(classes!=null)
  {
  
  %>
  <form  method="post" id="form" style="float: right;">
  <table width="100%" align="right" >
 <tr>
  <td  width="50%" valign="top">
<div class="group" style="margin-bottom: -10px">
   <label style="position: relative; top: 0px">Matiere</label>
   <input type="hidden" name="id_classe" value="<%=classes%>">
    <select name="id_matiere" style="color: #636363" class="button" >
    <% 
    
				//pour parcourire le resultat users
				matiereInterface mat=new matiereImp();
				for(matiere mt:mat.getALLMatieres())
				{ 
					if(classes!=null)
					{
				 if(classes.equals(mt.getClasse()))
				 {
				%>
    <option ><%=mt.getMat_nom()%></option>
  <%
				 }
					}
					else
					{
						%>
						 <option ><%=mt.getMat_nom()%></option>
					<%}
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  </td>
  <td width="50%" valign="top">
  <div class="group">
   <label style="position: relative; top: 0px">Prof</label>
    <select name="id_prof" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				professeursInterface pf=new professeursImp();
				for(Professeur prof:pf.getALLProfs())
				{%>
    <option><%=prof.getPf_nom()+" "+prof.getPf_prenom() %></option>
  <%
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  </td>
  </tr>
  <tr>
  <td width="50%" valign="top">
  <div class="group">
  <label style="position: relative; top: 0px">Jour</label>
    <select name="jours">
      <option>Lundi</option>
      <option>Mardi</option>
      <option>Mercredi</option>
      <option>Jeudi</option>
      <option>Vendredi</option>
      <option>Samedi</option>
    </select>
    <span class="highlight"></span>
    
  </div>
  </td>
  <td width="50%" valign="top">
   <div class="group" style="position: relative; top:-4px">
  <label style="position: relative; top: 0px">Salle</label>
    <select name="id_salle" style="color: #636363" class="button" >
   <%
    salleInterface sl=new salleImp();
				for(Salle sal:sl.getALLSalles())
				{%>
    <option><%=sal.getSall_nom() %></option>
  <%
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  
  
  </td>
  </tr>
  <tr>
  <td>
  <div class="group">
  <input type="hidden" name="action" value="ajout">
  <label style="position: relative; top: 0px">Heure Début</label>
    <input style="position: relative; top: 0px" type="time" name="date_debut" required="required" >
    <span class="highlight"></span>
    
  </div>
   
   </td>
 <td>
    <div class="group">
  <label style="position: relative; top: 0px">Heure Fin</label>
    <input type="time" name="date_fin" placeholder="masse horaire" required="required">
    <span class="highlight"></span>
    
  </div>
   </td>
   </tr>
   <tr>
   <td colspan="2">
    
  
  
  <button type="submit" class="button buttonBlue">Créer Seance
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
  </td>
  </tr>
  
</form>
   <%
   
   }
   %>    
</td>
</tr>
 </table>

      
      <!-- Fin contenu -->
</div>


<!-- jQuery 2.2.0 -->
<script src="../../plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.5 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->

<script src="../../plugins/morris/morris.min.js"></script>

<script src="../../dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->

<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
</body>
</html>
