package Model;

public class Payement {

	private int id;
	private String py_tranche;
	private String py_date;
	private String et_matricule;
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
	public String getPy_tranche() {
		return py_tranche;
	}
	
	public String getPy_date() {
		return py_date;
	}
	public void setPy_date(String py_date) {
		this.py_date = py_date;
	}
	public void setPy_tranche(String py_tranche) {
		this.py_tranche = py_tranche;
	}
	public String getEt_matricule() {
		return et_matricule;
	}
	public void setEt_matricule(String et_matricule) {
		this.et_matricule = et_matricule;
	}
	
	
	
	
}
