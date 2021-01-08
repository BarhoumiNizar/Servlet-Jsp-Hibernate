package metier;

import java.util.List;

import Model.absence;

public  interface absenceInterface {
   //CRUD: les methodes 
	
	public List<absence> getALLAbsences(String prof);
	public void deleteAbsence(int id);
	public void ModifierAbsence(absence abs);
	public void Modifieretatnote(String etat,String prof);
	public List<absence> verifabsence(String classe,String matiere,String etudiant,String date);
	public List<absence> getAbsence(String classe,String matiere,String prof,String date);
	
}
