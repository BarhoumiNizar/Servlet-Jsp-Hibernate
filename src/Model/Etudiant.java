package Model;

public class Etudiant {

	private int id;
	private String matricule;
	private String password;
	private String et_email;
	private String et_nom;
	private String et_prenom;
	private String et_date_naissance;
	private String et_sexe;
	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	private String et_nationalite;
	private String et_num_tel;
	private String et_adresse;
	private String etat;
	private String etats;
	private String filiere;
	public String getEtats() {
		return etats;
	}

	public void setEtats(String etats) {
		this.etats = etats;
	}

	private String et_dernier_etablissement;

	private String classe;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	

	public String getEt_email() {
		return et_email;
	}

	public void setEt_email(String et_email) {
		this.et_email = et_email;
	}

	public String getEt_nom() {
		return et_nom;
	}

	public void setEt_nom(String et_nom) {
		this.et_nom = et_nom;
	}

	public String getEt_prenom() {
		return et_prenom;
	}

	public void setEt_prenom(String et_prenom) {
		this.et_prenom = et_prenom;
	}

	public String getEt_date_naissance() {
		return et_date_naissance;
	}

	public void setEt_date_naissance(String et_date_naissance) {
		this.et_date_naissance = et_date_naissance;
	}

	public String getEt_sexe() {
		return et_sexe;
	}

	public void setEt_sexe(String et_sexe) {
		this.et_sexe = et_sexe;
	}

	public String getEt_nationalite() {
		return et_nationalite;
	}

	public void setEt_nationalite(String et_nationalite) {
		this.et_nationalite = et_nationalite;
	}

	public String getEt_num_tel() {
		return et_num_tel;
	}

	public void setEt_num_tel(String et_num_tel) {
		this.et_num_tel = et_num_tel;
	}

	public String getEt_adresse() {
		return et_adresse;
	}

	public void setEt_adresse(String et_adresse) {
		this.et_adresse = et_adresse;
	}

	public String getEt_dernier_etablissement() {
		return et_dernier_etablissement;
	}

	public void setEt_dernier_etablissement(String et_dernier_etablissement) {
		this.et_dernier_etablissement = et_dernier_etablissement;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	
	
}
