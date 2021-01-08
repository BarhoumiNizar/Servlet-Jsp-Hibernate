package Model;

public class Filiere {
	private int id;
	private String flr_nom;
	private String dep;
	private String etat;
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlr_nom() {
		return flr_nom;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public void setFlr_nom(String flr_nom) {
		this.flr_nom = flr_nom;
	}
	
	
	

}
