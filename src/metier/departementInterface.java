package metier;

import java.util.List;

import Model.Filiere;
import Model.departement;

public  interface departementInterface {
   //CRUD: les methodes 
	
	public List<departement> getALLdepartement();
	public void deletedepartement(int id);
	public void ModifierDepartement(departement dep);
	
	public List<departement> verifdepartement(String nom);
	public void Modifieretatdepartement(String etat);
	
	
	
}
