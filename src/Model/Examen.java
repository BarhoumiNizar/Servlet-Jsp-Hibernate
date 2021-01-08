package Model;

public class Examen {
   private int id;
   private String examen_type;
   private String examen_date;
   private String examen_heure_debut;
   private String examen_heure_fin;
   private String examen_note;
   private String prof;
   private String mat;
   private int id_salle;
   private String classe;
   private String etat;
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public String getClasse() {
	return classe;
}
public void setClasse(String classe) {
	this.classe = classe;
}
private int examen_coefficient;
   private String etudiant;
public String getEtudiant() {
	return etudiant;
}
public void setEtudiant(String etudiant) {
	this.etudiant = etudiant;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getExamen_type() {
	return examen_type;
}
public void setExamen_type(String examen_type) {
	this.examen_type = examen_type;
}
public String getExamen_date() {
	return examen_date;
}
public void setExamen_date(String examen_date) {
	this.examen_date = examen_date;
}
public String getExamen_heure_debut() {
	return examen_heure_debut;
}
public void setExamen_heure_debut(String examen_heure_debut) {
	this.examen_heure_debut = examen_heure_debut;
}
public String getExamen_heure_fin() {
	return examen_heure_fin;
}
public void setExamen_heure_fin(String examen_heure_fin) {
	this.examen_heure_fin = examen_heure_fin;
}
public String getExamen_note() {
	return examen_note;
}
public void setExamen_note(String examen_note) {
	this.examen_note = examen_note;
}


public String getProf() {
	return prof;
}
public void setProf(String prof) {
	this.prof = prof;
}
public String getMat() {
	return mat;
}
public void setMat(String mat) {
	this.mat = mat;
}
public int getId_salle() {
	return id_salle;
}
public void setId_salle(int id_salle) {
	this.id_salle = id_salle;
}
public int getExamen_coefficient() {
	return examen_coefficient;
}
public void setExamen_coefficient(int examen_coefficient) {
	this.examen_coefficient = examen_coefficient;
}

   
}
