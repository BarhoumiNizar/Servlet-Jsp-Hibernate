<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>
 <%@page import="metier.matiereImp"%>
<%@page import="Model.matiere"%>
<%@page import="metier.matiereInterface"%>
 <%@page import="metier.EtudiantImp"%>
<%@page import="Model.Etudiant"%>
<%@page import="metier.EtudiantInterface"%>

 <%@page import="metier.notesImp"%>
<%@page import="Model.Examen"%>
<%@page import="metier.notesInterface"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>UAS</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href=" bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" href=" css/formulaire.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href=" dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href=" dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href=" plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href=" plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href=" plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href=" plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href=" plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href=" plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

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
             
              <span class="hidden-xs"><%out.println(session.getAttribute("prenom")); %></span>
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
  <aside class="main-sidebar" style="width:320px;">
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
     <%@ include file="menu2.jsp" %>    </section>
    <!-- /.sidebar -->
  </aside>




  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="background:url('../images/prof_fond.jpg');">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
      
    </section>
    <!-- Bloc container -->
    <div style="width:900px;margin: auto">
       
       <!-- Le contenu -->
       <hgroup>
  <h1>Deposer les notes</h1>
 
</hgroup>
<%
Object prenom=session.getAttribute("prenom");
Object nom=session.getAttribute("nom");
String preno=prenom.toString();
String name=nom.toString();
String prof=name+" "+preno;
String classes=request.getParameter("classe");
String etudiants=request.getParameter("etudiant");
String matiere=request.getParameter("matiere");
String type=request.getParameter("type");
%>

<form method="get"  id="form">
  <div class="group">
   <label style="position: relative; top: 0px">Classe</label>
   <input type="text" name="classe" readonly="readonly" value="<%=classes%>">
 </div>
  <form method="get" id="form" action="notes" >
  
  <div class="group">
   <label style="position: relative; top: 0px">Matiere</label>
   
    <input type="text" name="matiere" readonly="readonly" value="<%=request.getParameter("matiere")%>" >
   <span class="highlight"></span><span class="bar"></span>
  </div>
  
  <div class="group">
  
  <input type="hidden" name="action" value="ajout">
   <label style="position: relative; top: 0px">Classe</label>
   <input type="text" name="type" readonly="readonly" value="<%=request.getParameter("type")%>">
    <span class="highlight"></span><span class="bar"></span>
    
  </div>
  <div class="group">
    <input type="text" readonly="readonly" value="<%=request.getParameter("coefficient") %>" name="coefficient" placeholder="coeficient"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  
  <div class="group">
    <input type="date" readonly="readonly" name="date" value="<%=request.getParameter("date") %>" ><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <label style="position: relative; top: 0px">Heure debut</label>
    <input type="time" readonly="readonly" value="<%=request.getParameter("examen_heure_debut") %>" name="examen_heure_debut"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <label style="position: relative; top: 0px">Heure Fin</label>
    <input type="time" readonly="readonly" value="<%=request.getParameter("examen_heure_fin") %>"  name="examen_heure_fin"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" readonly="readonly"  value="<%=request.getParameter("salle") %>"  name="salle" placeholder="salle"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
   <label style="position: relative; top: 0px">Etudiant</label>
    <select name="etudiant" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				EtudiantInterface etud=new EtudiantImp();
	notesInterface not=new notesImp();
				for(Etudiant elv:etud.getALLEtudiants())
				{
					if(classes!=null)
					{
				 if(classes.equals(elv.getClasse()))
				 {
					 if(!etudiants.equals(elv.getMatricule()) )
					 {
				%>
				
    <option value="<%=elv.getMatricule()%>"><%=elv.getMatricule() %></option>
  <%
					 }
				 }
					}
					else
					{
						%>
						 <option ><%=elv.getMatricule()%></option>
					<%}
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  
  <div class="group">
    <input type="text" id="note" name="note" placeholder="note"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="hidden" name="prof" value="<%=prof%>" placeholder="prof"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  
  
  
  
  <button type="submit" class="button buttonBlue">Déposer
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
</form>
       

 

      
      <!-- Fin contenu -->
</div>


<!-- jQuery 2.2.0 -->
<script src=" plugins/jQuery/jQuery-2.2.0.min.js"></script>
<script src="js/controleNotes.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.5 -->
<script src=" bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->

<script src=" plugins/morris/morris.min.js"></script>

<script src=" dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->

<!-- AdminLTE for demo purposes -->
<script src=" dist/js/demo.js"></script>

</body>
</html>
