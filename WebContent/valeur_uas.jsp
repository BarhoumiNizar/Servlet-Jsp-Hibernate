<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="css/espace_intranet.css" />
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
	
	<link rel="stylesheet" type="text/css" href="css/popup.css" />
	    <link rel="stylesheet" type="text/css" href="css/style2.css" />

	
	<link rel="stylesheet" href="css/demo.css" />
	<!--carousel-->
	<link rel="stylesheet" href="css/demonstration.css" />
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/billy.carousel.jquery.min.js" type="text/javascript"></script>
	
	<!--  <script type="text/javascript">
		$(document).ready( function() {
		
		 // ----- Carousel
			 $('#billy_scroller').billy({
				slidePause: 5000,
				// We need custom next/prev buttons for this example. If we used the defaults (#billy_next/#billy_prev), every carousel instance on the page would scroll when they're clicked...
				nextLink: $('#carousel_billy_next'),
				prevLink: $('#carousel_billy_prev'),
			});
			
		
			
		}); 
				
	</script>  -->
	
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
<!--Menu-->
<div  id="menu" style="z-index:10;background: transparent;" >
			<ul >
				<li class="active"><a class="principal" href="index.jsp" accesskey="1" title="">Accueil</a></li>
				
				<li id="formations"><a class="principal" href="#" accesskey="2" title="">Université</a>
						   <ol class="sous_menu_uas">
							   <li><a  href="presentation.jsp">Présentation</a></li>
							    <li><a href="president.jsp">Mot du président</a></li>
								 <li><a href="uas.jsp">Le plus de l'UAS</a></li>
								  <li><a href="valeur_uas.jsp">Les valeurs l'UAS</a></li>
								  <li><a href="evenements.jsp">Evenements</a></li>
								   
							   
							   
						  </ol>
				  
				  </li>
				<li id="formations"><a class="principal" href="#" accesskey="2" title="">Formations</a>
						   <ol class="sous_menu">
							   <li><a  href="cycle_preparatoire.jsp">Cycles Préparatoires</a></li>
							    <li><a href="licence.jsp">Licences</a></li>
								 <li><a href="master.jsp">Master</a></li>
								  <li><a href="etudes.jsp">Etudes d'ingénieurs</a></li>
								   
							   
							   
						  </ol>
				  
				  </li>
				<li id="formations"><a href="partenariats.jsp" class="principal" accesskey="3" title="">Partenariat</a>
				
				   <ol class="sous_menu_partenariat">
							   <li><a  href="cycle_preparatoire.jsp">Présentation</a></li>
							    <li><a href="licence.jsp">Mot du président</a></li>
								 <li><a href="master.jsp">Le plus de l'UAS</a></li>
								  <li><a href="etudes.jsp">Evenements</a></li>
								   
							   
							   
						  </ol>
				</li>
				<li id="formations"><a href="vie_Estudiantine.jsp"class="principal" accesskey="4" title="">Vie Estudiantine</a>
				
				 <ol class="sous_menu_etudiant">
							   <li><a  href="cycle_preparatoire.jsp">Présentation</a></li>
							    <li><a href="licence.jsp">Mot du président</a></li>
								 <li><a href="master.jsp">Le plus de l'UAS</a></li>
								  <li><a href="etudes.jsp">Evenements</a></li>
								   
							   
							   
						  </ol>
				
				</li>
				<li><a href="contact.jsp" class="principal" accesskey="5" title="">Contact Us</a>
				
				 <ol class="sous_menu">
							   <li><a  href="cycle_preparatoire.jsp">Présentation</a></li>
							    <li><a href="president.jsp">Mot du président</a></li>
								 <li><a href="master.jsp">Le plus de l'UAS</a></li>
								  <li><a href="etudes.jsp">Evenements</a></li>
								   
							   
							   
						  </ol>
				
				</li>
			
			</ul>
		</div>
		</header>
<!--Les popups-->
<!--Popup Etudiant-->
<div id="popup1" class="overlay" style="z-index:4">
	<div class="popup">
		<h2>Espace Etudiant</h2>
		<a class="close" href="#">&times;</a>
		<div class="content">
			<table>
			<form method="post" action="etudiant">
			<input type="hidden" name="action" value="connexion">
			<tr><td><input type="text" placeholder="Votre matricule..." name="matricule"></td></tr>
			<tr><td><input type="password" placeholder="Votre tel" name="tel"></td></tr>
			<tr><td><input type="submit" value="Connexion" class="button"></td></tr>
			</form>
			<form action="etudiants/inscription.jsp" >
			<tr><td><input type="submit" value="Inscription" class="button"></td></tr>
			
			</form>
			</table>
		</div>
	</div>
</div>
<!--Popup Enseignant-->
<div id="popup2" class="overlay" style="z-index:4">
	<div class="popup">
		<h2>Espace Enseignant</h2>
		<a class="close" href="#">&times;</a>
		<div class="content">
			<table>
			<form method="post" action="professeurs">
			<input type="hidden" name="action" value="connexion">
			<tr><td><input type="text" name="email" placeholder="Votre email..."></td></tr>
			<tr><td><input type="password" name="tel" placeholder="Votre num telephone"></td></tr>
			<tr><td><input type="submit" value="Connexion" class="button"></td></tr>
			</form>
			
			</table>
		</div>
	</div>
</div>
<!--Popup Administartion-->
<div id="popup3" class="overlay" style="z-index:4">
	<div class="popup">
		<h2>Espace Administration</h2>
		<a class="close" href="#">&times;</a>
		<div class="content">
			<table>
			<form method="post" action="Administrations">
			<input type="hidden" name="action" value="connexion">
			<tr><td><input type="text" placeholder="Votre login..." name="login"></td></tr>
			<tr><td><input type="password" placeholder="Votre Password..." name="password"></td></tr>
			<tr><td><input type="submit" value="Connexion" class="button"></td></tr>
			</form>
			
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
