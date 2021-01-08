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



public class notesImp implements notesInterface {
	connection conn;
	ResultSet resultat = null;
	Examen not = new Examen();
	@Override
	public List<Examen> getALLNotes(String prof) {
		String sql = "select * from notes where prof=? order by classe,mat,examen_type";
		List<Examen> liste = new ArrayList<Examen>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof);
			resultat = ps.executeQuery();
			
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Examen note = new Examen();
				note.setClasse(resultat.getString("classe"));
				note.setEtudiant(resultat.getString("etudiant"));
				note.setExamen_date(resultat.getString("examen_date"));
				note.setMat(resultat.getString("mat"));
				note.setExamen_heure_debut(resultat.getString("examen_heure_debut"));
				note.setExamen_heure_fin(resultat.getString("examen_heure_fin"));
				note.setExamen_coefficient(resultat.getInt("examen_coefficient"));
				note.setId(resultat.getInt("id"));
				note.setExamen_type(resultat.getString("examen_type"));
				note.setExamen_note(resultat.getString("examen_note"));
				note.setId_salle(resultat.getInt("id_salle"));
				note.setProf(resultat.getString("prof"));
				note.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(note);
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
	public List<Examen> getNotes(String etudiant) {
String sql = "select * from notes where etudiant=?";
		
		List<Examen> liste = new ArrayList<Examen>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, etudiant);
			resultat = ps.executeQuery();
			
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					
					
					not.setExamen_coefficient(resultat.getInt("examen_coefficient"));
					not.setExamen_note(resultat.getString("examen_note"));
					not.setMat(resultat.getString("mat"));
					not.setExamen_date(resultat.getString("examen_date"));
					not.setExamen_type(resultat.getString("examen_type"));
					not.setExamen_heure_debut(resultat.getString("examen_heure_debut"));
					not.setExamen_heure_fin(resultat.getString("examen_heure_fin"));
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(not);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	@Override
	public void deletenote(int id) {
		String sql = "delete from notes where id=?";
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
	public void Modifiernote(Examen note) {
		String sql = "update notes set examen_type=?, examen_date=?, examen_heure_debut=?, examen_heure_fin=?,"
				+ "     examen_note=?, mat=?, examen_coefficient=?, etudiant=?, classe=?,etat='ok' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, note.getExamen_type());
			ps.setString(2, note.getExamen_date());
			ps.setString(3, note.getExamen_heure_debut());
			ps.setString(4, note.getExamen_heure_fin());
			ps.setString(5, note.getExamen_note());
			ps.setString(6, note.getMat());
			ps.setInt(7, note.getExamen_coefficient());
			ps.setString(8, note.getEtudiant());
			ps.setString(9, note.getClasse());
			ps.setInt(10, note.getId());
			
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
	public List<Examen> getALLNotes() {
		String sql = "select * from notes order by classe,mat,examen_type,etudiant";
		List<Examen> liste = new ArrayList<Examen>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			resultat = ps.executeQuery();
			
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Examen note = new Examen();
				note.setClasse(resultat.getString("classe"));
				note.setEtudiant(resultat.getString("etudiant"));
				note.setExamen_date(resultat.getString("examen_date"));
				note.setMat(resultat.getString("mat"));
				note.setExamen_heure_debut(resultat.getString("examen_heure_debut"));
				note.setExamen_heure_fin(resultat.getString("examen_heure_fin"));
				note.setExamen_coefficient(resultat.getInt("examen_coefficient"));
				note.setId(resultat.getInt("id"));
				note.setExamen_type(resultat.getString("examen_type"));
				note.setExamen_note(resultat.getString("examen_note"));
				note.setId_salle(resultat.getInt("id_salle"));
				note.setProf(resultat.getString("prof"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(note);
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
	public void Modifieretatnote(String etat,String prof) {
		String sql = "update notes set etat=? where prof=?";
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
	public List<Examen> verifiernote(String etudiant, String classe, String type, String matiere) {
String sql = "select * from notes where etudiant=? && classe=? && examen_type=? && mat=? ";
		
		List<Examen> liste = new ArrayList<Examen>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setString(1, etudiant);
			ps.setString(2, classe);
			ps.setString(3, type);
			ps.setString(4, matiere);
			resultat = ps.executeQuery();
			
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					
					
					not.setExamen_coefficient(resultat.getInt("examen_coefficient"));
					not.setExamen_note(resultat.getString("examen_note"));
					not.setMat(resultat.getString("mat"));
					not.setExamen_date(resultat.getString("examen_date"));
					not.setExamen_type(resultat.getString("examen_type"));
					not.setExamen_heure_debut(resultat.getString("examen_heure_debut"));
					not.setExamen_heure_fin(resultat.getString("examen_heure_fin"));
					
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(not);
				}
			// else System.out.println("ok Ajouter!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
		
	}
	}

	
	
	
	
	


