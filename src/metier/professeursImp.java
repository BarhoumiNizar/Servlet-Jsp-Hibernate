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
import Model.Professeur;
import Model.departement;

public class professeursImp implements professeursInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<Professeur> getALLProfs() {
		String sql = "select * from professeur ";
		List<Professeur> liste = new ArrayList<Professeur>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Professeur prof = new Professeur();
				prof.setAdresse(resultat.getString("adresse"));
				prof.setId(resultat.getInt("id"));
				prof.setPf_nom(resultat.getString("pf_nom"));
				prof.setPf_email(resultat.getString("pf_email"));
				prof.setPf_num_tel(resultat.getString("pf_num_tel"));
				prof.setPf_prenom(resultat.getString("pf_prenom"));
				prof.setEtat(resultat.getString("etat"));
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(prof);
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
	public List<Professeur> verif_prof(String email, String  password) {
		String sql = "select * from professeur where pf_email=? and password=?";
		
		List<Professeur> liste = new ArrayList<Professeur>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, email);
		   ps.setString(2, password);
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Professeur prof = new Professeur();
				
				prof.setAdresse(resultat.getString("adresse"));
				prof.setPf_email(resultat.getString("pf_email"));
				prof.setPf_nom(resultat.getString("pf_nom"));
				prof.setPf_prenom(resultat.getString("pf_prenom"));
				prof.setId(resultat.getInt("id"));
				
				
				
				
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
	public void deleteprof(int id) {
		String sql = "delete from professeur where id=?";
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
	public void ModifierProf(Professeur prof) {
		String sql = "update professeur set pf_nom=?,pf_prenom=?,adresse=?,pf_email=?,pf_num_tel=?,etat='oui' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof.getPf_nom());
			ps.setString(2, prof.getPf_prenom());
			ps.setString(3, prof.getAdresse());
			ps.setString(4, prof.getPf_email());
			ps.setString(5, prof.getPf_num_tel());
			ps.setInt(6, prof.getId());
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
	public List<Professeur> verifprof(String email,String tel) {
String sql = "select * from professeur where pf_email=? || pf_num_tel=?";
		
		List<Professeur> liste = new ArrayList<Professeur>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, tel);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Professeur prof = new Professeur();
				
				
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
	public List<Professeur> rech_prof(int id) {
String sql = "select * from professeur where id=?";
		
		List<Professeur> liste = new ArrayList<Professeur>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
		  
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				Professeur prof = new Professeur();
				
				
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
	public void ModifierMdp(Professeur prof) {
		String sql = "update professeur set password=? where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof.getPassword());
			ps.setInt(2, prof.getId());
			
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
	public void Modifieretatprof(String etat) {
		String sql = "update professeur set etat=?";
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
	public List<Professeur> getALLProf(String departement) {
		String sql = "select * from professeur where departement=? ";
		List<Professeur> liste = new ArrayList<Professeur>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, departement);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Professeur prof = new Professeur();
				prof.setAdresse(resultat.getString("adresse"));
				prof.setId(resultat.getInt("id"));
				prof.setPf_nom(resultat.getString("pf_nom"));
				prof.setPf_email(resultat.getString("pf_email"));
				prof.setPf_num_tel(resultat.getString("pf_num_tel"));
				prof.setPf_prenom(resultat.getString("pf_prenom"));
				prof.setEtat(resultat.getString("etat"));
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(prof);
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
