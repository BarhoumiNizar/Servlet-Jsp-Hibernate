<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Inscription</title>
  
  
  
     <link rel="stylesheet" href="../css/notification.css">

  
</head>

<body>
  <hgroup>
  <h1>Inscription Etudiant</h1>
 
</hgroup>
<form method="post" action="../etudiant" id="form">
  <div class="group">
  <input type="hidden" name="action" value="ajout">
  <input type="hidden" name="etat" value="non valide">
    <input type="hidden" name="etudiant" value="etudiant">
    <input type="text" name="matricule" placeholder="matricule"><span class="highlight" required="required"></span><span class="bar"></span>
    
  </div>
  <div class="group">
    <input type="email" name="email" placeholder="email"><span class="highlight" required="required"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" name="nom" placeholder="nom"><span class="highlight" required="required"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" name="prenom" placeholder="prenom"><span class="highlight" required="required"></span><span class="bar"></span>
  
  </div>
  <div class="group">
  <label style="position: relative; top: 0px">Date naissance</label>
    <input type="date" name="naissance" placeholder="naissance"><span class="highlight" required="required"></span><span class="bar"></span>
  
  </div>
   <div class="group">
   <span style="position: relative;top: -10px"> Masculin</span><input type="radio" name="sexe" value="masculin" style="width:25px; height: 25px;border-radius:50%;position: relative;left:10px" required="required">
       <span style="position: relative;left:10px; top: -10px">Féminin</span><input type="radio" name="sexe" value="feminin" style="width:25px; height: 25px;border-radius:50%;position: relative;left:20px">
     
  </div>
  <div class="group">
 <label style="position: relative; top: 0px">Nationnalité</label>
  <select name="nationalite" style="color: #636363" class="button" >
    <option>tunisienne</option>
    <option>Lybienne</option>
    <option>Saudienne</option>
    <option>Gabonaise</option>
    <option>Congolaise</option>
  
  </select>

  
  </div>
  <div class="group">
    <input type="text" name="tel" placeholder="téléphone"><span class="highlight"></span><span class="bar" required="required"></span>
  
  </div>
  <div class="group">
    <input type="text" name="adresse" placeholder="adresse" required="required"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" name="etablissement" placeholder="etablissement" required="required"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
  <label style="position: relative; top: 0px">Classe</label>
    <select name="class" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				classeInterface cl=new classeImp();
				for(classe cls:cl.getALLClasses())
				{%>
    <option><%=cls.getClass_nom() %></option>
  <%
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  
  <button type="submit" class="button buttonBlue">Inscription
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
</form>

  
</body>
</html>
