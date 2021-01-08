package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.Payement;



public class payementImp implements payementInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<Payement> verifPayement(String matricule) {
		String sql = "select * from payement where et_matricule=?";
		List<Payement> liste = new ArrayList<Payement>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, matricule);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
				if(resultat.next()) {
				count=count+1;
				Payement pymt = new Payement();
				
				pymt.setEt_matricule(resultat.getString("et_matricule"));
				pymt.setPy_tranche(resultat.getString("py_tranche"));
				
				liste.add(pymt);
			}
			
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return liste;
	}
	@Override
	public List<Payement> getAllPayements() {
		String sql = "select * from payement";
		List<Payement> liste = new ArrayList<Payement>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				Payement paym = new Payement();
				
				paym.setId(resultat.getInt("id"));
				paym.setEt_matricule(resultat.getString("et_matricule"));
				paym.setPy_date(resultat.getString("py_date"));
				paym.setPy_tranche(resultat.getString("py_tranche"));
				paym.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(paym);
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
	public void deletepayement(int id) {
		String sql = "delete from payement where id=?";
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
	public void Modifierpayement(Payement paym) {
		String sql = "update payement set `py_tranche`=?,`py_date`=?,`et_matricule`=?,etat='oui'  where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, paym.getPy_tranche());
			ps.setString(2, paym.getPy_date());
			ps.setString(3, paym.getEt_matricule());
			ps.setInt(4, paym.getId());
			
			
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
	public void Modifieretatpayement(String etat) {
		String sql = "update payement set etat=?";
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
