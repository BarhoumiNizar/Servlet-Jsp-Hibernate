<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>

    <%@page import="metier.filiereImp"%>
<%@page import="Model.Filiere"%>
<%@page import="metier.filiereInterface"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>UAS</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" href="../../css/notification.css">
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
      
      
      <%@include file="menu.jsp" %> 
      
      
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
      
    </section>
    <!-- Bloc container -->
    <div style="width:1000px;margin: auto">
       
       <!-- Le contenu -->
     <%
     
     String filieres=request.getParameter("filiere");
     %>
<table width="30%" align="left">
<tr>
<td valign="top" colspan="2">
<form method="get"  id="form" style="float: left; width: 400px;height: 150px">
<div class="group">
   <label style="position: relative; top: 0px">Filiere</label>
    <select name="filiere" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				filiereInterface fl=new filiereImp();
				for(Filiere fls:fl.getALLFilieres())
				{
				
				%>
    <option <% if(fls.getFlr_nom().equalsIgnoreCase(filieres)){ %> selected="selected" <% } %> ><%=fls.getFlr_nom() %></option>
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
 
  if(filieres!=null)
  {
  
  %>
<form method="post" action="../../etudiant" id="form"  style="float: right;width:600px; height:600px">
 <table width="100%" align="right" height="700">
<tr>
  <td  width="50%" valign="top">
  <div class="group">
  <input type="hidden" name="action" value="ajout">
  <input type="hidden" name="etat" value="valider">
  <input type="hidden" name="filiere" value="<%=filieres%>">
   <input type="hidden" name="etudiant" value="etudiants">
    <input type="text" name="matricule" placeholder="matricule" required="required"><span class="highlight"></span><span class="bar"></span>
    
  </div>
  </td>
   <td>
  <div class="group">
    <input type="email" name="email" placeholder="email" required="required"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td></tr>
  <tr>
   <td width="50%" valign="top">
  <div class="group" style="position: relative;top:-25px">
    <input type="text" name="nom" placeholder="nom" required="required"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td>
  <td width="50%" valign="top">
  <div class="group" style="position: relative;top:-25px">
    <input type="text" name="prenom" placeholder="prenom" required="required"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td></tr>
  <tr>
   <td width="50%" valign="top">
  <div class="group" style="position: relative;top:-40px">
  <label style="position: relative; top: 0px">Date naissance</label>
    <input type="date" required="required" name="naissance" placeholder="naissance"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td>
   <td width="50%" valign="top">
  <div class="group" style="padding-top: 10px">
   <span style="position: relative;top: -10px"> Masculin</span><input required="required" type="radio" name="sexe" value="masculin" style="width:25px; height: 25px;border-radius:50%;position: relative;left:10px">
       <span style="position: relative;left:10px; top: -10px">Féminin</span><input required="required" type="radio" name="sexe" value="feminin" style="width:25px; height: 25px;border-radius:50%;position: relative;left:20px">
     
  </div>
  </td>
  </tr>
  <tr>
   <td width="50%" valign="top">
  <div class="group" style="position: relative; top:-50px">
  <label style="position: relative; top: 0px">Nationnalité</label>
  <select name="nationalite" style="color: #636363" class="button" >
    <option>Tunisienne</option>
    <option>Lybienne</option>
    <option>Saudienne</option>
    <option>Gabonaise</option>
    <option>Congolaise</option>
  
  </select>
    <span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td>
   <td width="50%" valign="top">
  <div class="group" style="position: relative; top: -15px">
    <input type="text" required="required" name="tel" placeholder="téléphone"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td></tr>
  <tr>
   <td width="50%" valign="top">
  <div class="group" style="position: relative;top:-80px">
    <input type="text" required="required" name="adresse" placeholder="adresse"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td>
   <td width="50%" valign="top">
  <div class="group" style="position: relative;top:-80px">
    <input type="text"  required="required" name="etablissement" placeholder="etablissement"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td></tr>
  <tr>
   <td width="50%" valign="top">
   <div class="group" style="position: relative;top:-125px">
  <label style="position: relative; top: 20px">Classe</label>
    <select name="class" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				classeInterface cl=new classeImp();
				for(classe cls:cl.getALLClasses())
				{
					if(filieres!=null)
					{
				 if(filieres.equals(cls.getFiliere()))
				 {
				%>
    <option><%=cls.getClass_nom() %></option>
  <%
				}
					}
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  </td>
   <td width="50%" valign="top">
  <div class="group" style="position: relative;top:-90px">
    <input required="required" type="password" name="password" placeholder="password"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  </td>
  </tr>
  <tr ><td colspan="2" valign="top" style="position: relative;top:-180px;margin-bottom: -50px">
  <button type="submit" class="button buttonBlue" >Inscription
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
  </td>
</tr>

</form>
 </table>  
     <%
   
   }
   %>    

     
       

 

      
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
