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

public class presidentImp implements presidentInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<Etudiant> StatistiqueSexeMasculin() {
		String sql = "select * from etudiant where et_sexe='masculin'";
		List<Etudiant> liste = new ArrayList<Etudiant>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			resultat = ps.executeQuery();
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				Etudiant dep = new Etudiant();
				dep.setClasse(resultat.getString("classe"));
				
				dep.setId(resultat.getInt("id"));
				
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(dep);
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
	public List<Etudiant> StatistiqueSexeFeminin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
