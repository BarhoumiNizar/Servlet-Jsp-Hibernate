package metier;

import java.util.List;


import Model.matiere;

public  interface matiereInterface {
   //CRUD: les methodes 
	
	public List<matiere> getALLMatieres();
	public void deletematiere(int id);
	public void Modifiermatiere(matiere mat);
	public List<matiere> verifmatiere(String nom,String classe);
	public List<matiere> getmatiere(String classe);
	public void Modifieretatmatiere(String etat);
	public List<matiere> getALLMatiere(String departement);
	
	
	
}
