function GA(){

	//Gens Iniciais
	this.gens = Array();

	this.timeElapsed = 0;
	this.timeOut = 0;
	this._population = Array();

	this._populationSize = 1;
	this._eliteSize = 25;

	this.mutationRate = 0.5;
	this.steps = 0;

	this.num_horarios = 4 * 7; 

	this.canStop = false;


	this.generatePop = function(){

		for(i=0; i < this._populationSize; i++){
			cromossomo = new Cromossomo(this.num_horarios);
			cromossomo.generate(this.gens);
			this._population.push(cromossomo);	
		}
			
		console.log("_population");
		console.log(this._population);
		

	};

	this.crossOver = function(){};

	this.run = function(){};

	this.step = function(){};



}