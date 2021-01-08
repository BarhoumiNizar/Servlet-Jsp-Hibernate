package Model;

public class emploie_temps_prof {

	private int id;
	private String lundi;
	private String mardi;
	private String mercredi;
	private String jeudi;
	
	private String vendredi;
	private String samedi;
	
	private String prof;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLundi() {
		return lundi;
	}
	public void setLundi(String lundi) {
		this.lundi = lundi;
	}
	public String getMardi() {
		return mardi;
	}
	public void setMardi(String mardi) {
		this.mardi = mardi;
	}
	
	public String getMercredi() {
		return mercredi;
	}
	public void setMercredi(String mercredi) {
		this.mercredi = mercredi;
	}
	public void setJeudi(String jeudi) {
		this.jeudi = jeudi;
	}
	public String getJeudi() {
		return jeudi;
	}
	public String getVendredi() {
		return vendredi;
	}
	public void setVendredi(String vendredi) {
		this.vendredi = vendredi;
	}
	public String getSamedi() {
		return samedi;
	}
	public void setSamedi(String samedi) {
		this.samedi = samedi;
	}
	
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	
}
