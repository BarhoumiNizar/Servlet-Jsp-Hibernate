package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.classe;
import Model.matiere;

public class matiereImp implements matiereInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<matiere> getALLMatieres() {
		String sql = "select * from matiere";
		List<matiere> liste = new ArrayList<matiere>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				matiere mat = new matiere();
				
				
				mat.setClasse(resultat.getString("classe"));
				mat.setMat_coefficient(resultat.getInt("mat_coefficient"));
				mat.setMat_mass_horaire(resultat.getInt("mat_mass_horaire"));
				mat.setMat_nom(resultat.getString("mat_nom"));
				mat.setId(resultat.getInt("id"));
				mat.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(mat);
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
	public void deletematiere(int id) {
		String sql = "delete from matiere where id=?";
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
	public void Modifiermatiere(matiere mat) {
		String sql = "update matiere set mat_nom=?,mat_mass_horaire=?,classe=?,mat_coefficient=?,etat='oui' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, mat.getMat_nom());
			ps.setInt(2, mat.getMat_mass_horaire());
			ps.setString(3, mat.getClasse());
			ps.setInt(4, mat.getMat_coefficient());
			ps.setInt(5, mat.getId());
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
	public List<matiere> verifmatiere(String nom, String classe) {
String sql = "select * from matiere where mat_nom=? and classe=?";
		
		List<matiere> liste = new ArrayList<matiere>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, nom);
			ps.setString(2, classe);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				matiere mt = new matiere();
				
				
				liste.add(mt);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public List<matiere> getmatiere(String classe) {
String sql = "select * from matiere where classe=?";
		
		List<matiere> liste = new ArrayList<matiere>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, classe);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				matiere mt = new matiere();
				mt.setMat_nom(resultat.getString("mat_nom"));
				
				liste.add(mt);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void Modifieretatmatiere(String etat) {
		String sql = "update matiere set etat=?";
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
	public List<matiere> getALLMatiere(String departement) {
		String sql = "select * from matiere where departement=?";
		List<matiere> liste = new ArrayList<matiere>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, departement);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				matiere mat = new matiere();
				
				
				mat.setClasse(resultat.getString("classe"));
				mat.setMat_coefficient(resultat.getInt("mat_coefficient"));
				mat.setMat_mass_horaire(resultat.getInt("mat_mass_horaire"));
				mat.setMat_nom(resultat.getString("mat_nom"));
				mat.setId(resultat.getInt("id"));
				mat.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(mat);
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
