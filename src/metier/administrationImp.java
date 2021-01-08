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

public class administrationImp implements administrationInterface {
	connection conn;
	ResultSet resultat = null;
	
	@Override
	public List<Administration> verif_admin(String login, String  password) {
		String sql = "select * from administration where login=? and password=?";
		
		List<Administration> liste = new ArrayList<Administration>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, login);
		   ps.setString(2, password);
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Administration prof = new Administration();
				
				prof.setLogin(resultat.getString("login"));
				prof.setRole(resultat.getString("role"));
				prof.setId(resultat.getInt("id"));;
				
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(prof);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Administration> rech_admin(int id) {
String sql = "select * from administration where id=?";
		
		List<Administration> liste = new ArrayList<Administration>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Administration prof = new Administration();
				
				prof.setLogin(resultat.getString("login"));
				prof.setRole(resultat.getString("role"));
				prof.setPassword(resultat.getString("password"));
				prof.setId(resultat.getInt("id"));;
				
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(prof);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public void ModifierLogin(Administration login) {
		String sql = "update administration set login=? where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, login.getLogin());
			ps.setInt(2, login.getId());
			
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
	public void ModifierMdp(Administration login) {
		String sql = "update administration set password=? where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, login.getPassword());
			ps.setInt(2, login.getId());
			
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
