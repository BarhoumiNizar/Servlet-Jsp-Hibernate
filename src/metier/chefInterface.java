package metier;

import java.util.List;


import Model.chef;



public  interface chefInterface {
   //CRUD: les methodes 
	
	public List<chef> getALLChefs();
	public List<chef> verif_chef(String email,String password);
	public void deletechef(int id);
	public void Modifierchef(chef cf);
	public List<chef> verifchef(String email,String tel,String departement);
	
	public List<chef> rech_chef(int id);
	public void ModifierMdp(chef cf);
	public void Modifieretatchef(String etat);
	
}
