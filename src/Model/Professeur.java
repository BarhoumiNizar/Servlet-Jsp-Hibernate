package Model;

public class Professeur {
	private int id;
	
	private String pf_nom;
	private String pf_prenom;
	private String password;
	private String adresse;
	private String pf_email;
	private String pf_num_tel;
	private String etat;
	private String departement;
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPf_nom() {
		return pf_nom;
	}
	public void setPf_nom(String pf_nom) {
		this.pf_nom = pf_nom;
	}
	public String getPf_prenom() {
		return pf_prenom;
	}
	public void setPf_prenom(String pf_prenom) {
		this.pf_prenom = pf_prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPf_email() {
		return pf_email;
	}
	public void setPf_email(String pf_email) {
		this.pf_email = pf_email;
	}
	public String getPf_num_tel() {
		return pf_num_tel;
	}
	public void setPf_num_tel(String pf_num_tel) {
		this.pf_num_tel = pf_num_tel;
	}
	
	

}
