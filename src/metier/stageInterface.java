package metier;

import java.util.List;


import Model.stage;

public  interface stageInterface {
   //CRUD: les methodes 
	
	public List<stage> getStagePfa(String classe);
	public List<stage> getStagePfe(String classe);
	public List<stage> verifStage(String classe,String type,String sujet);
	public List<stage> getStages(String prof);
	public void deletestage(int id);
	public void Modifierstage(stage stg);
	public void Modifieretatstage(String etat,String prof);
	
	
	
}
