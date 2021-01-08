package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.Administration;
import Model.Etudiant;
import Model.Examen;



public class EtudiantImp implements EtudiantInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<Etudiant> getALLEtudiants() {
		String sql = "select * from etudiant";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Etudiant emp = new Etudiant();
				emp.setEt_adresse(resultat.getString("et_adresse"));
				emp.setMatricule(resultat.getString("matricule"));
				emp.setEt_adresse(resultat.getString("et_adresse"));
				emp.setEt_date_naissance(resultat.getString("et_date_naissance"));
				emp.setEt_email(resultat.getString("et_email"));
				emp.setEt_nom(resultat.getString("et_nom"));
				emp.setEt_prenom(resultat.getString("et_prenom"));
				emp.setEt_num_tel(resultat.getString("et_num_tel"));
				emp.setId(resultat.getInt("id"));
				emp.setClasse(resultat.getString("classe"));
				emp.setEt_nationalite(resultat.getString("et_nationalite"));
				//ajout pour apparaitre dans la page de modification
				emp.setEt_dernier_etablissement(resultat.getString("et_dernier_etablissement"));
				emp.setEt_sexe(resultat.getString("et_sexe"));
				emp.setEtats(resultat.getString("etats"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(emp);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> verif_etudiant(String matricule, String  password) {
		String sql = "select * from etudiant where matricule=? and password=? and etat='valider'";
		
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, matricule);
		   ps.setString(2, password);
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Etudiant etud = new Etudiant();
				
				etud.setEt_adresse(resultat.getString("et_adresse"));
				etud.setMatricule(resultat.getString("matricule"));
				etud.setClasse(resultat.getString("classe"));
				etud.setEt_prenom(resultat.getString("et_prenom"));
				etud.setId(resultat.getInt("id"));
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(etud);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void deleteEtudiant(int id) {
		String sql = "delete from etudiant where id=?";
		try {
			@SuppressWarnings("static-access")
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int test = ps.executeUpdate();
			// pour tester si l'insertion est effectuée ou non
			if (test != 0) {
				System.out.println("Suppression effectuée avec Succée");
			} else {
				System.out.println("Erreur de suppression");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	//Etudiant etudiants=new Etudiant();
	@Override
	public void ModifierEtudiant(Etudiant etudiants) {
		String sql = "UPDATE `etudiant` SET `matricule`=?,`et_email`=?,"
				+ "`et_nom`=?,`et_prenom`=?,`et_date_naissance`=?,`et_sexe`=?,"
				+ "`et_nationalite`=?,`et_num_tel`=?,`et_adresse`=?,"
				+ "`et_dernier_etablissement`=?,`classe`=?,etats='oui' WHERE id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, etudiants.getMatricule());
			ps.setString(2, etudiants.getEt_email());
			ps.setString(3, etudiants.getEt_nom());
			ps.setString(4, etudiants.getEt_prenom());
			ps.setString(5, etudiants.getEt_date_naissance());
			ps.setString(6, etudiants.getEt_sexe());
			ps.setString(7, etudiants.getEt_nationalite());
			ps.setString(8, etudiants.getEt_num_tel());
			ps.setString(9, etudiants.getEt_adresse());
			ps.setString(10, etudiants.getEt_dernier_etablissement());
			ps.setString(11, etudiants.getClasse());
			
			ps.setInt(12, etudiants.getId());
			int test = ps.executeUpdate();
			// pour tester si l'insertion est effectuée ou non
			if (test != 0) {
				System.out.println("Modification effectuée avec Succée");
			} else {
				System.out.println("Erreur d'update");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void ValiderEtudiant(int id) {
		String sql = "UPDATE `etudiant` SET `etat`='valider',etats='oui'  WHERE id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			
			
			
			ps.setInt(1, id);
			int test = ps.executeUpdate();
			// pour tester si l'insertion est effectuée ou non
			if (test != 0) {
				System.out.println("validation effectuée avec Succée");
			} else {
				System.out.println("Erreur d'update");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public List<Etudiant> getALLEtudiantsNonValide() {
		
			String sql = "select * from etudiant where etat='non valide'";
			List<Etudiant> liste = new ArrayList<Etudiant>();
			try {
				PreparedStatement ps = conn.getConnection().prepareStatement(sql);
				resultat = ps.executeQuery();
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					Etudiant emp = new Etudiant();
					emp.setEt_adresse(resultat.getString("et_adresse"));
					emp.setMatricule(resultat.getString("matricule"));
					emp.setEt_adresse(resultat.getString("et_adresse"));
					emp.setEt_date_naissance(resultat.getString("et_date_naissance"));
					emp.setEt_email(resultat.getString("et_email"));
					emp.setEt_nom(resultat.getString("et_nom"));
					emp.setEt_prenom(resultat.getString("et_prenom"));
					emp.setClasse(resultat.getString("classe"));
					emp.setId(resultat.getInt("id"));
					
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(emp);
				}
				// Exécution de notre requete
				resultat = ps.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return liste;
	}
	@Override
	public List<Etudiant> StatistiqueGenieInfo() {
		String sql = "select * from etudiant where filiere='Genie informatique'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> StatistiqueLicenceInfo() {
		String sql = "select * from etudiant where filiere='licence fondamentale en informatique'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	
	@Override
	public List<Etudiant> StatistiqueLicenceReseaux() {
		String sql = "select * from etudiant where filiere='Licence applique en reseaux informatique'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> StatistiqueTunisienne() {
		String sql = "select * from etudiant where et_nationalite='tunisienne'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> StatistiqueSaudienne() {
		String sql = "select * from etudiant where et_nationalite='Saudienne'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> StatistiquePayementValide() {
		String sql = "select * from payement where py_tranche='valide'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				//dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> StatistiquePayementNonValide() {
		String sql = "select * from payement where py_tranche='non_valide'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				//dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public void ModifierMdp(Etudiant etudiants) {
		String sql = "update etudiant set password=? where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, etudiants.getPassword());
			ps.setInt(2, etudiants.getId());
			
			int test = ps.executeUpdate();
			// pour tester si l'insertion est effectuée ou non
			if (test != 0) {
				System.out.println("Modification effectuée avec Succée");
			} else {
				System.out.println("Erreur d'update");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public List<Etudiant> rech_etudiant(int id) {
String sql = "select * from etudiant where id=?";
		
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Etudiant etud = new Etudiant();
				
				
				etud.setPassword(resultat.getString("password"));
				etud.setId(resultat.getInt("id"));;
				
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(etud);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public List<Etudiant> verif_etudiants(String matricule, String email,String tel) {
String sql = "select * from etudiant where matricule=? || et_email=? || et_num_tel=?  ";
		
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, matricule);
		   ps.setString(2, email);
		   ps.setString(3, tel);
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Etudiant etud = new Etudiant();
				
				etud.setEt_adresse(resultat.getString("et_adresse"));
				etud.setMatricule(resultat.getString("matricule"));
				etud.setClasse(resultat.getString("classe"));
				etud.setEt_prenom(resultat.getString("et_prenom"));
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(etud);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void Modifieretatetudiant(String etat) {
		String sql = "update etudiant set etats=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, etat);
			
			
			int test = ps.executeUpdate();
			// pour tester si l'insertion est effectuée ou non
			if (test != 0) {
				System.out.println("Modification effectuée avec Succée");
			} else {
				System.out.println("Erreur d'update");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Etudiant> verif_etudiant_modif(String email, String tel) {
String sql = "select * from etudiant where  et_email=? || et_num_tel=?  ";
		
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, email);
		   ps.setString(2,tel );
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Etudiant etud = new Etudiant();
				
				etud.setEt_adresse(resultat.getString("et_adresse"));
				etud.setMatricule(resultat.getString("matricule"));
				etud.setClasse(resultat.getString("classe"));
				etud.setEt_prenom(resultat.getString("et_prenom"));
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(etud);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public List<Etudiant> StatistiqueLybienne() {
		String sql = "select * from etudiant where et_nationalite='Lybienne'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> StatistiqueGabonaise() {
		String sql = "select * from etudiant where et_nationalite='Gabonaise'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	@Override
	public List<Etudiant> StatistiqueCongolaise() {
		String sql = "select * from etudiant where et_nationalite='Congolaise'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	
	
	
	
	
	

}
