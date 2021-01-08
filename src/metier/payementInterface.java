package metier;

import java.util.List;


import Model.Payement;

public  interface payementInterface {
   //CRUD: les methodes 
	
	public List<Payement> verifPayement(String matricule);
	public List<Payement> getAllPayements();
	public void deletepayement(int id);
	public void Modifierpayement(Payement paym);
	public void Modifieretatpayement(String etat);
	
	
	
}
