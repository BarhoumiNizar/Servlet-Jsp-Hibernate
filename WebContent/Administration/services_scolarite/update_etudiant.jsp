<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="Model.Etudiant"%>
     <%@page import="metier.EtudiantImp"%>
     <%@page import="metier.EtudiantInterface"%>
      <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>
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
    <div style="width:900px;margin: auto">
       
       <!-- Le contenu -->
      <hgroup>
       <%
  String id=request.getParameter("id");
  int id_update=Integer.parseInt(id);
  String matricule=null;
  String nom=null;
  String prenom=null;
  String email=null;
  String naissance=null;
  String sexe=null;
  String nationalites=null;
  String tel=null;
  String adresse=null;
  String classe=null;
  String etablissement = null;
  EtudiantInterface etud=new EtudiantImp();
  /**Pour remplir le formulaire**/
  for(Etudiant etuds:etud.getALLEtudiants())
  {
	 if(etuds.getId()==id_update) 
	 {
		 nom=etuds.getEt_nom();
		 prenom=etuds.getEt_prenom();
		 email=etuds.getEt_email();
		 adresse=etuds.getEt_adresse();
		 tel=etuds.getEt_num_tel();
		 matricule=etuds.getMatricule();
		 nationalites=etuds.getEt_nationalite();
		 naissance=etuds.getEt_date_naissance();
		 etablissement = etuds.getEt_dernier_etablissement();
		 sexe=etuds.getEt_sexe();
		 classe=etuds.getClasse();

	 }
  }

%>
  <h1>Modifier Etudiant</h1>
 
</hgroup>
<form method="post" action="../../etudiant" id="form">
  <div class="group">
  <input type="hidden" name="action" value="update">
 <input type="hidden" name="id" value="<%=id%>">
    <input type="text" name="matricule" readonly="readonly" value="<%=matricule %>" placeholder="matricule"><span class="highlight"></span><span class="bar"></span>
    
  </div>
  <div class="group">
    <input type="email" name="email" value="<%=email %>" placeholder="email"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" name="nom" value="<%=nom %>" placeholder="nom"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" name="prenom" value="<%=prenom %>" placeholder="prenom"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="date" name="naissance"  value="<%=naissance %>" placeholder="naissance"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
   <span style="position: relative;top: -10px"> Masculin</span>
   <input type="radio" <% if(sexe.equalsIgnoreCase("masculin")){ %> checked="checked" <% } %> name="sexe" value="masculin" style="width:25px; height: 25px;border-radius:50%;position: relative;left:10px">
   <span style="position: relative;left:10px; top: -10px">Féminin</span>
   <input type="radio" <% if(sexe.equalsIgnoreCase("feminin")){ %> checked="checked" <% } %> name="sexe" value="feminin" style="width:25px; height: 25px;border-radius:50%;position: relative;left:20px">
     
  
  </div>
   <div class="group">
   <label style="position: relative; top: 0px">Nationnalité</label>
  <select name="nationalite" style="color: #636363" class="button" >
    <option <% if(nationalites.equalsIgnoreCase("tunisien")){ %> selected="selected" <% } %>>tunisienne</option>
    <option <% if(nationalites.equalsIgnoreCase("Lybienne")){ %> selected="selected" <% } %>>Lybienne</option>
    <option <% if(nationalites.equalsIgnoreCase("Saudienne")){ %> selected="selected" <% } %> >Saudienne</option>
    <option <% if(nationalites.equalsIgnoreCase("Gabonaise")){ %> selected="selected" <% } %> >Gabonaise</option>
    <option <% if(nationalites.equalsIgnoreCase("Congolaise")){ %> selected="selected" <% } %> >Congolaise</option>
  
  </select>
   
   
  
    
  
  
  <div class="group">
    <input type="text" name="tel"  value="<%=tel %>" placeholder="téléphone"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" name="adresse" value="<%=adresse %>" placeholder="adresse"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
    <input type="text" name="etablissement" value="<%=etablissement %>"placeholder="etablissement"><span class="highlight"></span><span class="bar"></span>
  
  </div>
  <div class="group">
  <label style="position: relative; top: 0px">Classe</label>
    <select name="class" style="color: #636363" class="button" >
    <% 
				//pour parcourire le resultat users
				classeInterface cl=new classeImp();
				for(classe cls:cl.getALLClasses())
				{%>
    <option <% if(classe.equalsIgnoreCase(cls.getClass_nom())){ %>selected="selected" <% } %>><%=cls.getClass_nom() %></option>
  <%
				}
  %>
  </select><span class="highlight"></span><span class="bar"></span>
  </div>
  <button type="submit" class="button buttonBlue">Modification
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
</form>
       
       

 

      
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
