import java.util
.ArrayList;

import json.JSONArray;
import json.JSONException;
import json.JSONObject;


public class Gene implements Cloneable{
		public String professor = "";
	 	public String disciplina = "";
	 	public ArrayList<Integer> horariosIndisponiveis = new ArrayList<Integer>();
		public int id = -1;
	    
	 	
	 	/**
	 	 * Cria um gene a partir de um objeto generico em JSON
	 	 * @param Object gene
	 	 * @throws JSONException
	 	 */
	 	public Gene(Object gene) throws JSONException{
	 		
	 		JSONObject jo = new JSONObject(gene.toString());
	 		this.disciplina = jo.getString("disciplina");
	 		this.professor = jo.getString("professor");
	 		
	 		JSONArray restricoes = new JSONArray();
	 		
	 		if(jo.has("restricoes")){
	 			restricoes = jo.getJSONArray("restricoes");
	 			
	 			for(int i=0; i < restricoes.length(); i++){
	 				horariosIndisponiveis.add(restricoes.getInt(i));
	 			}
	 				
	 		}
	 	}
	 	
	 	
	 	/**
	 	 * 
	 	 * @param d - Disciplina
	 	 * @param p - Professor
	 	 */
	 	public Gene(String d, String p){
	 		this.disciplina = d;
	 		this.professor = p;
	 	}
	 	
	 	/**
	 	 * 
	 	 * @param String d - Disciplina
	 	 * @param String p - Professor
	 	 * @param ArrayList<Integer> r - Restricoes
	 	 */
	 	public Gene(Gene g){
	 		this.disciplina = g.disciplina;
	 		this.professor = g.professor;
	 		this.id = g.id;
	 		
	 		for(int i=0; i < g.horariosIndisponiveis.size(); i++){
	 			this.horariosIndisponiveis.add(g.horariosIndisponiveis.get(i));
	 		}
	 	}
	    
	    public String toString(){
	    	return
	    	"<dd>id: " + id + "</dd>"
	    	+ "<dd>professor: " + professor + "</dd>"
	    	+ "<dd>disciplina: " + disciplina + "</dd>"
	    	+ "<dd>restricoes: " + horariosIndisponiveis.toString() + "</dd>";
	    	
	    }
	    
	    /**
	     * Cria uma instância que é cópia deste gene
	     */
	    public Gene clone(){
	    	Gene g = new Gene(this);
	    	return g;
	    }
	    
	    /**
	     * verifica se o Gene g é igual a este
	     * @param g
	     * @return boolean - se os genes são iguais
	     */
	    public boolean equals(Gene g){
	    	
	    	if(this.id != g.id)
	    		return false;
	    	
	    	if(
	    		this.disciplina != g.disciplina ||
	    		this.professor != g.professor
	    		) return false;
	    	
	    	if(g.horariosIndisponiveis.size() != this.horariosIndisponiveis.size()) return false;
	    	
	    	for(int i=0; i < this.horariosIndisponiveis.size(); i++)
	    		if(g.horariosIndisponiveis.get(i) != this.horariosIndisponiveis.get(i)) return false;
	    	
			return true;
	    }
	    
	    /**
	     * verifica se o Gene g é igual a este
	     * @param g
	     * @return boolean - se os genes são iguais
	     */
	    public boolean sameProfessor(Gene g){
	    	return (this.professor == g.professor) ? true : false;
	    }
	    
}
