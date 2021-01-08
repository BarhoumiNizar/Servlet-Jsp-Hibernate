package metier;

import java.util.List;


import Model.Salle;

public  interface salleInterface {
   //CRUD: les methodes 
	
	public List<Salle> getALLSalles();
	public void deletesalle(int id);
	public void Modifiersalle(Salle sal);
	public List<Salle> verifsalle(String nom);
	public void Modifieretatsalle(String etat);
	
	
	
	
}
