package Model;

public class stage {
	private int id;
	private String stg_sujet;
	private String stg_type;
	private String stg_entreprise;
	private String prof;
	private String classe;
	private String stg_date_debut;
	private String stg_date_fin;
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
	public String getStg_sujet() {
		return stg_sujet;
	}
	public void setStg_sujet(String stg_sujet) {
		this.stg_sujet = stg_sujet;
	}
	public String getStg_type() {
		return stg_type;
	}
	public void setStg_type(String stg_type) {
		this.stg_type = stg_type;
	}
	public String getStg_entreprise() {
		return stg_entreprise;
	}
	public void setStg_entreprise(String stg_entreprise) {
		this.stg_entreprise = stg_entreprise;
	}
	
	
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getStg_date_debut() {
		return stg_date_debut;
	}
	public void setStg_date_debut(String stg_date_debut) {
		this.stg_date_debut = stg_date_debut;
	}
	public String getStg_date_fin() {
		return stg_date_fin;
	}
	public void setStg_date_fin(String stg_date_fin) {
		this.stg_date_fin = stg_date_fin;
	}



}
