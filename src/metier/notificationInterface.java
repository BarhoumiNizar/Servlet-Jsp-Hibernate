package metier;

import java.util.List;


import Model.notification;

public  interface notificationInterface {
   //CRUD: les methodes 
	
	public List<notification> getALLnotifications(String classe);
	public void deleteNotification(int id);
	public void ModifierNotification(notification notif);
	public List<notification> getALLnotification(String prof);
	public List<notification> verifnotification(String classe,String type,String date);
	public List<notification> getNotifications(String classe);
	public void VuNotification(int id);
	public void Modifieretatnotification(String etat,String prof);
	
	
}
