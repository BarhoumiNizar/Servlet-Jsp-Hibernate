package metier;

import java.util.List;


import Model.Etudiant;



public  interface EtudiantInterface {
   //CRUD: les methodes 
	
	public List<Etudiant> getALLEtudiants();
	public List<Etudiant> getALLEtudiantsNonValide();
	public List<Etudiant> verif_etudiant(String matricule,String password);
	public void deleteEtudiant(int id);
	
	public void ModifierEtudiant(Etudiant etudiants);
	public void ValiderEtudiant(int id);
	public List<Etudiant> StatistiqueGenieInfo();
	public List<Etudiant> StatistiqueLicenceInfo();
	public List<Etudiant> StatistiqueLicenceReseaux();
	public List<Etudiant> StatistiqueTunisienne();
	public List<Etudiant> StatistiqueSaudienne();
	public List<Etudiant> StatistiqueLybienne();
	public List<Etudiant> StatistiqueGabonaise();
	public List<Etudiant> StatistiqueCongolaise();
	public List<Etudiant> StatistiquePayementValide();
	public List<Etudiant> StatistiquePayementNonValide();
	public List<Etudiant> rech_etudiant(int id);
	public void ModifierMdp(Etudiant etudiants);
	public List<Etudiant> verif_etudiants(String matricule,String email,String tel);
	public List<Etudiant> verif_etudiant_modif(String email,String tel);
	public void Modifieretatetudiant(String etat);
	
}
