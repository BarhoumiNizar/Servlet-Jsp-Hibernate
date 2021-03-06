<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="metier.seanceImp"%>
     <%@page import="metier.seanceInterface"%>
<%@page import="Model.seance"%>
 <%@page import="Model.Salle"%>
<%@page import="metier.salleImp"%>
<%@page import="metier.salleInterface"%>
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
   <link rel="stylesheet" href="../css/popup.css">
   
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
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Document administratif</span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="attestation.jsp"><i class="fa fa-circle-o"></i> Demander</a></li>
            <li><a href="etat_demande.jsp"><i class="fa fa-circle-o"></i> Consulter </a></li>
            <li><a href="modifier_document.jsp"><i class="fa fa-circle-o"></i> Modifier </a></li>
          </ul>
         
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
          <a href="notifications.jsp">
            <i class="fa fa-folder"></i> <span>Notifications</span>
              <i class="fa fa-angle-left pull-right"></i> 
          </a>
          
        </li>
        
       
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="background: url('../images/etudiant_fond.jpg');">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
      
    </section>
    <!-- Bloc container -->
    <div style="width:900px;margin: auto;padding-top: 50px">
       
       <!-- Le contenu -->
       <form action="" method="post">
       <table style="margin-bottom: 50px">
           <div class="group">
           <tr>
           <td>
  <label style="position: relative; top: 0px">Jour</label>
    <select name="jour">
      <option>Lundi</option>
      <option>Mardi</option>
      <option>Mercredi</option>
      <option>Jeudi</option>
      <option>Vendredi</option>
      <option>Samedi</option>
    </select>
    <span class="highlight"></span>
    
  </div>
  </td>
  <td valign="top">
  <button type="submit" class="button buttonBlue">Consulter
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>
  </td>
  </tr>
     </table>  
       </form>
       <%if(request.getParameter("jour")!=null) 
{
    	   Object classe=session.getAttribute("classe");
    	   String clas=classe.toString();
%>
 <table  width="75%" align="center" border="5"  > 
<tr bgcolor="#8CC6D7" height="50">


<td  align="center">Matiere</td>
<td  align="center">Heure début</td>
<td  align="center">Heure Fin</td>
<td  align="center">Prof</td>
<td  align="center">Salle</td>
</tr>
<% 
				//pour parcourire le resultat users
				seanceInterface sc=new seanceImp();
				for( seance scs:sc.EmploiseanceEtudiant(clas,request.getParameter("jour")))
				{%>
				<tr  height="50" bgcolor="#E1E6FA">
				
				       
				       <td align="center"><%=scs.getMatiere()%></td>
				       <td align="center"><%=scs.getDate_debut()%></td>
				       <td align="center"><%=scs.getDate_fin()%></td>
				       <td align="center"><%=scs.getProf()%></td>
				        <td align="center"><a href="?param=<%=scs.getId()%>#popup"><%=scs.getSalle()%></a></td>
				        </tr>
				
				<% } %>
</table>
<% } %>
       

	<div id="popup" class="overlay">
						<div class="popup" style="position: relative; top:120px;">
							<h2></h2>
							<a class="close" href="#" style="position: relative; top:0px;left:0px">&times;</a>
							<div class="content"style="width:75%;position: relative;top:0px; left:15s0px;">
								 <%
								 String params=request.getParameter("param");
								 if(params!=null)
								 {
								 int prm=Integer.parseInt(params);
                salleInterface sl=new salleImp();
				for(Salle sal:sl.getALLSalles())
				{ if(sal.getId()==prm)
				{
				%>
					<table border=3 style="width:100%;position: relative;top:10px; left:15s0px" height=100px>
					<tr style="color:red">
					         <td align="center" style="font-size: 18px;font-weight: bold" >Type</td>
					         <td style="font-size: 18px;font-weight: bold"  align="center">Immeuble</td>
					         <td style="font-size: 18px;font-weight: bold"  align="center">Etage</td>
					         </tr>
					      <tr>
					         <td style="font-size: 18px;font-weight: bold"  align="center"><%=sal.getSall_type() %></td>
					         <td style="font-size: 18px;font-weight: bold"  align="center"><%=sal.getSall_immeuble() %></td>
					         <td style="font-size: 18px;font-weight: bold"  align="center"><%=sal.getSall_etage() %></td>
					         </tr>
					</table>
								<%
								}
				}
				
								 }			
				  %>
											</div>
						</div>
					</div>
 

      
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
