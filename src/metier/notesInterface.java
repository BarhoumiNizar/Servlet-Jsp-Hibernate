package metier;

import java.util.List;


import Model.Examen;
import Model.seance;


public  interface notesInterface {
   //CRUD: les methodes 
	
	public List<Examen> getALLNotes(String prof);
	public List<Examen> getALLNotes();
	public  List<Examen> getNotes(String etudiant);
	
	public void deletenote(int id);
	public void Modifiernote(Examen note);
	public void Modifieretatnote(String etat,String prof);
	public List<Examen> verifiernote(String etudiant,String classe,String type,String matiere);
	
	
	
}
