<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="metier.administrationImp"%>
      <%@page import="metier.administrationInterface"%>
       <%@page import="Model.Administration"%>
         <%@page import="metier.EtudiantImp"%>
      <%@page import="metier.EtudiantInterface"%>
       <%@page import="Model.Etudiant"%>
       <%@page import="metier.professeursImp"%>
      <%@page import="metier.professeursInterface"%>
       <%@page import="Model.Professeur"%>
        <%@page import="metier.chefImp"%>
      <%@page import="metier.chefInterface"%>
       <%@page import="Model.chef"%>
       <%@page import="java.util.List"%>
       <%@page import="org.hibernate.Session"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/espace_intranet.css" />
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
	
	<link rel="stylesheet" type="text/css" href="css/popup2.css" />
	    <link rel="stylesheet" type="text/css" href="css/style2.css" />

	<!--carousel-->
	<link rel="stylesheet" href="css/demonstration.css" />
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/billy.carousel.jquery.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(document).ready( function() {
		
		// ----- Carousel
			$('#billy_scroller').billy({
				slidePause: 5000,
				// We need custom next/prev buttons for this example. If we used the defaults (#billy_next/#billy_prev), every carousel instance on the page would scroll when they're clicked...
				nextLink: $('#carousel_billy_next'),
				prevLink: $('#carousel_billy_prev'),
			});
			
		
			
		});
				
	</script>
	
	<!--Fin carousel-->
	
</head>
<body>
<header style="background-image: url(img/fondHeader.jpg); height:185px;">
<div id="header-wrapper" style="background: transparent;" >
	<div id="header" class="container" >
	<div style="width:95%;">
	<div style="width:250px; float:right;padding-top:20px">
	<p class="espaceintranet">Login Intranet</p>
	<section id="facebook">
<ul>
<a href="#popup1" ><span id="fackbook" class="tooltip" title="Espace Etudiants"><img src="images/etudiant.jpg" style="position:relative;top:-20px; border-radius:50%"/></span></a>
</ul>
</section>
 
<section id="twitter">
<ul> 
<a href="#popup2"><span id="twitter-default" class="tooltip" title="Espasse Enseignants"><img src="images/enseignant.jpg" style="position:relative;top:-20px; border-radius:50%"/></span></a>
</ul>
</section>
 
 
<section id="google">
<ul> 
<a href="#popup3" ><span id="google-default" class="tooltip" title="Espace Administration">
<img src="images/administration.jpg" style="position:relative;top:-20px; border-radius:50%"/></span></a>
</ul>
</section>
 


</div>
	</div>
		<div id="logo">
        	
			


		</div>
		
	</div>
</div>


<!-- iclusion Menu-->
  <%@ include file="menu.html" %>  

		</header>
		
<!--Les popups-->
<!--Popup Etudiant-->
<div id="popup1" class="overlay" style="z-index:25">
	<div class="popup">
	<table >
	<tr><td width="400" align="center">
		<h2 >Espace Etudiant</h2>
		</td></tr>
		<a class="close" href="#">&times;</a>
		<div class="content" style=" width:300px">
		
			<form method="post">
			<input type="hidden" name="action" value="connexion">
			<tr><td width=400 align="center"><input type="text" placeholder="Votre matricule..." name="matricule"></td></tr>
			<tr><td width=400 align="center"><input type="password" placeholder="Votre password" name="password"></td></tr>
			<tr><td width=400 align="center"><input type="submit" value="Connexion" class="button"></td></tr>
			</form>
			<form action="etudiants/inscriptions.jsp" >
			<tr><td width=400 align="center"><input type="submit" value="Inscription" class="button"></td></tr>
			
			</form>
			
			<%
			EtudiantInterface Etudiants = new EtudiantImp();
			String matricule = request.getParameter("matricule");
			 String passwordetud = request.getParameter("password");
			 if(matricule!=null)
			 {
			 List<Etudiant> oketud = Etudiants.verif_etudiant(matricule, passwordetud);
			 int tailleetud=oketud.size();
			if (tailleetud>0) {
				String classe=oketud.get(0).getClasse();
				String prenom=oketud.get(0).getEt_prenom();
				int idetud=oketud.get(0).getId();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession sessionsEtud = request.getSession(false);
				 //save message in session
				 sessionsEtud.setAttribute("matricule", matricule);
				 sessionsEtud.setAttribute("classe", classe);
				 sessionsEtud.setAttribute("prenom", prenom);
				 sessionsEtud.setAttribute("idetud", idetud);
				 // System.out.println(taille);
				response.sendRedirect("etudiants/index.jsp");
					
					

				} else {
                    %>
					
					<tr><td style="width:300px;" align="center"><font color="red" style="font-size: 18px">Vos identifiants sont érronnées</font></td></tr>
					<%
					
				}
			 }
			
			
			%>
			</table>
		</div>
	</div>
