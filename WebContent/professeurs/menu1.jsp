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
        <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Gestion des notes</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="depot_notes.jsp"><i class="fa fa-circle-o"></i> Déposer des notes</a></li>
            <li><a href="modifier_note.jsp"><i class="fa fa-circle-o"></i> Modifier Note</a></li>
             <li><a href="supprimer_note.jsp"><i class="fa fa-circle-o"></i> Supprimer Note</a></li>
              <li><a href="recherche_note.jsp"><i class="fa fa-circle-o"></i> Rechercher note</a></li>
            
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
           
              <li><a href="recherche_absence.jsp"><i class="fa fa-circle-o"></i> Rechercher</a></li>
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
             <li><a href="recherche_notification.jsp"><i class="fa fa-circle-o"></i> Rechercher</a></li>
            
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
           
              <li><a href="recherche_stage.jsp"><i class="fa fa-circle-o"></i> Rechercher</a></li>
          </ul>
        </li>
       
        
      </ul>