package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.Salle;


public class salleImp implements salleInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<Salle> getALLSalles() {
		String sql = "select * from salle";
		List<Salle> liste = new ArrayList<Salle>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Salle sl = new Salle();
				
				
				sl.setSall_immeuble(resultat.getString("sall_immeuble"));
				sl.setSall_nom(resultat.getString("sall_nom"));
				sl.setSall_type(resultat.getString("sall_type"));
				sl.setSall_etage(resultat.getInt("sall_etage"));
				sl.setId(resultat.getInt("id"));
				sl.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(sl);
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
	public void deletesalle(int id) {
		String sql = "delete from salle where id=?";
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
	public void Modifiersalle(Salle sal) {
		String sql = "update salle set sall_type=?,sall_nom=?,sall_etage=?,sall_immeuble=?,etat='oui' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, sal.getSall_type());
			ps.setString(2, sal.getSall_nom());
			ps.setInt(3, sal.getSall_etage());
			ps.setString(4, sal.getSall_immeuble());
			ps.setInt(5, sal.getId());
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
	public List<Salle> verifsalle(String nom) {
String sql = "select * from salle where sall_nom=?";
		
		List<Salle> liste = new ArrayList<Salle>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, nom);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Salle sal = new Salle();
				
				
				liste.add(sal);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void Modifieretatsalle(String etat) {
		// TODO Auto-generated method stub
		String sql = "update salle set etat=?";
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