</div>
<!--Popup Enseignant-->
<div id="popup2" class="overlay" style="z-index:25">
	<div class="popup" style="">
		<table    >
		<tr><td width=400>
		<h2 >Espace Enseignant</h2>
		</td></tr>
		<a class="close" href="#">&times;</a>
		<div class="content" style=" width:300px;">
			
			<form method="post">
			<input type="hidden" name="action" value="connexion">
			<tr><td width=400 align="center"><input type="text" name="email" placeholder="Votre email..."></td></tr>
			<tr><td width=400 align="center"><input type="password" placeholder="Votre password" name="password"></td></tr>
			<tr><td width=400 align="center"><input type="submit" value="Connexion" class="button"></td></tr>
			</form>
			<%
			professeursInterface Professeur=new professeursImp();
			chefInterface chefs=new chefImp();
			String email = request.getParameter("email");
			 String passwordprof = request.getParameter("password");
			 if(email!=null)
			 {
			 List<Professeur> okprof = Professeur.verif_prof(email, passwordprof);
			 List<chef> okchef = chefs.verif_chef(email, passwordprof);
			 int tailleprof=okprof.size();
			 int taillechef=okchef.size();
			if (tailleprof>0) {
				String nom=okprof.get(0).getPf_nom();
				String prenom=okprof.get(0).getPf_prenom();
				int idprof=okprof.get(0).getId();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession sessionprof = request.getSession(false);
				 //save message in session
				 sessionprof.setAttribute("matricule", email);
				 sessionprof.setAttribute("nom", nom);
				 sessionprof.setAttribute("prenom", prenom);
				 sessionprof.setAttribute("idprof", idprof);
				//System.out.println(nom);
				response.sendRedirect("professeurs/index.jsp");
					
					

				}
			
			else if (taillechef>0) {
				String nom=okchef.get(0).getNom();
				String prenom=okchef.get(0).getPrenom();
				int idchef=okchef.get(0).getId();
				String departement=okchef.get(0).getDepartement();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession sessionprof = request.getSession(false);
				 //save message in session
				 sessionprof.setAttribute("matricule", departement);
				 sessionprof.setAttribute("nom", nom);
				 sessionprof.setAttribute("prenom", prenom);
				 sessionprof.setAttribute("idchef", idchef);
				 sessionprof.setAttribute("departement", departement);
				//System.out.println(nom);
				response.sendRedirect("chef_departement/index.jsp");
					
					

				}
			else {
%>
					
					<tr><td style="width:300px;" align="center"><font color="red" style="font-size: 18px">Vos identifiants sont érronnées</font></td></tr>
					<%
					
				}
			 }
			
			%>
			</table>
		</div>
	</div>
</div>
<!--Popup Administartion-->
<div id="popup3" class="overlay" style="z-index:25">
	<div class="popup" style="width:400px">
	<table    >
		<tr><td width=400><h2 >Espace Administration</h2></td>
		<a class="close" href="#">&times;</a>
		<div class="content" style=" width:300px">
			
			<form method="post" >
			<input type="hidden" name="action" value="connexion">
			<tr><td width=400 ><center><input type="text" placeholder="Votre login..." name="login"></center></td></tr>
			<tr><td width=400><center><input type="password" placeholder="Votre Password..." name="password"></center></td></tr>
			<tr><td width=400><center><input type="submit" value="Connexion" class="button"></center></td></tr>
			</form>
			<%
			administrationInterface admins = new administrationImp();
			String login = request.getParameter("login");
			 String password = request.getParameter("password");
			 if(login!=null){
			 List<Administration> ok = admins.verif_admin(login, password);
			 int taille=ok.size();
			if (taille>0) {
				String role=ok.get(0).getRole();
				String log=ok.get(0).getLogin();
				int id=ok.get(0).getId();
				//if request is not from HttpServletRequest, you should do a typecast before
				 HttpSession sessions = request.getSession(false);
				 //save message in session
				 sessions.setAttribute("role", role);
				 sessions.setAttribute("login", log);
				 sessions.setAttribute("id", id);
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
					%>
					
					<tr><td style="width:300px;" align="center"><font color="red" style="font-size: 18px;text-align: center">Identifiant érronné</font></td></tr>
					<%
					
				}
			 }
			
			
			%>
			
			</table>
		</div>
	</div>
