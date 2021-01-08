<%@page import="Model.departement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/popup.css">
<script src="../plugins/jQuery/jQuery-2.2.0.min.js"></script>

</head>
<body>
<!-- debut popup -->
   <div id="popup1" class="overlay">
						<div class="popup" style="width:600px;position: relative; top:120px;left:15s0px">
						<%
						String nom=null;
						String filiere=null; 
						if(request.getParameter("id")!=null)
						{
						String id=request.getParameter("id");
						
							int id_update=Integer.parseInt(id);
							
						  
						  classeInterface cl=new classeImp();
						 /*Pour remplir le formulaire*/
						  for( classe cls:cl.getALLClasses())
						  {
							 if(cls.getId()==id_update) 
							 {
								 nom=cls.getClass_nom();
								 filiere=cls.getFiliere();
								
							 }
						  }
						}
						
						
						%>
					
								 
							<table width=100% height=75% border=2>
							<tr><td width=180><b style="font-size: 24px;color:red">Nom</b></td>
							<td width=180><b style="font-size: 24px;color:red">Filiere</b></td>
							</tr>
							<tr>
							
							<td width=180><b style="font-size: 18px"><%=nom %></b></td>
							<td width=180><b style="font-size: 18px"><%=filiere %></b></td>
							</tr>
							<tr><td colspan=2 align=right><a href="#" onclick="window.print();document.location.href='recherche_classe.jsp';">Imprimer</a></td></tr>
							
							</table> 
							<a class="close" href="#" onclick="document.location.href='recherche_classe.jsp'">&times;</a>
							<!--<div class="content" style="width:570px;height:350px; overflow:scroll">
								<p>L’histoire d’Horeb Yanick OKODIT FOUROU est celle d’un remarquable succès d’un homme. Celle d’un Congolais aux origines simples, honnête et très déterminé. Elle tient essentiellement au caractère volontaire et courageux dont la personnalité a été forgée aux côtés des parents, son père est originaire du district de Gamboma dans le département des Plateaux au Nord du pays et sa mère originaire du district de Kindamba dans le département du Pool au Sud du pays. </p>
								<p>BEAB-CONCEPTIONENGINEERING, c’est avant tout l’improbable et remarquable succès d’un homme, un jeune congolais aux origines simples, honnête, courageux, très déterminé, ainsi qu’autodidacte : Horeb Yanick OKODIT FOUROU, Président Directeur Général de l’entreprise BEAB-ConceptionEngineering et fondateur de BEAB-ConceptionEngineering.</p>
								<p>Après ses études primaires à l’école du 31 juillet de Gamboma,  il a débuté ses études secondaires au collège technique de Gamboma dans la spécialité génie civil (la Maçonnerie) et il a pu obtenir son Brevet d’ Etudes Techniques (B.E.T.) au lycée technique du 5 Février de Brazzaville en 2008, ce qui lui donne  accès à la poursuite de ses études secondaires au lycée technique industriel du 1er Mai de Brazzaville, lui sanctionnant par un diplôme  de Baccalauréat technologique de la même spécialité (série F4).</p>
								<p>En Septembre 2013 le jeune homme bénéficie d’une bourse d’études pour la République Démocratique du Congo où il est parti continuer ses études supérieures dans l’Institut national de Bâtiment et de Travaux Publics (INBTP), peu après, en Octobre 2014, il se voit attribuer une bourse de coopération lui réorientant en République Tunisienne pour un Brevet de Technicien Supérieur au Centre Sectoriel de Formation Professionnelle en Travaux Publics de Mornaguia (CSFTP) dans la spécialité Conducteur de Travaux Publics. </p>
								<p>
								Durant cette période, il a passé plusieurs formations certifiantes dans les domaines de génie civil, de système de management de qualité et sécurité environnementale (ISO et QHSE). Après un parcours brillant de ses études en génie civil dans la spécialité Conducteur de Travaux Publics, Horeb Yanick OKODIT FOUROU se perfectionne pendant une longue période dans les différentes entreprises et sociétés Tunisiennes, où il a acquis une grande expérience professionnelle (dans les bureaux d’études et sur le terrain). Une fois muri, en 2016, Horeb Yanick OKODIT FOUROU sûr de ses compétences et capacités professionnelles en Conducteur de Travaux Publics, il a finalement décidé de l’apparition officielle de l’entreprise BEAB-ConceptionEngineering, qui jusqu’en 2013, n’était qu’un simple bureau d’études.
								</p>
							</div>-->
							 
						</div>
					</div>    

 <!-- Fin popup -->
</body>
</html>