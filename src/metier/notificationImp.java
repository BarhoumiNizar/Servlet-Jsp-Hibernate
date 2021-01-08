package metier;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import connexion.connection;
import Model.document_administratif;
import Model.notification;
import Model.stage;

public class notificationImp implements notificationInterface {
	connection conn;
	ResultSet resultat = null;
	@Override
	public List<notification> getALLnotifications(String classe) {
		String sql = "select * from notification where classe=? order By classe,type,date_notification";
		List<notification> liste = new ArrayList<notification>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				notification notif = new notification();
				
				notif.setId(resultat.getInt("id"));
				notif.setClasse(resultat.getString("classe"));
				notif.setContenu(resultat.getString("contenu"));
				notif.setDate_notification(resultat.getString("date_notification"));
				notif.setType(resultat.getString("type"));
				notif.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(notif);
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
	public void deleteNotification(int id) {
		String sql = "delete from notification where id=?";
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
	public List<notification> getALLnotification(String prof) {
		String sql = "select * from notification where prof=?";
		List<notification> liste = new ArrayList<notification>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, prof);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				notification notif = new notification();
				
				notif.setId(resultat.getInt("id"));
				notif.setClasse(resultat.getString("classe"));
				notif.setContenu(resultat.getString("contenu"));
				notif.setDate_notification(resultat.getString("date_notification"));
				notif.setType(resultat.getString("type"));
				notif.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(notif);
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
	public void ModifierNotification(notification notif) {
		String sql = "update notification set date_notification=?,type=?,contenu=?,classe=?,etat='ok' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, notif.getDate_notification());
			ps.setString(2, notif.getType());
			ps.setString(3, notif.getContenu());
			ps.setString(4, notif.getClasse());
			ps.setInt(5, notif.getId());
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
	public List<notification> getNotifications(String classe) {
		String sql = "select * from notification where classe=? and etat='non'";
		List<notification> liste = new ArrayList<notification>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
			resultat = ps.executeQuery();
			
			int count=0;	
			while (resultat.next()) {
				// on va récupérer chaque ligne dans un objet u
				count=count+1;
				notification ntf = new notification();
				//dep.setClasse(resultat.getString("classe"));
				
				ntf.setContenu(resultat.getString("contenu"));
				ntf.setType(resultat.getString("type"));
				ntf.setDate_notification(resultat.getString("date_notification"));
				ntf.setProf(resultat.getString("prof"));
				ntf.setId(resultat.getInt("id"));
				ntf.setEtat(resultat.getString("etat"));
				// Maintenant on va afficher chaque ligne dans une liste
				liste.add(ntf);
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
	public void VuNotification(int id) {
		String sql = "update notification set etat='vu' where id=?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			
			ps.setInt(1, id);
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
	public void Modifieretatnotification(String etat, String prof) {
		String sql = "update notification set etat=? where prof=?";
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
	public List<notification> verifnotification(String classe, String type, String date) {
		String sql = "select * from notification where  classe=? and type=? and date_notification=?";
		List<notification> liste = new ArrayList<notification>();
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(sql);
			ps.setString(1, classe);
			ps.setString(2, type);
			ps.setString(3, date);
		 
			resultat = ps.executeQuery();
				int count=0;	
			
			
				while (resultat.next()) {
					// on va récupérer chaque ligne dans un objet u
					count=count+1;
					notification ntf = new notification();
					//dep.setClasse(resultat.getString("classe"));
					
					ntf.setContenu(resultat.getString("contenu"));
					ntf.setType(resultat.getString("type"));
					ntf.setDate_notification(resultat.getString("date_notification"));
					ntf.setProf(resultat.getString("prof"));
					ntf.setId(resultat.getInt("id"));
					ntf.setEtat(resultat.getString("etat"));
					// Maintenant on va afficher chaque ligne dans une liste
					liste.add(ntf);
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
