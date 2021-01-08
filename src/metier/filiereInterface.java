package metier;

import java.util.List;

import Model.Filiere;

public  interface filiereInterface {
   //CRUD: les methodes 
	
	public List<Filiere> getALLFilieres();
	public List<Filiere> getALLFiliereschef(String departement);
	public void deletefiliere(int id);
	public void Modifierfiliere(Filiere fl);
	public List<Filiere> veriffiliere(String nom,String departement);
	public void Modifieretatfiliere(String etat);
	
	
	
	
}
