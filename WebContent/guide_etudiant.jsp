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
 
	
	 <img src="images/guide_etudiant 1.jpg" width="100%" height="200" style="float:left"/>
	 
	<p style="font-size: 20px;text-align:left;">
	
	<span  style="padding-left: 20px">Choisir</span> l’UAPS, c’est s’engager dans un projet pédagogique de formation généraliste qui valorise au mieux chaque personnalité,
 en adoptant, d’une part, les méthodes et les outils les plus avancés, et en la dotant, d’autre part, des compétences scientifiques,
techniques et relationnelles qui lui ouvriront un choix exceptionnel de parcours professionnels.
 Même si la transmission du savoir, du savoir être et savoir-faire est au cœur de ce projet pédagogique,
 le respect des personnes, le sens de l’effort, de la responsabilité et du devoir sont, plus que jamais, nécessaires. 
 

	</p>
		 <img src="images/guide_etudiant 2.jpg" width="100%" height="200" style="float:left; vertical-align:center"/>
	
	 <h3 Style="color:green;position: relative;top:20px;margin-bottom: 20px">Charte pédagogique de l'UAS</h3>
	
<p style="font-size: 20px;text-align:left">
	<span  style="padding-left: 20px">  Rejoindre</span> l’UAPS, c’est aussi faire le choix d’une formation
	 qui valorise l’esprit scientifique, et propose une exposition à la recherche, à l’innovation et à l’entrepreneuriat,
	  en conciliant le cheminement créatif et la progression rigoureuse qui soutiennent l’esprit de défis de notre université. 

Le cursus d’un étudiant à l’UAPS est un parcours exigeant certes, mais unique et riche d’expériences et d’apprentissages
 à un âge charnière préparant chacun à relever les défis futurs de sa vie d’adulte. Dans notre projet pédagogique,
  l’implication et l'épanouissement des étudiants, d’une part, dans la vie de l'Université est primordial. Dans ce contexte,
   Nous inviterons nos étudiants à s’inscrire dans une logique d’entraide mutuelle et de participer à de nombreuses activités pour préserver leur équilibre de vie et acquérir une confiance en soi. D’autre part, la direction est persuadée du potentiel et de la bonne volonté des corps enseignants permanents de l’UAPS. Nous les inviterons à travailler d’avantage en équipe pour relever les défis. Ensemble, nous saurons amener tout un chacun vers le chemin de son excellence. Notre devise à tous : servir pour exceller ». 
A l’UAPS, nous privilégierons l'écoute et le dialogue comme meilleurs moyens pour assurer les synergies entre les étudiants,
 les enseignants et la direction générale. Nous organiserons à cet effet des rencontres régulières entre les enseignants,
  les délégués des classes, en plus d'assurer un suivi constant des étudiants dans leur évolution académique et scientifique. 

	</p>
	
		 <img src="images/guide_etudiant 3.jpg" width="100%" height="200" style="float:left"/>
	
	 <h3 Style="color:green;position: relative;top:20px;margin-bottom: 20px">Les finalités de l'enseignement à l'université </h3>
	
	<p style="font-size: 20px;text-align:left">
	<span  style="padding-left: 40px"> Dans</span> sa mission d’enseignement, l’UAPS s’engage à : <br>
	
<span  style="padding-left: 40px">* Promouvoir</span> le développement personnel et intellectuel optimal de tout étudiant quels que soient son origine et son parcours <br>
<span  style="padding-left: 40px">* Former</span> les étudiants à l’analyse critique des enjeux et effets sociétaux, aux questions ainsi qu’aux pratiques et résultats du champ scientifique <br>
<span  style="padding-left: 40px">* Préparer</span> les étudiants à leur rôle de citoyens responsables en les sensibilisant à l'éthique et en valorisant la solidarité. L'Université favorise la solidarité entre les étudiants par les travaux en équipe, la vie associative, etc… <br>
<span  style="padding-left: 40px">* Favoriser</span>  par la formation une intégration réussie dans le monde professionnel et dans les sociétés, à travers les stages d’été et l’exercice d’une activité professionnel experte et responsable. <br>

	</p>
	 <h3 Style="color:green;position: relative;top:20px;margin-bottom: 20px">Les attentes respectives et leurs implicationsS</h3>
	 	 <h4 Style="color:blue;position: relative;top:20px;margin-bottom: 20px; margin-left:0px">Enseignant</h4>
	 
<p>
<p style="font-size: 20px;text-align:left">
	<span  style="padding-left: 20px">  L’enseignant</span>  est correctement accueilli au sein de l’Université, il reçoit et intègre les informations utiles pour exercer sa mission. 
L’enseignant dispose d’une infrastructure adéquate pour mener à bien  mener sa mission d’enseignement (un poste de travail équipé, accès à des ressources et outils logiciels partagés
 susceptibles de l’aider dans sa mission…) 

L’enseignant s’engage à adhérer aux principes et priorités pédagogiques de l’Université (respecte la cohérence pédagogique
 du programme dans lequel il s’inscrit et qui a été défini collégialement, participe à la concertation et à la coordination
  pédagogique…) 
