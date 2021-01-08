package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.Examen;
import Model.absence;

public class absenceImp implements absenceInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<absence> getALLAbsences(String prof) {
		String sql = "select * from absence where prof=? order by classe,seance,date";
		List<absence> liste = new ArrayList<absence>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				absence abs = new absence();
				
				abs.setId(resultat.getInt("id"));
				abs.setEt_matricule(resultat.getString("et_matricule"));
				abs.setSeance(resultat.getString("seance"));
				abs.setDate(resultat.getString("date"));
				abs.setClasse(resultat.getString("classe"));
				abs.setProf(resultat.getString("prof"));
				abs.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(abs);
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
	public void deleteAbsence(int id) {
		String sql = "delete from absence where id=?";
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
	@Override
	public void ModifierAbsence(absence abs) {
		String sql = "update absence set seance=?,et_matricule=?,classe=?,date=?,etat='ok' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, abs.getSeance());
			ps.setString(2, abs.getEt_matricule());
			ps.setString(3, abs.getClasse());
			ps.setString(4, abs.getDate());
			ps.setInt(5, abs.getId());
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
	public void Modifieretatnote(String etat,String prof) {
		String sql = "update absence set etat=? where prof=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, etat);
			ps.setString(2, prof);
			
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
	public List<absence> verifabsence(String classe, String matiere, String etudiant,String date) {
String sql = "select * from absence where classe=? && seance=? && et_matricule=? && date=?";
		
		List<absence> liste = new ArrayList<absence>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, classe);
			ps.setString(2, matiere);
			ps.setString(3, etudiant);
			ps.setString(4, date);
			resultat = ps.executeQuery();
			
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					
					
					absence abs = new absence();
					
					abs.setId(resultat.getInt("id"));
					abs.setEt_matricule(resultat.getString("et_matricule"));
					abs.setSeance(resultat.getString("seance"));
					abs.setDate(resultat.getString("date"));
					abs.setClasse(resultat.getString("classe"));
					abs.setProf(resultat.getString("prof"));
					abs.setEtat(resultat.getString("etat"));
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(abs);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
		
	}
	@Override
	public List<absence> getAbsence(String classe, String matiere, String prof,String date) {
String sql = "select * from absence where classe=? && seance=? && prof=? && date=?";
		
		List<absence> liste = new ArrayList<absence>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, classe);
			ps.setString(2, matiere);
			ps.setString(3, prof);
			ps.setString(4, date);
			resultat = ps.executeQuery();
			
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					
					
					absence abs = new absence();
					
					abs.setId(resultat.getInt("id"));
					abs.setEt_matricule(resultat.getString("et_matricule"));
					abs.setSeance(resultat.getString("seance"));
					abs.setDate(resultat.getString("date"));
					abs.setClasse(resultat.getString("classe"));
					abs.setProf(resultat.getString("prof"));
					abs.setEtat(resultat.getString("etat"));
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(abs);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	

}
