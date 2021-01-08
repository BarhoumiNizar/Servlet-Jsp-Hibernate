package Model;

public class document_administratif {

	private int id;
	private String etudiant;
	private String type_document;
	private String etat;
	public String getEtats() {
		return etats;
	}
	public void setEtats(String etats) {
		this.etats = etats;
	}
	private String etats;
	private String vu;
	private String date;
	private String date_validation;
	public String getDate_validation() {
		return date_validation;
	}
	public void setDate_validation(String date_validation) {
		this.date_validation = date_validation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVu() {
		return vu;
	}
	public void setVu(String vu) {
		this.vu = vu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(String etudiant) {
		this.etudiant = etudiant;
	}
	public String getType_document() {
		return type_document;
	}
	public void setType_document(String type_document) {
		this.type_document = type_document;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
