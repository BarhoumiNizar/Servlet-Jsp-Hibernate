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
import Model.emploieEtudiant;

public class emlpoieImp implements emlpoieInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<emploieEtudiant> getALLEmploie(String classe) {
String sql = "select * from emploieEtudiant where classe=?";
		
		List<emploieEtudiant> liste = new ArrayList<emploieEtudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				emploieEtudiant emploie = new emploieEtudiant();
				
			
				emploie.setLundi(resultat.getString("lundi"));
				emploie.setMardi(resultat.getString("mardi"));
				emploie.setMercredi(resultat.getString("mercredi"));
				emploie.setJeudi(resultat.getString("jeudi"));
				emploie.setVendredi(resultat.getString("vendredi"));
				emploie.setSamedi(resultat.getString("samedi"));
				emploie.setClasse(resultat.getString("classe"));
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(emploie);
			}
			// else System.out.println("ok Ajouter!!!!!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return liste;
	}
	
	
	

}
	
