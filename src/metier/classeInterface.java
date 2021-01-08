package metier;

import java.util.List;

import Model.classe;
import Model.departement;

public  interface classeInterface {
   //CRUD: les methodes 
	
	public List<classe> getALLClasses();
	public void deleteclasse(int id);
	public void Modifierclasse(classe cls);
	public List<classe> verifclasse(String nom);
	public void Modifieretatclasse(String etat);
	public List<classe> getALLClasse(String departement);
	
	
	
	
}
