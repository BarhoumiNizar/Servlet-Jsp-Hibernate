<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <ul class="sidebar-menu"  >
        <li class="header">MAIN NAVIGATION</li>
        
       
        <!-- Debut Menu -->
       <li class="treeview" >
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Gestion du compte </span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="login.jsp"><i class="fa fa-circle-o"></i> Modifier Login</a></li>
             <li><a href="mdp.jsp"><i class="fa fa-circle-o"></i> Modifier Password</a></li>
          </ul>
          </li>
        <li class="treeview" >
          <a href="documents_Administratifs.jsp">
            <i class="fa fa-pie-chart"></i>
            <span>Fournir document administratif </span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="documents_Administratifs.jsp"><i class="fa fa-circle-o"></i>Valider </a></li>
            <li><a href="supprimer_document.jsp"><i class="fa fa-circle-o"></i>Supprimer documents </a></li>
            <li><a href="document_recherche.jsp"><i class="fa fa-circle-o"></i>Recherche </a></li>
            
          </ul>
        
        </a>
          
          </li>
        
        <li class="treeview">
          <a href="enregistrer_note.jsp">
            <i class="fa fa-edit"></i> <span>Consulter les notes </span>
           </a></li>
        
        
       
        
         <li>
          <a href="#">
            <i class="fa fa-calendar"></i> <span>Gestion des étudiants</span>
            
         <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="etudiant_inscription.jsp"><i class="fa fa-circle-o"></i>Inscrire </a></li>
            <li><a href="etudiant_modifier.jsp"><i class="fa fa-circle-o"></i>Modifier </a></li>
             <li><a href="etudiant_supprimer.jsp"><i class="fa fa-circle-o"></i>Supprimer </a></li>
              <li><a href="etudiant_valider.jsp"><i class="fa fa-circle-o"></i>Valider Inscription </a></li>
               <li><a href="etudiant_recherche.jsp"><i class="fa fa-circle-o"></i>Recherche </a></li>
          </ul>
        </li>
         <li class="treeview">
          <a href="">
            <i class="fa fa-edit"></i> <span>Gestion des frais de scolarité </span>
           <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="payement.jsp"><i class="fa fa-circle-o"></i>Enregistrer </a></li>
            <li><a href="modifier_payement.jsp"><i class="fa fa-circle-o"></i>Modifier </a></li>
            <li><a href="supprimer_payement.jsp"><i class="fa fa-circle-o"></i>Supprimer</a></li>
             <li><a href="payement_recherche.jsp"><i class="fa fa-circle-o"></i>Recherche </a></li>
            
          </ul>
        
        </a></li>
        
        <li class="treeview">
          <a href="">
            <i class="fa fa-edit"></i> <span>Gestion des salles </span>
           <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="ajouter_salle.jsp"><i class="fa fa-circle-o"></i>Ajouter </a></li>
            <li><a href="modifier_salle.jsp"><i class="fa fa-circle-o"></i>Modifier </a></li>
            <li><a href="supprimer_salle.jsp"><i class="fa fa-circle-o"></i>Supprimer</a></li>
             <li><a href="salle_recherche.jsp"><i class="fa fa-circle-o"></i>Rechercher </a></li>
            
          </ul>
        
        </a></li>
        <li class="treeview">
          <a href="classes.jsp">
            <i class="fa fa-edit"></i> <span>Gestion des Seances </span>
            
          <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="seance.jsp"><i class="fa fa-circle-o"></i> Ajouter Seance </a></li>
            <li><a href="modifier_seance.jsp"><i class="fa fa-circle-o"></i>Modifier Seance</a></li>
            <li><a href="supprimer_seance.jsp"><i class="fa fa-circle-o"></i>Supprimer Seance</a></li>
            <li><a href="recherche_seance.jsp"><i class="fa fa-circle-o"></i>Recherche</a></li>
          </ul></li>
       
      
      </ul>  