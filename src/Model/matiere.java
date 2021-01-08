package Model;

public class matiere {
	private int id;
	
	private String mat_nom;
	private int mat_mass_horaire;
	private String classe;
	private int mat_coefficient;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMat_nom() {
		return mat_nom;
	}
	public void setMat_nom(String mat_nom) {
		this.mat_nom = mat_nom;
	}
	
	public int getMat_mass_horaire() {
		return mat_mass_horaire;
	}
	public void setMat_mass_horaire(int mat_mass_horaire) {
		this.mat_mass_horaire = mat_mass_horaire;
	}
	
	
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getMat_coefficient() {
		return mat_coefficient;
	}
	public void setMat_coefficient(int mat_coefficient) {
		this.mat_coefficient = mat_coefficient;
	}
	
	
}
