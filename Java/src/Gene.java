import json.JSONException;
import json.JSONObject;


public class Gene implements Cloneable{
		public String professor = "";
	 	public String disciplina = "";
	    
	 	
	 	public Gene(Object gene) throws JSONException{
	 		JSONObject jo = new JSONObject(gene.toString());
	 		this.disciplina = jo.getString("disciplina");
	 		this.professor = jo.getString("professor");
	 	}
	 	
	 	public Gene(String d, String p){
	 		this.disciplina = d;
	 		this.professor = p;
	 	}
	    
	    public String toString(){
	    	return
	    	 "professor: " + professor
	    	+ "\ndisciplina: " + disciplina;
	    	
	    }
	    
	    public Gene clone(){
	    	Gene g = new Gene(this.disciplina, this.professor);
	    	return g;
	    }
	    
	    /**
	     * verifica se o Gene g é igual a este
	     * @param g
	     * @return boolean - se os genes são iguais
	     */
	    public boolean equals(Gene g){
	    	if(
	    		this.disciplina == g.disciplina &&
	    		this.professor == g.professor
	    		) return true;
	    	
			return false;
	    }
	    
	    /**
	     * verifica se o Gene g é igual a este
	     * @param g
	     * @return boolean - se os genes são iguais
	     */
	    public boolean sameProfessor(Gene g){
	    	if(this.professor == g.professor) return true; else return false;
	    }
	    
}
