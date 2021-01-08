package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.cours;


public class coursImp implements coursInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<cours> getALLCours(String classe) {
String sql = "select * from cours where classe=?";
		
		List<cours> liste = new ArrayList<cours>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
			if(resultat.next()) {
				count=count+1;
				cours crs = new cours();
				
				crs.setClasse(resultat.getString("classe"));
				crs.setDate(resultat.getString("date"));
				crs.setMatiere(resultat.getString("matiere"));
				
				
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(crs);
			}
			// else System.out.println("ok Ajouter!!!!!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return liste;
	}
	
	
	

}
	
