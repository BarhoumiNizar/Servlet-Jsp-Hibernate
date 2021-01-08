package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.Professeur;
import Model.seance;

public class seanceImp implements seanceInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<seance> getALLSeances() {
		String sql = "select * from seance order By classe,matiere,prof,jours,date_debut";
		List<seance> liste = new ArrayList<seance>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				seance sc = new seance();
				
				sc.setDate_debut(resultat.getString("date_debut"));
				sc.setDate_fin(resultat.getString("date_fin"));
				sc.setJours(resultat.getString("jours"));
				sc.setMatiere(resultat.getString("matiere"));
				sc.setClasse(resultat.getString("classe"));
				sc.setSalle(resultat.getString("salle"));
				sc.setProf(resultat.getString("prof"));
				sc.setId(resultat.getInt("id"));
				sc.setEtat(resultat.getString("etat"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(sc);
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
	public void deleteseance(int id) {
		String sql = "delete from seance where id=?";
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
	public void Modifierseance(seance seanc) {
		String sql = "update seance set date_debut=?,date_fin=?,prof=?,salle=?,matiere=?,classe=?,jours=?,etat='ok' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, seanc.getDate_debut());
			ps.setString(2, seanc.getDate_fin());
			ps.setString(3, seanc.getProf());
			ps.setString(4, seanc.getSalle());
			ps.setString(5, seanc.getMatiere());
			ps.setString(6, seanc.getClasse());
			ps.setString(7, seanc.getJours());
			
			ps.setInt(8, seanc.getId());
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
	public List<seance> Emploiseance(String jour) {
String sql = "select * from seance where jours=?";
		
		List<seance> liste = new ArrayList<seance>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, jour);
		   
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					seance sc = new seance();
					
					sc.setDate_debut(resultat.getString("date_debut"));
					sc.setDate_fin(resultat.getString("date_fin"));
					sc.setJours(resultat.getString("jours"));
					sc.setMatiere(resultat.getString("matiere"));
					sc.setClasse(resultat.getString("classe"));
					sc.setSalle(resultat.getString("salle"));
					sc.setId(resultat.getInt("id"));
					
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(sc);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public List<seance> EmploiseanceEtudiant(String classe,String jour) {
String sql = "select * from seance where classe=? and jours=?";
		
		List<seance> liste = new ArrayList<seance>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
			ps.setString(2, jour);
		   
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					seance sc = new seance();
					
					sc.setDate_debut(resultat.getString("date_debut"));
					sc.setDate_fin(resultat.getString("date_fin"));
					sc.setJours(resultat.getString("jours"));
					sc.setMatiere(resultat.getString("matiere"));
					sc.setClasse(resultat.getString("classe"));
					sc.setSalle(resultat.getString("salle"));
					sc.setProf(resultat.getString("prof"));
					sc.setId(resultat.getInt("id"));
					
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(sc);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public List<seance> EmploiseanceProf(String prof,String jour) {
		
String sql = "select * from seance where prof=? and jours=?";
		
		List<seance> liste = new ArrayList<seance>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof);
			ps.setString(2, jour);
		   
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					seance sc = new seance();
					
					sc.setDate_debut(resultat.getString("date_debut"));
					sc.setDate_fin(resultat.getString("date_fin"));
					sc.setJours(resultat.getString("jours"));
					sc.setMatiere(resultat.getString("matiere"));
					sc.setClasse(resultat.getString("classe"));
					sc.setSalle(resultat.getString("salle"));
					sc.setId(resultat.getInt("id"));
					
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(sc);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
		
		
		
		
	}
	@Override
	public List<seance> verifseance(String matiere, String classe, String jour) {
String sql = "select * from seance where matiere=? and classe=? and jours=?";
		
		List<seance> liste = new ArrayList<seance>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			
			ps.setString(1, matiere);
			ps.setString(2, classe);
			ps.setString(3, jour);
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				seance sc = new seance();
				sc.setMatiere(resultat.getString("matiere"));
				sc.setClasse(resultat.getString("classe"));
				sc.setJours(resultat.getString("jours"));
				liste.add(sc);
			}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void Modifieretatseance(String etat) {
		String sql = "update seance set etat=?";
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
	public List<seance> verifseances(String prof, String jour) {
String sql = "select * from seance where prof=? and jours=?";
		
		List<seance> liste = new ArrayList<seance>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof);
			ps.setString(2, jour);
		   
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					seance sc = new seance();
					
					sc.setDate_debut(resultat.getString("date_debut"));
					sc.setDate_fin(resultat.getString("date_fin"));
					sc.setJours(resultat.getString("jours"));
					sc.setMatiere(resultat.getString("matiere"));
					sc.setClasse(resultat.getString("classe"));
					sc.setSalle(resultat.getString("salle"));
					sc.setProf(resultat.getString("prof"));
					sc.setId(resultat.getInt("id"));
					
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(sc);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public List<seance> verifsalle(String salle, String jour) {
String sql = "select * from seance where salle=? and jours=?";
		
		List<seance> liste = new ArrayList<seance>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, salle);
			ps.setString(2, jour);
		   
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					seance sc = new seance();
					
					sc.setDate_debut(resultat.getString("date_debut"));
					sc.setDate_fin(resultat.getString("date_fin"));
					sc.setJours(resultat.getString("jours"));
					sc.setMatiere(resultat.getString("matiere"));
					sc.setClasse(resultat.getString("classe"));
					sc.setSalle(resultat.getString("salle"));
					sc.setProf(resultat.getString("prof"));
					sc.setId(resultat.getInt("id"));
					
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(sc);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	}
	
	
	


