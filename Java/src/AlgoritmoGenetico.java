import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import json.JSONException;



public class AlgoritmoGenetico {       
	
	private ArrayList<Cromossomo> _population = new ArrayList<Cromossomo>();
	private ArrayList<Cromossomo> _elite = new ArrayList<Cromossomo>();
	private String _document;
	private BufferedWriter _arquivoSaida;
	private int _minutosMaximo = 1;
	private int _maxPopulationSize = 4000;
	private int _tamanhoElite = 25;
	private Cromossomo _melhorSolucao;
	private int _popInicial = 25;
	private String _inicioDoAlgoritmo;
	private String _ultimaMelhorSolucaoEncontrada;
	private int _maxGenerations = 2000;
	
	/**
	 * 
	 * @param populacaoInicial - tamanho da popula��o inicial
	 * @param tempo - tempo maximo
	 * @param doc - arquivo de entrada
	 */
	public AlgoritmoGenetico(int populacaoInicial, int tempo, String doc){
		if(populacaoInicial >= _tamanhoElite){
			this._popInicial = populacaoInicial;
		}
		
		if(tempo > _minutosMaximo){
			_minutosMaximo = tempo;
		}
		
		this._document = doc;
	}
	
	
	public void sort(){
		Collections.sort(_population);
	}

	/**
	 * Gera uma popula��o inicial de cromossomos.
	 * @param n - Numero de indiv�duos a ser gerado
	 * @param document - arquivo de uma instancia de um problema para servir de semente
	 * @throws JSONException 
	 */
	public void generatePopulation() throws JSONException{
		
		//TODO - FORMATAR SAIDA PARA PADRAO "ENTRADA" - compara com instancias
		
		//Cria um cromossomo semente
		Cromossomo seed = new Cromossomo(_document);
		//shuffleGens(seed);
		seed.eval();
		_melhorSolucao = seed;
		
		//adiciona a semente
		_population.add(seed);
		
		//Cria novos elementos para a popula��o
		for(int i=0; i < _popInicial -1; i++){
			
			//Copia o cromossomo semente
			Cromossomo filho = seed.clone();
			
			//Muta os genes do filho com probabilidade 1/n
			filho.mutacao(_population.size());
			
			//Randomiza os genes
			shuffleGens(filho);
			
			//Avalia o filho
			filho.eval();
			
			//Adiciona a popula��os
			_population.add(filho);
		}
		
		Collections.sort(_population);
		for(int i=0; i < _tamanhoElite; i++){
			_elite.add(_population.get(i));
		}
		Collections.sort(_elite);
		_melhorSolucao = _elite.get(0);
		
		
	}
	
	
	/**
	 * Gera uma popula��o inicial de cromossomos.
	 * @param n - Numero de indiv�duos a ser gerado
	 * @param document - arquivo de uma instancia de um problema para servir de semente
	 */
	public void generatePopulation(Cromossomo seed){
		
		//TODO - FORMATAR SAIDA PARA PADRAO "ENTRADA" - compara com instancias
		
		//Cria um cromossomo semente
		Cromossomo seedAux = seed.clone();
		shuffleGens(seedAux);
		seed.eval();
		
		//adiciona a semente
		_population.add(seedAux);
		
		//Cria novos elementos para a popula��o
		for(int i=0; i < _popInicial -1; i++){
			
			//Copia o cromossomo semente
			Cromossomo filho = seed.clone();
			
			//Muta os genes do filho com probabilidade 1/n
			filho.mutacao(_population.size());
			
			//Randomiza os genes
			shuffleGens(filho);
			
			//Avalia o filho
			filho.eval();
			
			//Adiciona a popula��os
			_population.add(filho);
		}
		
	}
	
	
	
	 /**
	  * Faz o shuffle dos gens de um cromossomo
	  * @param a
	  * 
	  * OK
	  */
	 public  void shuffleGens(Cromossomo a) {
			int n = a.length();
			Random random = new Random();
			random.nextInt();
			for (int i = 0; i < n; i++) {
				int change = i + random.nextInt(n - i);
				swap(a, i, change);
			}
			a.eval();
		}
	    
