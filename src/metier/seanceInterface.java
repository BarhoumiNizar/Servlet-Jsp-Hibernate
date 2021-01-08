package metier;

import java.util.List;

import Model.Salle;
import Model.seance;

public  interface seanceInterface {
   //CRUD: les methodes 
	
	public List<seance> getALLSeances();
	public void deleteseance(int id);
	public void Modifierseance(seance seanc);
	public  List<seance> Emploiseance(String jour);
	public  List<seance> EmploiseanceEtudiant(String classe,String jour);
	
	public  List<seance> EmploiseanceProf(String prof,String jour);
	public  List<seance> verifseance(String matiere,String classe,String jour);
	
	public void Modifieretatseance(String etat);
	
	public List<seance> verifseances(String prof,String jour);
	public List<seance> verifsalle(String salle,String jour);
}
