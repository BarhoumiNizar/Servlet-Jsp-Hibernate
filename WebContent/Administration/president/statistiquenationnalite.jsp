<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="metier.EtudiantImp"%>
<%@page import="Model.Etudiant"%>
<%@page import="java.util.List"%>
<%@page import="metier.EtudiantInterface"%>
<%
 EtudiantInterface Etudiants=new EtudiantImp();
 List<Etudiant> tu = Etudiants.StatistiqueTunisienne();
 List<Etudiant> saud = Etudiants.StatistiqueSaudienne();
 List<Etudiant> lybia = Etudiants.StatistiqueLybienne();
 List<Etudiant> gabon = Etudiants.StatistiqueGabonaise();
 List<Etudiant> congo = Etudiants.StatistiqueCongolaise();
 List<Etudiant> tot = Etudiants.getALLEtudiants();
 int tunisiens=tu.size();
 int saudi=saud.size();
 int libyan=lybia.size();
 int gabn=gabon.size();
 int cong=congo.size();
 double total=tot.size();
 DecimalFormat df = new DecimalFormat("00.00");
 String prMas="Pourcentage des Etudiants tunisiens = "+df.format((100*tunisiens)/total)+"%\n";
	String prFm="Pourcentage des Etudiants saudienne = "+df.format((100*saudi)/total)+"%\n";
	String prFl="Pourcentage des Etudiants étranger = "+df.format((100*libyan)/total)+"%\n";
	String prFcongo="Pourcentage des Etudiants étranger = "+df.format((100*cong)/total)+"%\n";
	String prFgabon="Pourcentage des Etudiants étranger = "+df.format((100*gabn)/total)+"%\n";
 %>
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
   <link rel="stylesheet" href="../../css/formulaire.css">
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
  <!-- Appel pour le graph -->
  <!-- jQuery 2.2.0 -->