	 /**
	  * Faz o swap de dois genes
	  * @param a - Cromossomo
	  * @param i - Gene a ser trocado com "change"
	  * @param change
	  * 
	  * OK
	  */
	    protected void swap(Cromossomo a, int i, int change) {
	    	a.swap(i, change);
		}
	    
	    /**
	     * Retorna um determinado cromossomo da popula��o
	     * @param i
	     * @return
	     */
	    public Cromossomo getCromossomo(int i){
	    	return this._population.get(i);
	    }
	    
	    /**
	     * Retorna o tamanho da popula��o
	     * @return
	     */
	    public int populationSize(){
	    	return this._population.size();
	    }
	    
	    /**
	     * seleciona um numero determinado para ser a elite
	     */
	    public void selecionaElite(){
	    	Collections.sort(_population);
			for(int i=0; i < _tamanhoElite; i++){
				_elite.set(i, _population.get(i));
			}
			Collections.sort(_elite);
	    }
	    
	    /**
	     * 
	     * @param arquivo
	     * @throws Exception
	     */
	    public void Executar(String arquivo) throws Exception{                                                   
	    	 // arquivo de sa�da
	        _arquivoSaida = new BufferedWriter(new FileWriter(arquivo));   
	        
	        _inicioDoAlgoritmo = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
	        
	        System.out.println("Algoritmo iniciou para o arquivo " + _document + " as " + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));                
	        System.out.println("Aguarde...");
	        long inicio = System.currentTimeMillis();        
	        int geracoes = 0;
	        
	        
	        //Ordena de forma crescente
	        this.sort();
	        //Pega a melhor solucao
	        _melhorSolucao = _population.get(0);
	        
