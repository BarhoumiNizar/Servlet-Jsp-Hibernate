<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="metier.EtudiantImp"%>
<%@page import="Model.Etudiant"%>
<%@page import="metier.EtudiantInterface"%>
 <%@page import="metier.seanceImp"%>
<%@page import="Model.seance"%>
<%@page import="metier.seanceInterface"%>
  <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>
<%@page import="java.text.SimpleDateFormat"%>
 <%@page import="metier.matiereImp"%>
<%@page import="Model.matiere"%>
<%@page import="metier.matiereInterface"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>UAS</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" href="../css/formulaire.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="../plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

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
      <ul class="sidebar-menu"  >
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Gestion des notes</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="depot_notes.jsp"><i class="fa fa-circle-o"></i> Déposer des notes</a></li>
            <li><a href="modifier_note.jsp"><i class="fa fa-circle-o"></i> Modifier Note</a></li>
             <li><a href="supprimer_note.jsp"><i class="fa fa-circle-o"></i> Supprimer Note</a></li>
           
            
          </ul>
        </li>
      <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Gestion Absences Etudiants</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="absence.jsp"><i class="fa fa-circle-o"></i> Marquer Absence</a></li>
            <li><a href="modifier_absence.jsp"><i class="fa fa-circle-o"></i> Modifier Absence</a></li>
             <li><a href="supprimer_absence.jsp"><i class="fa fa-circle-o"></i> Supprimer Absence</a></li>
           
            
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>notification à l’administration </span>
           
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="notifications.jsp"><i class="fa fa-circle-o"></i> Ajouter Notification</a></li>
            
            <li><a href="modifier_notification.jsp"><i class="fa fa-circle-o"></i> Modifier Notification</a></li>
            <li><a href="supprimer_notification.jsp"><i class="fa fa-circle-o"></i> Supprimer Notification</a></li>
           
            
          </ul>
         </li>
        
        
       <li>
          <a href="emploie_du_temps.jsp">
            <i class="fa fa-envelope"></i> <span>Consulter emploie du temps pour professeur</span>
           </a></li>
       <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Déposer sujet Stage</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="depot_stage.jsp"><i class="fa fa-circle-o"></i> Ajouter</a></li>
            <li><a href="modifier_stage.jsp"><i class="fa fa-circle-o"></i> Modifier</a></li>
             <li><a href="supprimer_stage.jsp"><i class="fa fa-circle-o"></i> Supprimer</a></li>
           
            
          </ul>
        </li>
       
        
       
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
      
    </section>
    <!-- Bloc container -->
    <div style="width:900px;margin: auto">
       
       <!-- Le contenu -->
       <hgroup>
  <h1>Marquer absence </h1>
 <%
 Object prenom=session.getAttribute("prenom");
 Object nom_prof=session.getAttribute("nom");
 String preno=prenom.toString();
 String name=nom_prof.toString();
 String prof=name+" "+preno;
 SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
 String classe=request.getParameter("classe");
 
 %>
</hgroup>
<form method="get" id="form">
  <div class="group">
  
  
   <div class="group">
   <label style="position: relative; top: 0px">Classe</label>
    <select id="classe" name="classe" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				classeInterface cls=new classeImp();
				for(classe cl:cls.getALLClasses())
				{
					
				%>
    <option <% if(cl.getClass_nom().equals(classe)){ %> selected="selected" <% } %> ><%=cl.getClass_nom()%></option>
  <%
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div><span class="highlight"></span><span class="bar"></span>
    
  </div>
  <button type="submit" class="button buttonBlue">Valider
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
  </form>
  <%

  if(classe!=null)
	{
  %>
  <form method="get" action="../absence" id="form">
  
  <div class="group">
  <input type="hidden" name="action" value="ajout">
   <input type="hidden" name="prof" value="<%=prof%>">
    <input type="hidden" name="classe" value="<%=classe%>">
   <label style="position: relative; top: 0px">Seance</label>
   <select name="seance" style="color: #636363" class="button" >
    <% 
    
	if(classe!=null)
	{
    matiereInterface mat=new matiereImp();
	for(matiere mt:mat.getALLMatieres())
	{
		if(classe.equals(mt.getClasse()))
		{
			%>
<option ><%=mt.getMat_nom()%></option>
<%
		}
	}
	
	
  %>
  </select>
    <span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
   <label style="position: relative; top: 0px">Etudiant</label>
    <select name="et_matricule" style="color: #636363" class="button" >
    <% 
    
				//pour parcourire le resultat users
				EtudiantInterface etud=new EtudiantImp();
				for(Etudiant elv:etud.getALLEtudiants())
				{ if(classe.equals(elv.getClasse()))
		 {
		%>
    <option value="<%=elv.getMatricule()%>"><%=elv.getMatricule() %></option>
  <%
				}
				}
	}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  <div class="group">
    <input type="hidden" name="date" value="<%=sdf.format(new Date())%>" ><span class="highlight"></span><span class="bar"></span>
  
  </div>
 
  <button type="submit" class="button buttonBlue">Ajouter
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
</form>
       
<% } %>
 

      
      <!-- Fin contenu -->
</div>


<!-- jQuery 2.2.0 -->
<script src="../plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.5 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->

<script src="../plugins/morris/morris.min.js"></script>

<script src="../dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->

<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
</body>
</html>
