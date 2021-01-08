<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="sidebar-menu"  >
        <li class="header">MAIN NAVIGATION</li>
         <li class="treeview" >
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Gestion du compte </span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
           
             <li><a href="mdp.jsp"><i class="fa fa-circle-o"></i> Modifier Password</a></li>
          </ul>
          </li>
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