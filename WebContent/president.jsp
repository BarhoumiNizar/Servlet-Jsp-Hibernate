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
<div  id="menu" style="z-index:10;background: transparent;" >
			<ul >
				<li class="active"><a class="principal" href="index.jsp" accesskey="1" title="">Accueil</a></li>
				<li id="formations"><a class="principal" href="#" accesskey="2" title="">Université</a>
						   <ol class="sous_menu_uas">
							   <li><a  href="presentation.jsp">Présentation</a></li>
							    <li><a href="president.jsp">Mot du président</a></li>
								 <li><a href="uas.jsp">Le plus de l'UAS</a></li>
								  <li><a href="etudes.jsp">Evenements</a></li>
								   
							   
							   
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
				  <li id="formations"><a href="vie_Estudiantine.jsp"class="principal" accesskey="4" title="">Vie Estudiantine</a>
				
				 <ol class="sous_menu_etudiant">
							   <li><a  href="cycle_preparatoire.jsp">Présentation</a></li>
							    <li><a href="licence.jsp">Mot du président</a></li>
								 <li><a href="master.jsp">Le plus de l'UAS</a></li>
								  <li><a href="etudes.jsp">Evenements</a></li>
								   
							   
							   
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
				
				<li><a href="contact.jsp" class="principal" accesskey="5" title="">Contact Us</a>
				
				 <ol class="sous_menu">
							   <li><a  href="cycle_preparatoire.jsp">Présentation</a></li>
							    <li><a href="licence.jsp">Mot du président</a></li>
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


<!--Fin carousel-->
	<div id="welcome" class="container" style="position: relative; top:140px">
    	
<div class="title">
	  <h2><!-- Titre --></h2>
 
	
	 <img src="images/presentation/uas1.jpg" width="250" height="200" style="float:left"/>
	<p style="font-size: 20px">
	
	J’ai un grand défaut; je suis très exigeant envers moi-même, mes enfants, mes élèves et mes étudiants et si j’ai des problèmes de santé, c’est à cause de cela. Je crois qu’il s’agit d’un défaut parce qu’il est souvent mal perçu.
Ma devise ’Le sérieux et la discipline’’, autrement je ne peux pas travailler et j’en fais une maladie. Car la compétence est un savoir-faire qui peut s’apprendre.
Dans tous les établissements que je dirige, j’essaie de transmettre à mes enfants et aux générations que je forme, non pas de la matière, mais de la valeur.
Je suis singulièrement attaché à la Tunisie. Je suis ainsi le seul de ma promotion de La Sorbonne à être rentré au pays. J’aurais pu avoir la nationalité française mais je n’y ai pas tenu.
Je pense que la culture du privé m’accompagnait même lorsque j’étais dans le public. Je me comportais en tant que chef d’entreprise plutôt qu’en Doyen.
Au mois de septembre de chaque année, je faisais le porte-à-porte de toutes les grandes entreprises dans la finance, l’industrie, le commerce, les services pour les inciter à accueillir des étudiants en stage. Le résultat, c’est que ces étudiants sont très souvent recrutés. A mon départ de l’ESC, j’ai laissé des promesses d’emploi pour 5 années, parce que l’on accordait nos violons en toutes choses, l’université et les patrons.
L’une de mes grandes fiertés est quand ces dizaines de diplômés que je croise un peu partout et qui occupent actuellement des postes très importants  me confient leurs enfants pour les former dès l’enseignement primaire.
Dans le privé, en plus de ces valeurs, il y a des techniques de gestion propres à notre groupe :
-Nous appliquons la technique de l’organisation circulaire et non pyramidale. Chaque cadre occupe un poste dans le cercle mais il peut être opérationnel à tout moment dans n’importe quel autre poste.
-Nous sommes l’unique entreprise qui pratique la gestion financière réelle et non fictive. Nous gérons ainsi le potentiel réel, les liquidités et pas la puissance financière potentielle. Je ne crois pas beaucoup à l’effet de levier qui stipule que plus je suis endetté plus je réussis.
-Nous croyons profondément au partage du respect de la dignité dans la gestion de nos ressources humaines, alors que pas moins de 300 familles vivent de notre groupe.
	
	
	
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