<script src="../../plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
  <link href="../../libs/css/sDashboard.css" rel="stylesheet">


		<!-- load gitter css -->
		<link href="../../libs/css/gitter/css/jquery.gritter.css" rel="stylesheet"/>
		<link href="../../libs/css/css.css" rel="stylesheet">
		<!-- load jquery library -->
		

		
		<!-- load touch punch library to enable dragging on touch based devices -->
		<script src="../../libs/touchpunch/jquery.ui.touch-punch.js" type="text/javascript"> </script>
		<!-- load gitter notification library -->
		<script src="../../libs/gitter/jquery.gritter.js" type="text/javascript"> </script>

		<!-- load datatables library -->
		

		<!-- load flotr2 charting library -->
		<!--[if IE]>
		<script language="javascript" type="text/javascript" src="libs/flotr2/flotr2.ie.min.js"></script>
		<![endif]-->
		<script src="../../libs/flotr2/flotr2.js" type="text/javascript"> </script>
 
		<!-- load dashboard library -->
		<script src="../../libs/jquery/jquery-sDashboard.js" type="text/javascript"> </script>

		<!-- sample data external script file -->
		
		<!-- example code -->
		<script type="text/javascript">
			$(function() {

				
				
				//**********************************************//
				//dashboard json data
				//this is the data format that the dashboard framework expects
				//**********************************************//

				var dashboardJSON = [{
					widgetTitle : "Statistique des payements",
					widgetId : "id006",
					widgetType : "chart",
					widgetContent : {
						data : myExampleData.pieChartData,
						options : myExampleData.pieChartOptions
					}

				}];

				//basic initialization example
				$("#myDashboard").sDashboard({
					dashboardData : dashboardJSON
				});

			});
			var myExampleData = {};
              
			//pie Chart sample data and options
			myExampleData.pieChartData = [{
				data : [[0, <%=tunisiens %>]],
				label : "Tunisienne"
			}, {
				data : [[0, <%=libyan%>]],
				label : "Lybienne"
			}, {
				data : [[0, <%=saudi%>]],
				label : "Saudienne"
			}, {
				data : [[0, <%=gabn%>]],
				label : "Gabonaise"
			}, {
				data : [[0,  <%=cong%>]],
				label : "Congolaise"
			}];

			myExampleData.pieChartOptions = {
				HtmlText : false,
				grid : {
					verticalLines : false,
					horizontalLines : false
				},
				xaxis : {
					showLabels : false
				},
				yaxis : {
					showLabels : false
				},
				pie : {
					show : true,
					explode : 6
				},
				mouse : {
					track : true
				},
				legend : {
					position : "se",
					backgroundColor : "#D2E8FF"
				}
			};

			//Pie chart sample data ends here

			//bar Chart sample data and options

			myExampleData.constructBubbleChartData = function() {
				var d1 = [];
				var d2 = []
				var point
				var i;

				for ( i = 0; i < 10; i++) {
					point = [i, Math.ceil(Math.random() * 10), Math.ceil(Math.random() * 10)];
					d1.push(point);

					point = [i, Math.ceil(Math.random() * 10), Math.ceil(Math.random() * 10)];
					d2.push(point);
				} 
				return [d1, d2];
			};
			myExampleData.bubbleChartData = myExampleData.constructBubbleChartData();

			myExampleData.bubbleChartOptions = {
				bubbles : {
					show : true,
					baseRadius : 5
				},
				xaxis : {
					min : -4,
					max : 14
				},
				yaxis : {
					min : -4,
					max : 14
				},
				mouse : {
					track : true,
					relative : true
				}
			};

			//bar chart sample data ends here

			//bar Chart sample data and options

			myExampleData.constructBarChartData = function() {
				var d1 = [];
				var d2 = []
				var point
				var i;
				for ( i = 0; i < 4; i++) {
					point = [Math.ceil(Math.random() * 10), i];
					d1.push(point);
					point = [Math.ceil(Math.random() * 10), i + 0.5];

					d2.push(point);
				}
				return [d1, d2];
			};
			myExampleData.barChartData = myExampleData.constructBarChartData();

			myExampleData.barChartOptions = {
				bars : {
					show : true,
					horizontal : true,
					shadowSize : 0,
					barWidth : 0.5
				},
				mouse : {
					track : true,
					relative : true
				},
				yaxis : {
					min : 0,
					autoscaleMargin : 1
				}
			};

			//bar chart sample data ends here

			//line Chart sample data and options

			myExampleData.constructLineChartData = function() {
				var d1 = [[0, 5], [4, 8], [8, 5], [9, 13]];
				var d2 = [];
				var i;

				for ( i = 0; i < 14; i += 0.5) {
					d2.push([i, Math.sin(i)]);
				}
				return [d1, d2];
			};
			myExampleData.lineChartData = myExampleData.constructLineChartData();

			myExampleData.lineChartOptions = {
				xaxis : {
					minorTickFreq : 4
				},
				grid : {
					minorVerticalLines : true
				},
				selection : {
					mode : "x",
					fps : 30
				}
			};

			//line chart sample data ends here

			//table Widget sample data and options

			myExampleData.constructTableWidgetData = function(){
				return ["Trident"+Math.ceil(Math.random() * 10), "IE" + Math.ceil(Math.random() * 10), "Win"+Math.ceil(Math.random() * 10)]
			};

			myExampleData.tableWidgetData = {
				"aaData" : [myExampleData.constructTableWidgetData(), 
				myExampleData.constructTableWidgetData(), 
				myExampleData.constructTableWidgetData(), 
				myExampleData.constructTableWidgetData(),
				myExampleData.constructTableWidgetData(),
				myExampleData.constructTableWidgetData(), 
				myExampleData.constructTableWidgetData()
				],

				"aoColumns" : [{
					"sTitle" : "Engine"
				}, {
					"sTitle" : "Browser"
				}, {
					"sTitle" : "Platform"
				}],
				"iDisplayLength": 25,
				"aLengthMenu": [[1, 25, 50, -1], [1, 25, 50, "All"]],
				"bPaginate": true,
				"bAutoWidth": false
			};
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//table widget sample data ends here
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		</script>
  
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
  <aside class="main-sidebar" style="width:340px;">
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
        
       
        
        
        
      <li>
          <a href="#">
            <i class="fa fa-calendar"></i> <span>Consulter les statistiques </span>
            
         <i class="fa fa-angle-left pull-right"></i>
          </a>
         <ul class="treeview-menu">
            <li><a href="statistiqueSexe.jsp"><i class="fa fa-circle-o"></i> La répartition des étudiants par sexe </a></li>
            <li><a href="statistiquenationnalite.jsp"><i class="fa fa-circle-o"></i>La répartition des étudiants par Nationnalité</a></li>
                        <li><a href="statistiquepayement.jsp"><i class="fa fa-circle-o"></i>Pourcentage de payement des frais de scolarité</a></li>
            
            
          </ul>
        </li>
        
        
        
       
        
        
       
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="background: url('../../images/President_fond.jpg');">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
      
    </section>
    <!-- Bloc container -->
    <div style="width:900px;margin: auto">
       
       <!-- Le contenu -->
       
</hgroup>

<!-- Graph -->

<ul id="myDashboard">

		</ul>
 

      
      <!-- Fin contenu -->
</div>


<!-- jQuery 2.2.0 -->

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
