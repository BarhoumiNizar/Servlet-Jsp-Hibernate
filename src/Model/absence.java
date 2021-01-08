package Model;

public class absence {
	private int id;
	private String seance;
	private String et_matricule;
	private String classe;
	private String date;
	private String prof;
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	private String etat;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public String getSeance() {
		return seance;
	}
	public void setSeance(String seance) {
		this.seance = seance;
	}
	public String getEt_matricule() {
		return et_matricule;
	}
	public void setEt_matricule(String et_matricule) {
		this.et_matricule = et_matricule;
	}
	
	
	

}
