package metier;

import java.util.List;

import Model. Administration;


public  interface administrationInterface {
   //CRUD: les methodes 
	
	
	public List<Administration> verif_admin(String login,String password);
	public List<Administration> rech_admin(int id);
	public void ModifierLogin(Administration login);
	public void ModifierMdp(Administration login);
	
	
}
