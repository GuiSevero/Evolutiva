function GA(){

	//Gens Iniciais
	this.gens = Array();

	this.timeElapsed = 0;
	this.timeOut = 0;
	this.population = Array();

	this.populationSize = 10;
	this.mutationRate = 0.5;

	this.eliteSize = 25;	
	this.steps = 20;
	this.stepsToCrossOver = 10;
	this.num_horarios = 4 * 7; 
	this.canStop = false;

	this.generatePop = function(){

		for(i=0; i < this.populationSize; i++){
			cromossomo = new Cromossomo(this.num_horarios);
			cromossomo.generate(this.gens);
			this.population.push(cromossomo);	
		}
		
		cromossomo.eval();
		
		console.log(cromossomo.val);
		console.log("population");
		console.log(this.population);
		

	};

	this.crossOver = function(){};

	this.run = function(){
	var fitnest = this.population[0];

		while(this.steps !=0){
			this.steps--;
			
			for(var i; i< this.population.length; i++){
				if(this.population[i].val < fitnest.val){
					fitnest = this.population[i];
				}
				else{
					this.population[i].mutate();
					if(this.population[i].val < fitnest.val){
						fitnest = this.population[i];
					}
				}
			}
			if(this.stepsToCrossOver == 0){
				this.stepsToCrossOver = 10;
				
				this.crossOver();
			}
		}
	};

	this.step = function(){};



}