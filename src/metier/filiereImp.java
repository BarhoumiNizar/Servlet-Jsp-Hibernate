package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.Etudiant;
import Model.Filiere;

public class filiereImp implements filiereInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<Filiere> getALLFilieres() {
		String sql = "select * from filiere";
		List<Filiere> liste = new ArrayList<Filiere>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Filiere fl = new Filiere();
				
				fl.setFlr_nom(resultat.getString("flr_nom"));
				fl.setDep(resultat.getString("dep"));
				fl.setId(resultat.getInt("id"));
				fl.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(fl);
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
	public void deletefiliere(int id) {
		String sql = "delete from filiere where id=?";
		try {
			@SuppressWarnings("static-access")
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			int test = ps.executeUpdate();
			
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
	@Override
	public void Modifierfiliere(Filiere fl) {
		String sql = "update filiere set flr_nom=?,dep=?,etat='oui' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, fl.getFlr_nom());
			ps.setString(2, fl.getDep());
			ps.setInt(3, fl.getId());
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
	public List<Filiere> veriffiliere(String nom, String departement) {
		
String sql = "select * from filiere where flr_nom=? and dep=?";
		
		List<Filiere> liste = new ArrayList<Filiere>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, nom);
		   ps.setString(2, departement);
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Filiere etud = new Filiere();
				
				/*etud.setEt_adresse(resultat.getString("et_adresse"));
				etud.setMatricule(resultat.getString("matricule"));
				etud.setClasse(resultat.getString("classe"));
				etud.setEt_prenom(resultat.getString("et_prenom"));*/
				
				
				
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
	public void Modifieretatfiliere(String etat) {
		String sql = "update filiere set etat=?";
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
	public List<Filiere> getALLFiliereschef(String departement) {
		String sql = "select * from filiere where dep=?";
		List<Filiere> liste = new ArrayList<Filiere>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, departement);
			resultat = ps.executeQuery();
		
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Filiere fl = new Filiere();
				
				fl.setFlr_nom(resultat.getString("flr_nom"));
				fl.setDep(resultat.getString("dep"));
				fl.setId(resultat.getInt("id"));
				fl.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(fl);
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
