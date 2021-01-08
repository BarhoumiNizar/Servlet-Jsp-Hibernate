package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.Filiere;
import Model.departement;

public class departementImp implements departementInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<departement> getALLdepartement() {
		String sql = "select * from departement";
		List<departement> liste = new ArrayList<departement>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				departement dep = new departement();
				dep.setDp_nom(resultat.getString("dp_nom"));
				
				dep.setId(resultat.getInt("id"));
				dep.setEtat(resultat.getString("etat"));
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
	public void deletedepartement(int id) {
		String sql = "delete from departement where id=?";
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
	public void ModifierDepartement(departement dep) {
		String sql = "update departement set dp_nom=?,etat='oui' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, dep.getDp_nom());
			
			ps.setInt(2, dep.getId());
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
	public List<departement> verifdepartement(String nom) {
String sql = "select * from departement where dp_nom=?";
		
		List<departement> liste = new ArrayList<departement>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, nom);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				departement etud = new departement();
				
				
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
	public void Modifieretatdepartement(String etat) {
		String sql = "update departement set etat=?";
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
	
	

}
