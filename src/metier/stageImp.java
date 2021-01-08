package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;

import Model.stage;

public class stageImp implements stageInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<stage> getStagePfa(String classe) {
		String sql = "select * from stage where stg_type='pfa' and classe=?";
		List<stage> liste = new ArrayList<stage>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
				count=count+1;
				stage pfa = new stage();
				
				pfa.setClasse(resultat.getString("classe"));
				pfa.setStg_date_debut(resultat.getString("stg_date_debut"));
				pfa.setStg_date_fin(resultat.getString("stg_date_fin"));
				pfa.setStg_sujet(resultat.getString("stg_sujet"));
				pfa.setStg_entreprise(resultat.getString("stg_entreprise"));
				pfa.setProf(resultat.getString("prof"));
				
				liste.add(pfa);
			}
			
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return liste;
	}
	
	@Override
	public List<stage> getStagePfe(String classe) {
		String sql = "select * from stage where stg_type='pfe' and classe=?";
		List<stage> liste = new ArrayList<stage>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
				count=count+1;
				stage pfe = new stage();
				
				pfe.setClasse(resultat.getString("classe"));
				pfe.setStg_date_debut(resultat.getString("stg_date_debut"));
				pfe.setStg_date_fin(resultat.getString("stg_date_fin"));
				pfe.setStg_sujet(resultat.getString("stg_sujet"));
				pfe.setStg_entreprise(resultat.getString("stg_entreprise"));
				pfe.setProf(resultat.getString("prof"));
				liste.add(pfe);
			}
			
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return liste;
	}

	@Override
	public List<stage> getStages(String prof) {
		String sql = "select * from stage where prof=? order by classe,stg_type,stg_date_debut";
		List<stage> liste = new ArrayList<stage>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
				count=count+1;
				stage pfa = new stage();
				
				pfa.setClasse(resultat.getString("classe"));
				pfa.setStg_date_debut(resultat.getString("stg_date_debut"));
				pfa.setStg_date_fin(resultat.getString("stg_date_fin"));
				pfa.setStg_sujet(resultat.getString("stg_sujet"));
				pfa.setStg_entreprise(resultat.getString("stg_entreprise"));
				pfa.setStg_type(resultat.getString("stg_type"));
				pfa.setId(resultat.getInt("id"));
				pfa.setEtat(resultat.getString("etat"));
				liste.add(pfa);
			}
			
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return liste;
	}

	@Override
	public void deletestage(int id) {
		String sql = "delete from stage where id=?";
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
	public void Modifierstage(stage stg) {
		String sql = "UPDATE `stage` SET `stg_sujet`=?,`stg_type`=?,`stg_entreprise`=?,"
				+ "`classe`=?,`stg_date_debut`=?,`stg_date_fin`=?,etat='ok' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, stg.getStg_sujet());
			ps.setString(2, stg.getStg_type());
			ps.setString(3, stg.getStg_entreprise());
			ps.setString(4, stg.getClasse());
			ps.setString(5, stg.getStg_date_debut());
			ps.setString(6, stg.getStg_date_fin());
			ps.setInt(7, stg.getId());
			
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
	public void Modifieretatstage(String etat, String prof) {
		String sql = "update stage set etat=? where prof=?";
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
	public List<stage> verifStage(String classe, String type, String sujet) {
		String sql = "select * from stage where  classe=? and stg_type=? and stg_sujet=?";
		List<stage> liste = new ArrayList<stage>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
			ps.setString(2, type);
			ps.setString(3, sujet);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
				count=count+1;
				stage pfe = new stage();
				
				pfe.setClasse(resultat.getString("classe"));
				pfe.setStg_date_debut(resultat.getString("stg_date_debut"));
				pfe.setStg_date_fin(resultat.getString("stg_date_fin"));
				pfe.setStg_sujet(resultat.getString("stg_sujet"));
				pfe.setStg_entreprise(resultat.getString("stg_entreprise"));
				pfe.setProf(resultat.getString("prof"));
				liste.add(pfe);
			}
			
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return liste;
	}
	
	

}
