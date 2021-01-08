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
	
	<link rel="stylesheet" type="text/css" href="css/popup2.css" />
	    <link rel="stylesheet" type="text/css" href="css/style2.css" />

	
	<link rel="stylesheet" href="css/demo.css" />
	<!--carousel-->
	<link rel="stylesheet" href="css/demonstration.css" />
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/billy.carousel.jquery.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(document).ready( function() {
		
		// ----- Carousel
			<!-- $('#billy_scroller').billy({
				slidePause: 5000,
				// We need custom next/prev buttons for this example. If we used the defaults (#billy_next/#billy_prev), every carousel instance on the page would scroll when they're clicked...
				nextLink: $('#carousel_billy_next'),
				prevLink: $('#carousel_billy_prev'),
			});
			
		
			
		}); -->
				
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
</span></a>
</ul>
</section>
 


</div>
	</div>
		<div id="logo">
        	
			


		</div>
		
	</div>
</div>
<!--Menu-->
<%@ include file="menu.html" %>
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


<!--Fin carousel-->
	<div id="welcome" class="container" style="position: relative; top:140px">
    	
<div class="title">
	  <h2><!-- Titre --></h2>
 
	
	 <img src="images/admissionjpg.jpg" width="100%" height="200" style="float:left"/>
	 <h3 Style="color:green;position: relative;top:20px;margin-bottom: 20px">FAIRE UNE DEMANDE D'ADMISSION</h3>
	<p style="font-size: 20px;text-align: left">
	
	<span style="padding-left: 20px">Pour</span> être admis à l'UAS, quelle que soit la filière ou le cycle, toute personne doit présenter dans les délais prescrits, une demande sur le formulaire officiel complété par les pièces suivantes : Un extrait de naissance en langue française, Un dossier scolaire complet comprenant :
	Pour la personne qui fréquente encore un lycée ou un établissement d'enseignement secondaire au moment de sa demande d'admission : les relevés de notes obtenues à cette date au titre de l'année en cours et de l'année précédente, l'admission étant alors soumise à l'obtention du baccalauréat ;
	Pour toute autre personne : les relevés des notes obtenues durant les trois années antérieures ainsi que ceux de l'année en cours, le cas échéant ;
	Les diplômes obtenus certifiés conformes à l'original ;
	Le cas échéant, le certificat d'inscription délivré par le dernier établissement universitaire fréquenté ;
	Tout renseignement complémentaire jugé utile ou nécessaire.
 

	</p>
	<h3 Style="color:green; margine-left:none ;display:in-block">ADMISSION DÉFINITIVE</h3>
	
	<p style="font-size: 20px;text-aline:right;">
	L'inscription n'est considérée comme définitive qu'après acceptation du dossier de l'étudiant par l'Université et le règlement des frais de scolarité et des autres droits exigés par l'université.
    Dès la confirmation par l'ULT de l'admission définitive, l'étudiant doit compléter son dossier d'admission par les pièces suivantes :
	Formulaire d’inscription•	Photocopie de la CIN ou du passeport
	Attestation du baccalauéat certifiée conforme à l’original
	Relevé de note du baccalauréat certifié conforme à l’original
	Bulletins trimestriels de la classe terminale
	Attestation de réussite et relevés de notes des années d’enseignement supérieur (candidats non encore diplômés)
	Diplôme d’ingénieur, de licence ou de maîtrise certifié conforme à l’original
	
	

	</p>
	
	
	<h3 Style="color:green">ADMISSION DÉFINITIVE</h3>
	
	<p style="font-size: 20px;text-aline:right;">
	Les Frais de Scolarité
Les Frais de scolarité sont fixés annuellement par la direction financière de l'université. Ces frais couvrent les droits d'inscription, les cours, TD, TP, stages, conférences, séminaires, l'accès permanent à haut débit à tous les services Internet via le réseau informatique ainsi que l'accès à la médiathèque universitaire.
Ces droits peuvent être réglés soit en totalité avant la rentrée universitaire, soit payables par tranche selon les modalités prédéfinies par la direction financière et détaillées comme suit :
	La 1ère tranche doit être versée avant la rentrée universitaire
	La 2ème tranche doit impérativement être réglée avant le 31 décembre de l'année
	Le règlement de la 3ème tranche est fixé au 31 mars de l'année en cours
Important : 
Tout étudiant n'ayant pas procédé au règlement aux dates fixées, sera interdit d'accès aux cours et aux examens.
Les étudiants finissants doivent obligatoirement procéder au paiement de la 3ème tranche ou déposer une garantie avant leur départ en stage.
 
Tous les documents soumis, sauf les diplômes originaux, demeurent la propriété de l'UAS.

	
	

	</p>
	
	</table>
	  
	   
	  
		</div>
		
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