L’expérience et l’investissement de l’enseignant dans le domaine pédagogique sont reconnus et valorisés (plan de carrière…) 
L’enseignant bénéficie d’un soutien à l’innovation pédagogique L’enseignant bénéficie tout au long de sa carrière de possibilités
 de développement professionnel (accès à une offre de formation pédagogique continue) 
	
	 

	</p>
		 	 <h4 Style="color:blue;position: relative;top:20px;margin-bottom: 20px; margin-left:0px">Etudiant</h4>
	
	<p style="font-size: 20px;text-align:left">
	<span  style="padding-left: 20px">L’étudiant</span> reçoit une formation de qualité 
 
L’étudiant reçoit et intègre les informations utiles pour son parcours tant sur le fonctionnement de l’institution
 que sur les exigences en termes d’apprentissage 
L’étudiant bénéficie de salles de cours et de lieux d’étude dotés de l’équipement adéquat ainsi que l’accès aux ressources
 utiles à ses études (bibliothèques, laboratoires,...) 
L’étudiant bénéficie d’un encadrement pédagogique en concordance avec le projet de formation 
L’étudiant respecte les infrastructures mises à sa disposition L’étudiant participe aux évaluations formatives proposées
 par l’enseignant. Il cherche à comprendre ses erreurs et à mieux cerner les objectifs poursuivis par les enseignants 
L’étudiant entretient des relations respectueuses et constructives avec ses pairs, ses enseignants et les différents acteurs
 de l’Université 

L’étudiant a la possibilité de participer aux structures institutionnelles en charge de l’évaluation des enseignements 


	</p>
	</p>	
	
	<!-- evaluation -->
	 <h3 Style="color:green;position: relative;top:20px;margin-bottom: 20px">Evaluations de la formation universitaire</h3>
	 	
	 
<p>
<p style="font-size: 20px;text-align:left">
	<span  style="padding-left: 20px">Les</span>  objectifs et les moyens présentés dans la première partie de la
	 charte définissent les critères de qualité que l’Université Libre de Tunis promeut pour ses enseignements. Toutefois,
	  il ne suffit pas de souhaiter cette qualité et stagner, encore faut-il l’évaluer et réajuster d’une façon continue et 
	  annuelle les moyens pour l’atteindre. Une évaluation rigoureuse prendra en compte toutes les informations pertinentes,
	   valides et fiables (synthèse et conclusion des questionnaires…) pour atteindre les objectifs fixés et concourra ainsi
	    à prendre les décisions susceptibles d’améliorer la qualité de la formation. ) 
	
	 

	</p>
		 	 <h4 Style="color:blue;position: relative;top:20px;margin-bottom: 20px; margin-left:0px">Evaluations des enseignant</h4>
	
	<p style="font-size: 20px;text-align:left">
	<span  style="padding-left: 20px">Cette</span> évaluation peut être également de nature diagnostique-prédictive 
	ou formative. L'évaluation diagnostique-prédictive d'un enseignement peut porter sur le plan de cours avant sa mise en œuvre
	 afin d’en déterminer la cohérence interne (objectifs, méthodes, modalités d'évaluation), l’intérêt, la faisabilité et
	  également la cohérence en regard du programme et de spécialité. 
L'évaluation formative ou de régulation présente un intérêt évident pour améliorer la qualité d'un enseignement. Organisée
 à l'initiative de l'enseignant, elle lui donne, en cours de route ou au terme de l'enseignement, les informations utiles pour
  optimiser le processus de formation et clarifier avec les étudiants toute question relative aux objectifs du cours, 
  à son déroulement ou encore aux critères d'évaluation des acquis. 



	</p>
	 <h4 Style="color:blue;position: relative;top:20px;margin-bottom: 20px; margin-left:0px">Evaluations des programmes de cours</h4>
	
	<p style="font-size: 20px;text-align:left">
	<span  style="padding-left: 20px">Cette</span> Un dernier objet d’évaluation, dans le cadre de la formation à l’université,
	 est le programme de formation lui-même. Ici encore, l'évaluation peut remplir trois fonctions : une fonction prédictive
	  avant la mise en route d’un nouveau programme, pour juger de son intérêt et de sa pertinence, une fonction formative 
	  (après la mise en route d’un programme pour l’améliorer) et une fonction certificative, notamment pour les nouveaux
	   programmes, qui sont évalués après quelques années d'exercice pour décider de leur continuation ou de leur arrêt. 
L’Université dispose aujourd'hui d'une grille générale d'évaluation des programmes en référence à laquelle elles élaborent
 leurs outils d'évaluation (grille ABET, CTI…). Y sont précisés les critères à prendre en compte pour cette évaluation de 
 même que les différentes informations à recueillir que ce soit auprès des enseignants impliqués dans le programme, des étudiants,
  des comités d’évaluations ou encore des anciens étudiants et des personnes externes, notamment les professionnels du secteur
   de formation concerné. 


	</p>
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
