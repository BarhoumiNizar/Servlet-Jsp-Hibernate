package metier;

import java.util.List;


import Model.Professeur;



public  interface professeursInterface {
   //CRUD: les methodes 
	
	public List<Professeur> getALLProfs();
	public List<Professeur> verif_prof(String email,String password);
	public void deleteprof(int id);
	public void ModifierProf(Professeur prof);
	public List<Professeur> verifprof(String email,String tel);
	public void Modifieretatprof(String etat);
	public List<Professeur> rech_prof(int id);
	public void ModifierMdp(Professeur prof);
	public List<Professeur> getALLProf(String departement);
	
}
