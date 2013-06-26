import json.JSONException;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Guilherme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    	String entrada = new String("teste2.json");
    	String entrada2 = new String("teste1.json");
    	
    	/*
    	BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(entrada)));
    	JSONTokener jt = new JSONTokener(bReader);
    	JSONArray jOb = new JSONArray(jt);
    	
    	
    	Cromossomo c = new Cromossomo(entrada);
    	System.out.println(c.toString());
    	System.out.println("\n\n========= CLONE =========");
    	Cromossomo clone = c.clone();
    	
    	System.out.println(clone.toString());
    	*/
    	
    	/*
    	Cromossomo c1 = new Cromossomo(entrada);
    	Cromossomo c2 = new Cromossomo(entrada2);
    	
    	System.out.println("\n\n C1 =============== C1");
    	System.out.println(c1.toString());
    	
    	System.out.println("\n\n C2 =============== C2");
    	System.out.println(c2.toString());
    	
    	c2.crossOver(c1);
    	System.out.println("\n\n CROSS =============== CROSS");
    	System.out.println(c2.toString());
    	//testPopulation(entrada);
    	 * 
    	 */
    	testExecutar(entrada, "teste1", 20, 1);
    }
    
    
    
    /**
     * 
     * @param String input
     */
    public static void testInputFile(String input){
    	
    	
    }
    
    public static void testPopulation(String doc) throws JSONException{
    	AlgoritmoGenetico AG = new AlgoritmoGenetico(25, 1, doc);
    	AG.generatePopulation();
    	int menorVal = AG.getCromossomo(0).getValue();
    	int position = 0;
    	
    	//Cross-over
    	
    	AG.sort();
    	
    	for(int i=0; i < AG.populationSize(); i++){
    		//System.out.println("\n\n" + AG.getCromossomo(i).toString());
    		
    		if(AG.getCromossomo(i).getValue() < menorVal){
    			menorVal = AG.getCromossomo(i).getValue();
    			position = i;
    		}
    	}
    	
    	for(int i=0; i < 10; i++){
    		System.out.println("Valor Encontrado no cromossomo " + i + " : " + AG.getCromossomo(i).getValue());
    	}
    	
    	for(int i=0; i < 2; i++){
    		//System.out.println("Valor Encontrado no filho cromossomo " + i + " : " + filhos[i].getValue() + "\n\n");
    	}
    	
    	System.out.println("Menor Valor Encontrado no cromossomo " + position + " : " + menorVal + "\n\n");
    	//System.out.println("Cromossomo " + position + " : " + AG.getCromossomo(position).toString() );
    	
    }
    
    public static void testCromossomo(String doc) throws JSONException{
    	
    	Cromossomo c = new Cromossomo(doc);
    	c.eval();
    	System.out.println("Cromossomo " + doc +": " + c.getValue());
    	
    }
    
    /**
     * 
     * @param entrada - nome do arquivo de entrada
     * @param saida - nome do arquivo de saída
     * @param pop - tamanho da população inicial
     * @param tempo - tempo maximo
     * @throws JSONException 
     */
    public static void testExecutar(String entrada, String saida, int pop, int tempo) throws JSONException{
    	AlgoritmoGenetico GA = new AlgoritmoGenetico(pop, tempo, entrada);
    	GA.generatePopulation();
    	try {
			GA.Executar(saida);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    	
}

