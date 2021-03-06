<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="metier.coursImp"%>
<%@page import="Model.cours"%>
<%@page import="metier.coursInterface"%>
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
             
              <span class="hidden-xs">Alexander Pierce</span>
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
      <ul class="sidebar-menu"  >
        <li class="header">MAIN NAVIGATION</li>
        
          <li class="treeview" >
          <a href="attestation.jsp">
            <i class="fa fa-pie-chart"></i>
            <span>Demander document administratif</span>
            
          </a>
         
        </li>
        
        <li class="treeview" >
          <a href="etat_demande.jsp">
            <i class="fa fa-pie-chart"></i>
            <span>Consulter document administratif</span>
           
          </a>
          
        </li>
        <li class="treeview">
          <a href="emploie_du_temps.jsp">
            <i class="fa fa-laptop"></i>
            <span>Consulter emploi du temps </span>
           </a> </li>
        <li class="treeview">
          <a href="releve_notes.jsp">
            <i class="fa fa-edit"></i> <span>Consulté relevé de note </span>
           </a></li>
        
        
        <li>
          <a href="#">
            <i class="fa fa-envelope"></i> <span>Consulter Stage</span>
           
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="stages_pfe.jsp"><i class="fa fa-circle-o"></i> PFE</a></li>
            <li><a href="stages_pfa.jsp"><i class="fa fa-circle-o"></i> PFA </a></li>
            
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Notifications</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="rattrapage.jsp"><i class="fa fa-circle-o"></i> rattrapage</a></li>
            <li><a href="absence_prof.jsp"><i class="fa fa-circle-o"></i> absence professeur</a></li>
            <li><a href="absence.jsp"><i class="fa fa-circle-o"></i> son absence</a></li>
            
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
  <hgroup>
       <% 
int classe = (int) session.getAttribute("classe");
String classes=Integer.toString(classe);
%>
   <h1>Cours En ligne Pour la classe:  <u><b><%=classes %></b></u> </h1>
  
</hgroup>
<table width="75%" align="center" border="1">
<tr><td align="center">Date cours</td><td align="center">Matiere</td>

</tr>
<%
				//pour parcourire le resultat users
				coursInterface crc=new coursImp();
				for(cours crs:crc.getALLCours(classes))
				{%>
				<tr><td align="center"><%=crs.getDate()%></td>
				<td align="center"><%=crs.getMatiere()%></td>
				
				
				
				</tr>
				
				<% } %>
</table>
 

      
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
