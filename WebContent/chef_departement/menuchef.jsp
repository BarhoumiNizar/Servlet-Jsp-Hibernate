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
          <a href="filieres.jsp">
            <i class="fa fa-laptop"></i>
           <span>Gestion Filieres </span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="filieres.jsp"><i class="fa fa-circle-o"></i> Ajouter Filiere </a></li>
            <li><a href="modifier_filiere.jsp"><i class="fa fa-circle-o"></i>Modifier Filiere</a></li>
            <li><a href="supprimer_filiere.jsp"><i class="fa fa-circle-o"></i>Supprimer Filiere</a></li>
             <li><a href="recherche_filiere.jsp"><i class="fa fa-circle-o"></i>Recherche</a></li>
            
          </ul>
          
           </li>
        <li class="treeview">
          <a href="classes.jsp">
            <i class="fa fa-edit"></i> <span>Gestion Classes </span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="classe.jsp"><i class="fa fa-circle-o"></i> Ajouter Classe </a></li>
            <li><a href="modifier_classe.jsp"><i class="fa fa-circle-o"></i>Modifier Classe</a></li>
            <li><a href="supprimer_classe.jsp"><i class="fa fa-circle-o"></i>Supprimer Classe</a></li>
            <li><a href="recherche_classe.jsp"><i class="fa fa-circle-o"></i>Recherche</a></li>
          </ul></li>
         <li class="treeview">
          <a href="classes.jsp">
            <i class="fa fa-edit"></i> <span>Gestion Matieres </span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="matiere.jsp"><i class="fa fa-circle-o"></i> Ajouter Matiere </a></li>
            <li><a href="modifier_matiere.jsp"><i class="fa fa-circle-o"></i>Modifier Matiere</a></li>
            <li><a href="supprimer_matieret.jsp"><i class="fa fa-circle-o"></i>Supprimer Matiere</a></li>
            <li><a href="recherche_matiere.jsp"><i class="fa fa-circle-o"></i>Recherche</a></li>
          </ul></li>
       <!--  <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Gestion des notes</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="depot_notes.jsp"><i class="fa fa-circle-o"></i> Déposer des notes</a></li>
            <li><a href="modifier_note.jsp"><i class="fa fa-circle-o"></i> Modifier Note</a></li>
             <li><a href="supprimer_note.jsp"><i class="fa fa-circle-o"></i> Supprimer Note</a></li>
              <li><a href="recherche_note.jsp"><i class="fa fa-circle-o"></i> Recherche</a></li>
            
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
       -->
       <li class="treeview">
          <a href="classes.jsp">
            <i class="fa fa-edit"></i> <span>Gestion Professeurs </span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="professeur.jsp"><i class="fa fa-circle-o"></i> Ajouter Professeur </a></li>
            <li><a href="modifier_professeur.jsp"><i class="fa fa-circle-o"></i>Modifier Professeur</a></li>
            <li><a href="supprimer_professeur.jsp"><i class="fa fa-circle-o"></i>Supprimer Professeur</a></li>
            <li><a href="recherche_professeur.jsp"><i class="fa fa-circle-o"></i>Recherche</a></li>
          </ul></li>
       
        
      </ul>