</div>
<!--carousel-->
<div id="container" style="z-index:-10" >
		<div id="billy_clip" style="z-index:-12">
			<ul id="billy_scroller">
				<li><img src="images/uas/1.png" width="1200" height="400" ></li>
				<li><img src="images/uas/2.png" width="1200" height="400" ></li>
				<li><img src="images/uas/3.png" width="1200" height="400"></li>
				<li><img src="images/uas/4.png" width="1200" height="400"></li>
			</ul>	
		</div>

		<ul id="billy_indicators">
		</ul>
		

	</div>	

<!--Fin carousel-->
	<div id="welcome" class="container" style="position: relative; top:140px">
    	
<div class="title">
	  <h2>Bienvenue à l'UAS !</h2>
		</div>
		<p><b>L’Université Arabe des Sciences fait partie du plus grand groupe universitaire privé de Tunisie: le Groupe de l'Education et des Sciences.
         Outre l'UAS Tunis, ce groupe comprend:</b><br>
          <b>Une université au Gabon, l'Université Africaine des Sciences UAS Libreville</b><br>
          <b>Deux instituts de formation professionnelle: l'Institut d'Administration des Entreprises (IAE Tunis, IAE Libreville)</b><br>
          <b>4 écoles primaires: Salim School à Ennasr, Salima School à Ezzahra, Salim School au Bardo et Lamis School à El mourouj</b><br>
          <b>2 collèges à Ennasr et à Ezzahra</b><br>
          <b>un centre de formation à Ryadh en Arabie Saoudite</b><br>
          <p><b>Le groupe est autorisé à ouvrir une université au Mali et une faculté de médecine au Tchad. Cela témoigne du sérieux de la formation qu’il assure et du rayonnement  international réalisé par le groupe.
          </b></p>
          <p><b>Fondée en 1993 L’AUS fait partie d’un groupe qui va de l’enseignement du primaire au mastère. C’est la première université privée  créée par des universitaires en Tunisie. 
          Elle s’est développée avec les années pour devenir la plus grande université privée du pays au moment où elle compte plus de 30 nationalités, 
          200 enseignants universitaires et des relations avec des universités situées sur les cinq continents.</b>
          </p>
         
 </p>
	</div>
	<div id="three-column" class="container" style="position: relative; top: 100px">
		
</div>
<div id="footer" style="position: relative; top: 120px">
	<div class="container">
		<div class="fbox1">
		<span class="icon icon-map-marker"></span>
			<b>UNIVERSITE ARABE DES SCIENCES</b>
			<span><br />Adresse : 34,Rue Cyrus le Grand 1002 Tunis</span>
			
		</div>
		<div class="fbox1">
			<span class="icon icon-phone"></span>
			<span>
				Telephone:  (216) 71 335 073 â 71 336 023
			</span>
			<br>
			<span> Fax: (216) 71 334 897</span>
		</div>
		<div class="fbox1">
			<span class="icon icon-envelope"></span>
			<span><a href="http://www.uas.ens.tn">www.uas.ens.tn</a></span>
		</div>
	</div>
</div>
<div id="copyright">
	<!--<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
	-->
	<ul class="contact">
		<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
		<li><a href="#" class="icon icon-facebook"><span></span></a></li>
		<li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
		<li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
		<li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
	</ul>
</div>


<script src="js/jquery.flexslider.js"></script>
<script src="js/demo.js"></script>
</body>
</html>