	        // inicializa��o do algoritmo
	        while (!PararGA(inicio, geracoes)){ // se n�o satisfazer crit�rio de parada
	        	//this.generateFamily(populacao, _document);
	        	
	        	
	        	Cromossomo[] filho = new Cromossomo[5];
	        	Cromossomo seed = selecionaMae();
	        	
	        	//Gera um filho baseado no cross-over de apenas um pai
	        	filho[0] = seed.crossOver(selecionaPai().mutacao(_population.size()));
	        	filho[0].eval();
	        	
	        	//Cria um filho com o cross-over de 2 pais
	        	filho[3] = seed.crossOver(selecionaPai().mutacao(1));
	        	filho[3].eval();
	        	
	        	//Cria um filho com o cross-over de 2 pais com probabilidade de muta��o de 100%
	        	filho[4] = selecionaMae().crossOver(selecionaPai());
	        	filho[4].eval();
	        	
	        	
	        	//Cria um filho rand�mico
	        	filho[1] = _melhorSolucao.clone().mutacao(_population.size());
	        	shuffleGens(filho[1]);
	        	filho[1].eval();
	        	
	        	//Cria um filho baseado na muta��o da melhor solu��o
	        	filho[2] = _melhorSolucao.clone().mutacao(1);
	        	filho[2].eval();
	        		
	        	
	        	//Coloca na elite caso seja uma boa solucao
	        	for(int i=0; i < filho.length; i++){
	        		//Verifica se � melhor que a melhor solucao atual
	        		if(filho[i].getValue() < _melhorSolucao.getValue()){
		        		_melhorSolucao = filho[i].clone();
		        		System.out.println("Nova melhor solucao: " + _melhorSolucao.getValue());
		        		System.out.println("Validade: " + _melhorSolucao.isValid());
		        		_ultimaMelhorSolucaoEncontrada = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		        	}
	        		
	        		//Se for melhor que alguem da elite ele entra pra elite
	        		if(filho[i].getValue() < _elite.get(_elite.size() -1).getValue()){
	        			_elite.set(_elite.size() -1, filho[i]);
	        			//reordena elite
		        		Collections.sort(_elite);
	        			
	        		}
	        		
	        	}
	        	
	        	
	        	
	        	if(_population.size() < _maxPopulationSize){
	        		//Adiciona novos elementos aumentando a popula��o
	        		for(int i=0; i < filho.length; i++){
		        		_population.add(filho[i]);
		        	}
	        		
	        	}else{
	        		/*
	        		//Adiciona os filhos gerados sem aumentar a popula��o
		        	for(int i=0; i < filho.length; i++){
		        		_population.set(_population.size() -i -1, filho[i]);
		        	}
		        	*/
		        	
		        	_population.clear();
		        	_population.addAll(_elite);
		        	generatePopulation(_melhorSolucao);
		        	
	        		/*
	        		Cromossomo melhor = _melhorSolucao;
	        		//Gera uma popula��o nova
	        		_population.clear();
	        		_melhorSolucao = melhor;
	        		//Gera uma nova popula��o a partir da melhor solu��o encontrada como semente
	        		generatePopulation(_melhorSolucao);
	        		*/
	        	}
	        	
	        	
	        	selecionaElite();
	            geracoes ++; 
	            
	            Collections.sort(_elite);
	            Collections.sort(_population);
	            
	        }            
	        System.out.println("Melhor Solucao Encontrada: " + _melhorSolucao.getValue());
	        System.out.println("Algoritmo terminou para o arquivo " + _document + " as " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date()));
	        System.out.println(_melhorSolucao.toString());
	        _arquivoSaida.close();
	        
	    }
	    
	    
	 // Crit�rio de parada do algoritmo: tempo, n�mero de itera��es ou solu��o igual a todos no mesmo bin
	    private boolean PararGA(long inicio, int geracoes) throws Exception {                            
	        // procura pela melhor solu��o at� o momento
	    
	        
	        float minutos = ((System.currentTimeMillis() - inicio)/(float)1000/(float)60);
	        this.sort();
	        // se passou do tempo ou do n�mero de itera��es, ou encontrou todos no mesmo bin como melhor solu��o
	       // if (minutos > _minutosMaximo || populacao > NumeroIteracoesMaximo || MelhorEncontrado == InstanciaBPPC.getNumeroItens() - 1){
        	if ((minutos > _minutosMaximo || this._melhorSolucao.getValue() == 0 )){
	            _arquivoSaida.write("Algoritmo Gen�tico");                        
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("Arquivo: " + _document);            
	            _arquivoSaida.newLine();    
	            _arquivoSaida.write("Melhor valor encontrado: \n\n" + _melhorSolucao.getValue());
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("Tempo m�ximo em minutos: " + _minutosMaximo);
	            _arquivoSaida.newLine();
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("Algoritmo iniciou em: \n\n" + _inicioDoAlgoritmo);
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("Melhor solu��o em: \n\n" + _ultimaMelhorSolucaoEncontrada);
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("N�mero de cromossosmos: " + _population.size());
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("N�mero de cromossosmos iniciais: " + _popInicial);
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("Tamanho da elite: " + _tamanhoElite);
	            _arquivoSaida.newLine();
	            _arquivoSaida.write("Melhor solu��o encontrada: \n\n" + _melhorSolucao.toString());
	           
	            return true;
	        }
	        
	        return false;                 
	    }   
	    
	    /**
	     * Sorteia um cromossomo da popula��o elite
	     * @return
	     */
	    private Cromossomo selecionaPai(){
	    	//Seleciona um pai randomico na elite
	    	return _elite.get((int)((_elite.size() - 1)*Math.random()));
	    	
	    }
	    /**
	     * Sorteia um cromossomo da popula��o inteira
	     * @return
	     */
	    private Cromossomo selecionaMae(){
	    	//Seleciona um pai randomico na elite
	    	return _population.get((int)((_population.size() - 1)*Math.random()));
	    	
	    }
	    
	
}
