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
import Model.departement;

public class classeImp implements classeInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<classe> getALLClasses() {
		String sql = "select * from classe";
		List<classe> liste = new ArrayList<classe>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				classe cls = new classe();
				
				
				cls.setClass_nom(resultat.getString("class_nom"));
				cls.setFiliere(resultat.getString("filiere"));
				cls.setId(resultat.getInt("id"));
				cls.setEtat(resultat.getString("etat"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(cls);
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
	public void deleteclasse(int id) {
		String sql = "delete from classe where id=?";
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
	public void Modifierclasse(classe cls) {
		String sql = "update classe set class_nom=?,filiere=?,etat='oui' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, cls.getClass_nom());
			ps.setString(2, cls.getFiliere());
			ps.setInt(3, cls.getId());
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
	public List<classe> verifclasse(String nom) {
String sql = "select * from classe where class_nom=?";
		
		List<classe> liste = new ArrayList<classe>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, nom);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				classe cl = new classe();
				
				
				liste.add(cl);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void Modifieretatclasse(String etat) {
		String sql = "update classe set etat=?";
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
	public List<classe> getALLClasse(String departement) {
		String sql = "select * from classe where departement=?";
		List<classe> liste = new ArrayList<classe>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, departement);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				classe cls = new classe();
				
				
				cls.setClass_nom(resultat.getString("class_nom"));
				cls.setFiliere(resultat.getString("filiere"));
				cls.setId(resultat.getInt("id"));
				cls.setEtat(resultat.getString("etat"));
				cls.setDepartement(resultat.getString("departement"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(cls);
			}
			// Exécution de notre requete
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	
	

}
