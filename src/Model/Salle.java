package Model;

public class Salle {
	private int id;
	private String sall_type;
	private String sall_nom;
	private String etat;
	private int sall_etage;
	private String sall_immeuble;
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public String getSall_nom() {
		return sall_nom;
	}
	public void setSall_nom(String sall_nom) {
		this.sall_nom = sall_nom;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSall_type() {
		return sall_type;
	}
	public void setSall_type(String sall_type) {
		this.sall_type = sall_type;
	}
	
	
	public int getSall_etage() {
		return sall_etage;
	}
	public void setSall_etage(int sall_etage) {
		this.sall_etage = sall_etage;
	}
	public String getSall_immeuble() {
		return sall_immeuble;
	}
	public void setSall_immeuble(String sall_immeuble) {
		this.sall_immeuble = sall_immeuble;
	}
	
	

}
