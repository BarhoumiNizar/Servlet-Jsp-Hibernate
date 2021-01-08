package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.chef;


public class chefImp implements chefInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<chef> getALLChefs() {
		String sql = "select * from chef ";
		List<chef> liste = new ArrayList<chef>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				chef cf = new chef();
				cf.setAdresse(resultat.getString("adresse"));
				cf.setId(resultat.getInt("id"));
				cf.setNom(resultat.getString("nom"));
				cf.setEmail(resultat.getString("email"));
				cf.setNum_tel(resultat.getString("num_tel"));
				cf.setPrenom(resultat.getString("prenom"));
				cf.setDepartement(resultat.getString("departement"));
				cf.setEtat(resultat.getString("etat"));
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(cf);
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
	public List<chef> verif_chef(String email, String  password) {
		String sql = "select * from chef where email=? and password=?";
		
		List<chef> liste = new ArrayList<chef>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, email);
		   ps.setString(2, password);
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				chef cf = new chef();
				
				cf.setAdresse(resultat.getString("adresse"));
				cf.setId(resultat.getInt("id"));
				cf.setNom(resultat.getString("nom"));
				cf.setEmail(resultat.getString("email"));
				cf.setNum_tel(resultat.getString("num_tel"));
				cf.setDepartement(resultat.getString("departement"));
				cf.setPrenom(resultat.getString("prenom"));
				
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(cf);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void deletechef(int id) {
		String sql = "delete from chef where id=?";
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
	public void Modifierchef(chef cf) {
		String sql = "update chef set nom=?,prenom=?,adresse=?,email=?,num_tel=?,departement=?,etat='ok' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, cf.getNom());
			ps.setString(2, cf.getPrenom());
			ps.setString(3, cf.getAdresse());
			ps.setString(4, cf.getEmail());
			ps.setString(5, cf.getNum_tel());
			ps.setString(6, cf.getDepartement());
			ps.setInt(7, cf.getId());
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
	public List<chef> verifchef(String email,String tel,String departement) {
String sql = "select * from chef where email=? || num_tel=? || departement=? ";
		
		List<chef> liste = new ArrayList<chef>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, tel);
			ps.setString(3, departement);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				chef cf = new chef();
				
				
				liste.add(cf);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public List<chef> rech_chef(int id) {
String sql = "select * from chef where id=?";
		
		List<chef> liste = new ArrayList<chef>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				chef cf = new chef();
				
				
				cf.setPassword(resultat.getString("password"));
				cf.setId(resultat.getInt("id"));;
				
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(cf);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void ModifierMdp(chef cf) {
		String sql = "update chef set password=? where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, cf.getPassword());
			ps.setInt(2, cf.getId());
			
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
	public void Modifieretatchef(String etat) {
		String sql = "update chef set etat=?";
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
