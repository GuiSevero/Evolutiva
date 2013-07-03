import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import json.JSONArray;
import json.JSONException;
import json.JSONTokener;


public class Cromossomo implements Comparable<Cromossomo> {
	
	
	private int _value = -1; //Valor 
	private int length = 0;
	private boolean _isValid = true;
	public int _numHorarios = 20; // 20 horarios diferentes por semana
	public int _maxTurmaHorario = 5; //Nro máximo 5 turmas num mesmo horario
	public Gene[][] _horarios;
	public ArrayList<Gene> _genes = new ArrayList<Gene>();
	
	/*public String hNames[
	                     "Segunda - 8:30"
	                     ,"Segunda - 10:30"
	                     ,"Segunda - 13:30"
	                     ,"Segunda - 15:30"
	                     ,"Terca - 8:30"
	                     ,"Terca - 10:30"
	                     ,"Terca"
	                     ]; */
	
	/**
	 * Construtoi um novo cromossomo a partir do arquivo especificado por parametro
	 * Será uma instancia do problema de otimização
	 * @param document
	 * @throws JSONException 
	 */
	public Cromossomo(String document) throws JSONException{
		
		this._horarios = new Gene[this._numHorarios][this._maxTurmaHorario];
		try {
			this.fetch(document);
			this.eval();
		} catch (IOException e) {
			new Exception("Erro ao abrir arquivo");
			e.printStackTrace();
		} catch (NumClassesOverFlow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Constroi um novo cromossomo alocando o número de genes passado por parametro
	 * @param gens
	 */
	public Cromossomo (){
		this._horarios = new Gene[this._numHorarios][this._maxTurmaHorario];
	}
	
	
	/**
	 * retorna o gene da posicao i do cromossomo
	 * @param h - horario
	 * @param i - Posicao dentro do horario
	 * @return Gene
	 */
	public Gene getGen(int h,int i){
		return this._horarios[h][i];
	}
	
	/**
	 * Seta o gene g na posição i
	 * @param i
	 * @param g
	 */
	public void setGen(int h, int i,Gene g){
		 this._horarios[h][i] = g;
	}
	
	
	
	/**
	 * retorna o valor avaliado para este cromossomo
	 * @return
	 */
	public int getValue(){
		return _value;
	}
	
	
	/**
	 * retorna o numero de genes deste cromossomo
	 * @return
	 */
	public int length(){
		return this._numHorarios;
	}
	
	/**
	 * Avalia o cromossomo em termos do jobTime, lateness, e seu peso
	 * 
	 */
	public void eval(){
		/*
		ArrayList<Gene> searchedGenes = new ArrayList<Gene>();
		
		for(int i=0; i<this._numHorarios;i++){
			for(int j=0; j < this._maxTurmaHorario; j++){
				if(this._horarios[i][j] != null && (searchedGenes.indexOf(this._horarios[i][j]) > -1)){
					searchedGenes.add(this._horarios[i][j]);
				}
			}
			
		}*/
		this.FitnessFunction();
	}
	
	/**
	 * Carrega um documento padrão de entrada e atribui seus genes neste cromossomo
	 * @param document
	 * @throws IOException
	 * @throws JSONException 
	 * @throws NumClassesOverFlow 
	 */
	 protected void fetch(String arquivo) throws IOException, JSONException, NumClassesOverFlow{
		 
		int target;	
		BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)));
	    	
	    JSONTokener jt = new JSONTokener(bReader);
	    JSONArray jsonGenes = new JSONArray(jt);
	    
	    if(jsonGenes.length() > this._numHorarios * this._maxTurmaHorario){
	    	throw new NumClassesOverFlow("Numero de aulas excedido");
	    }
	    
	    
   
