function GA(){

	//Gens Iniciais
	this.gens = Array();

	this.timeElapsed = 0;
	this.timeOut = 0;
	this.population = Array();

	this.populationSize = 10;
	this.mutationRate = 0.5;

	this.eliteSize = 25;	
	this.steps = 0;
	this.num_horarios = 4 * 7; 
	this.canStop = false;

	this.generatePop = function(){

		for(i=0; i < this.populationSize; i++){
			cromossomo = new Cromossomo(this.num_horarios);
			cromossomo.generate(this.gens);
			this.population.push(cromossomo);	
		}
			
		console.log("population");
		console.log(this.population);
		

	};

	this.crossOver = function(){};

	this.run = function(){};

	this.step = function(){};



}