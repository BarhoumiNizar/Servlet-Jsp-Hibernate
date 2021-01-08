package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.document_administratif;

public class documentsImp implements documentsInterface {
	connection conn;
	ResultSet resultat = null;
	
	@Override
	public List<document_administratif> getALLdemandes() {
		String sql = "select * from document_administratif where etat='demande' order by type_document,date,etudiant";
		List<document_administratif> liste = new ArrayList<document_administratif>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				document_administratif demande= new document_administratif();
				demande.setEtat(resultat.getString("etat"));
				demande.setEtudiant(resultat.getString("etudiant"));
				demande.setVu(resultat.getString("vu"));
				demande.setId(resultat.getInt("id"));
				demande.setType_document(resultat.getString("type_document"));
				demande.setDate(resultat.getString("date"));
				demande.setDate_validation(resultat.getString("date_validation"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(demande);
			}
			// Exécution de notre requete
			resultat = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	
	public List<document_administratif> getALLdemandesInscription() {
		String sql = "select * from document_administratif where type_document='inscription'";
		List<document_administratif> liste = new ArrayList<document_administratif>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				document_administratif demande= new document_administratif();
				demande.setEtat(resultat.getString("etat"));
				demande.setEtudiant(resultat.getString("etudiant"));
				demande.setId(resultat.getInt("id"));
				demande.setType_document(resultat.getString("type_document"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(demande);
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
	public void RepondreDemande(document_administratif demande, String etat, String validation) {
		String sql = "update document_administratif set etat=? ,date_validation=? where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, demande.getEtat());
			ps.setString(2, demande.getDate_validation());
			ps.setInt(3, demande.getId());
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
	public List<document_administratif> EtatDemande(String matricule) {
		String sql = "select * from document_administratif where etudiant=? and vu!='consulter'";
		List<document_administratif> liste = new ArrayList<document_administratif>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, matricule);
			resultat = ps.executeQuery();
			
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				document_administratif doc = new document_administratif();
				//dep.setClasse(resultat.getString("classe"));
				
				doc.setEtat(resultat.getString("etat"));
				doc.setEtudiant(resultat.getString("etudiant"));
				doc.setType_document(resultat.getString("type_document"));
				doc.setId(resultat.getInt("id"));
				doc.setDate(resultat.getString("date"));
				doc.setDate_validation(resultat.getString("date_validation"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(doc);
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
	public List<document_administratif> getDemandes(String matricule) {
		String sql = "select * from document_administratif where etudiant=?";
		List<document_administratif> liste = new ArrayList<document_administratif>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, matricule);
			resultat = ps.executeQuery();
			
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				document_administratif doc = new document_administratif();
				//dep.setClasse(resultat.getString("classe"));
				
				doc.setEtat(resultat.getString("etat"));
				doc.setEtudiant(resultat.getString("etudiant"));
				doc.setType_document(resultat.getString("type_document"));
				doc.setId(resultat.getInt("id"));
				doc.setDate(resultat.getString("date"));
				doc.setEtats(resultat.getString("etats"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(doc);
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
	public void Modifierdocument(document_administratif document) {
		String sql = "update document_administratif set type_document=?,date=?,etats='oui' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, document.getType_document());
			ps.setString(2, document.getDate());
			
			ps.setInt(3, document.getId());
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
	public void deletedocument(int id) {
		String sql = "delete from document_administratif where id=?";
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
	public List<document_administratif> getALLdemandesAdministartion() {
		String sql = "select * from document_administratif";
		List<document_administratif> liste = new ArrayList<document_administratif>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				document_administratif demande= new document_administratif();
				demande.setEtat(resultat.getString("etat"));
				demande.setEtudiant(resultat.getString("etudiant"));
				demande.setId(resultat.getInt("id"));
				demande.setType_document(resultat.getString("type_document"));
				demande.setDate(resultat.getString("date"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(demande);
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
	public void consulterDemande(document_administratif demande, String etat) {
		String sql = "update document_administratif set vu=? where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, demande.getEtat());
			
			ps.setInt(2, demande.getId());
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
	public List<document_administratif> verifdemande(String matricule, String document) {
		String sql = "select * from document_administratif where etudiant=? and type_document=?";
		List<document_administratif> liste = new ArrayList<document_administratif>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, matricule);
			ps.setString(2, document);
			resultat = ps.executeQuery();
			
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				document_administratif doc = new document_administratif();
				//dep.setClasse(resultat.getString("classe"));
				
				doc.setEtat(resultat.getString("etat"));
				doc.setEtudiant(resultat.getString("etudiant"));
				doc.setType_document(resultat.getString("type_document"));
				doc.setId(resultat.getInt("id"));
				doc.setDate(resultat.getString("date"));
				doc.setDate_validation(resultat.getString("date_validation"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(doc);
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
	public void Modifieretatdocument(String etat) {
		String sql = "update document_administratif set etats=?";
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