        //Inicia a população
        for(int i=0; i < jsonGenes.length(); i++){

        	//Instancia o gene a partir do JSON de entrada
        	Gene g = new Gene(jsonGenes.get(i));
        			
        	//Sorteia uma posicao para colocar o gene
        	Random r = new Random();
        	 target = r.nextInt(this._numHorarios);
        	 
        	 //Atribui um ID para o gene
        	 g.id = i;
        	 
        	 //Adiciona na lista de genes
        	 this._genes.add(g);
        	 
        	//Coloca o gene na posicao sorteada
        	 for(int j=0; j < this._maxTurmaHorario; j++ ){
        		 if(this._horarios[target][j] == null){
        			 this._horarios[target][j] = g;
        			 break;
        		 }
        			 
        	 }
        	
        }
        
	 }
	 
	/**
	 * Faz a cópia de um cromossomo
	 * @return Cromossomo - Cromossomo clonado
	 */
	 public Cromossomo clone(){
		  //Instancia um novo Cromossomo
		  Cromossomo c = new Cromossomo();
		  c._genes = this._genes;
		  
		  for(int i=0; i < this._numHorarios; i++)
			  for(int j=0; j < this._maxTurmaHorario; j++){
				  if(this._horarios[i][j] != null)
					  c._horarios[i][j] = this._horarios[i][j].clone();
			  }
		  c.eval();
		  
		 return c;
	 }
	 
	 
	 /**
	  * Retorna uma string com informações do cromossomo
	  * @return String
	  */
	 public String toString(){
		 
		  ArrayList<String> hNames = new ArrayList<String>();
		  hNames.add("Segunda - 8:30");
		  hNames.add("Segunda - 10:30");
		  hNames.add("Segunda - 13:30");
		  hNames.add("Segunda - 15:30");
		  hNames.add("Terca - 8:30");
		  hNames.add("Terca - 10:30");
		  hNames.add("Terca - 13:30");
		  hNames.add("Terca - 15:30");
		  hNames.add("Quarta - 8:30");
		  hNames.add("Quarta - 10:30");
		  hNames.add("Quarta - 13:30");
		  hNames.add("Quarta - 15:30");
		  hNames.add("Quinta - 8:30");
		  hNames.add("Quinta - 10:30");
		  hNames.add("Quinta - 13:30");
		  hNames.add("Quinta - 15:30");
		  hNames.add("Sexta - 8:30");
		  hNames.add("Sexta - 10:30");
		  hNames.add("Sexta - 13:30");
		  hNames.add("Sexta - 15:30");

		  boolean found = false;
		 
		 StringBuffer buf = new StringBuffer();
		 
		 buf.append("<dl>");
		 for(int i=0; i < this._numHorarios; i++){
			 buf.append("<dt>" + hNames.get(i) + "</dt>");
			 found = false;
			 for(int j=0; j < this._maxTurmaHorario; j++){
				 //Append do cromossomo i,j
				 if(this._horarios[i][j] != null){
					 found = true;
					 buf.append(this._horarios[i][j].toString() + "<hr>");
				 }
			 }
			 
			 if(!found) buf.append("<dd> Nenhuma turma cadastrada neste horario</dd>");
			 
		 }
		 buf.append("</dl><hr>");
		 
		 buf.append("\r\nValor: " + this._value);
		 
		 return buf.toString();
	 }

	
	 /**
	  * Implementa a classe Comparable para poder ordenar os cromossomos e selecionar os melhores
	  */
	@Override
	public int compareTo(Cromossomo o) {
		
		//Verifica se esse objeto é pior que o cromossomo 'o'
		if(this._value > o.getValue()){
			return -1;
		}
		
		//Verifica se esse cromossomo é melhor que o cromossomo 'o'
		if(this._value < o.getValue()){
			return 1;
		}
		
		//Os cromossomos tem mesma qualidade
		return 0;
	}
	
	 /**
	  * Faz o swap de dois genes
	  * o primeiro gene é sorteado dentro da coluna i
	  * o seugndo gene é sorteado dentro da coluna j
	  * @param i - Coluna i
	  * @param j - Coluna j
	  */
	    protected void swap(int i, int j) {
	    	
	    	Random r = new Random();
	    	
	    	int t1 = r.nextInt(this._maxTurmaHorario); //Sorteia a linha da coluna i
	    	int t2 = r.nextInt(this._maxTurmaHorario); //Sorteia a linha da coluna j
	    	
	    	Gene aux = this._horarios[i][t1];
	    	
	    	this._horarios[i][t1] = this._horarios[j][t2];
	    	this._horarios[j][t2] = aux;
	    	
	    	this.eval();
		}
	    
	    
	    /**
	     * Faz a mutação do Cromossomo
	     * Troca aleatória de dois genes de lugar com probabilidade p
	     * @param int n - tamanho da populaçao para calcular a probabilidade deste cromossomo mutar: prob = 1/n
	     */
	    public Cromossomo mutacao(int n){
	        double mutacao = (double)1 / (double)n;        
	                if (Math.random() < mutacao){ // se número sorteado é menor do que probabilidade
	                	//Ponto de quebra do cross-over
	                    int gen1 = (int)((this.length - 1)*Math.random()); // sorteia o primeiro gene
	                    int gen2 = (int)((this.length - 1)*Math.random()); // sorteia o segundo gene
	                	swap(gen1, gen2);
	                	this.eval();
	                }
	                
	                return this;
	    }
	    
	    protected boolean validate(){
	    	
	    	for(int i=0; i < this._genes.size(); i++){
	    		if(this.hasGen(this._genes.get(i)) != 1) return false;
	    	}
	    	
	    	return true;
	    }
	    
	    public int countGenes(){
	    	int i,j,count = 0;
	    	for(i=0; i < this._numHorarios; i++)
	    		for(j=0; j < this._maxTurmaHorario; j++)
	    			if(this._horarios[i][j] != null) count++;
	    	
	    	return count;
	    }
	    
	    
	    /**
	     * Ve se este cromossomo já tem o Gene g
	     * @param Gene a ser procurado
	     * @return <b>boolean</b> <br><b>true</b>: se tem o gene <br><b>false</b>: caso contrario
	     */
	    public int hasGen(Gene g){
	    	int count = 0;
	    	
	    	if(g == null) return 0;
	    	
	    	for(int i=0; i < this._numHorarios; i++)
				for(int j=0; j <this._maxTurmaHorario; j++)
					if(this._horarios[i][j] != null)
					if(this._horarios[i][j].equals(g))
						count++; //encontrou - retorna true
	    	
	    	return count; //não encontrou - retorna falso
	    }
	    
	    /**
	     * 
	     */
	    public void setGen(int i, Gene g){
	    	
	    	for(int j=0; j < this._maxTurmaHorario; j++ ){
       		 if(this._horarios[i][j] == null){
       			 this._horarios[i][j] = g;
       			 break;
       		 }
	    	}
	    	Random r = new Random();
	    	this.setGen(r.nextInt(this._numHorarios), g);
	    }
	    
	    /**
	     * Faz o crossover
	     * @param pai
	     * @return
	     */
	    public Cromossomo crossOver(Cromossomo pai){
	    	Random r = new Random();
			int posGene = (int)(r.nextInt(pai._numHorarios));
			
			for(int i=posGene; i < pai._numHorarios; i++){
				Gene[] aux;
				
				if(i-1 >= 0){
					aux = pai._horarios[i-1];
					pai._horarios[i-1] = this._horarios[i-1];
					this._horarios[i-1] = aux;
				}
				
			}
			
			pai.eval();
			this.eval();
			
			if(pai.getValue() >= this._value)
				return pai;
			
			return this;
		}
	    
		public void FitnessFunction(){
			int teachersSameTime = 0; 	//hard constraint
			int teachersCrash = 0;		//hard constraint
			int teachersWindows = 0; 	//soft constraint
			int teacherWorth = 50;
			int crashWorth = 80;
			int windowWorth = 10;
			int hasTeacher = -1;
					
			ArrayList<String> teachers = new ArrayList<String>();
			
			for(int k=0; k < 100; k++){
				teachers.add("-");
			}
			
			for(int i=0; i < this._numHorarios; i++){
				
				ArrayList<String> teachersTime = new ArrayList<String>();
				
				for(int j = 0; j < this._maxTurmaHorario; j++){
					//Teacher at the same time
					if(this._horarios[i][j] != null)	
						if(teachersTime.indexOf(this._horarios[i][j].professor)>-1){
							teachersSameTime++;
						}
					
				   if(this._horarios[i][j] != null)
					   hasTeacher = teachers.indexOf(this._horarios[i][j].professor);
				   else
					  hasTeacher = -1;
				   //Teacher has a window
				   if(hasTeacher > -1){
						int diff = i - hasTeacher; 
						teachers.add(hasTeacher, "-");
						if(diff > 1 && diff < 5)
							teachersWindows++;
						
				   }
				   
				   if(this._horarios[i][j] != null)
					   //Teacher can't teach at this time
					   if(this._horarios[i][j].horariosIndisponiveis.indexOf(i) > -1)
						   teachersCrash++;
				   
					if(this._horarios[i][j] !=null)
						teachers.add(i, this._horarios[i][j].professor);
					
					if(this._horarios[i][j] !=null)
						teachersTime.add(this._horarios[i][j].professor);
				}
			}
			
			
			this._value = teachersSameTime * teacherWorth + teachersWindows * windowWorth + teachersCrash * crashWorth;
			
			if(!this.validate()) this._value += 3000;
			
		}
	

}
