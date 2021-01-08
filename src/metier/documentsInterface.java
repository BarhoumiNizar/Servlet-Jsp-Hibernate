package metier;

import java.util.List;


import Model.document_administratif;

public  interface documentsInterface {
   //CRUD: les methodes 
	
	public List<document_administratif> getALLdemandes();
	public List<document_administratif> getALLdemandesAdministartion();
	public List<document_administratif> getALLdemandesInscription();
	
	public void RepondreDemande(document_administratif demande,String etat,String validation);
	public void consulterDemande(document_administratif demande,String etat);
	public List<document_administratif> EtatDemande(String matricule);
	public List<document_administratif> getDemandes(String matricule);
	public void deletedocument(int id);
	public void Modifierdocument(document_administratif document);
	public List<document_administratif> verifdemande(String matricule,String document);
	public void Modifieretatdocument(String etat);
}
