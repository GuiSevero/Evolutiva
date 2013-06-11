function GA(){

	this.timeElapsed = 0;
	this.timeOut = 0;
	this._population = array();

	this._populationSize = 100;
	this._eliteSize = 25;

	this.mutationRate = 0.5;
	this.steps = 0;

	this.disciplinas = array();
	this.professores = array();

	this.num_horarios = 4 * 7; 

	this.canStop = false;


	this.generatePop = function(){};

	this.crossOver = function(){};

	this.run = function(){};

	this.step = function(){};



}