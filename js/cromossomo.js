function Cromossomo(num_horarios){

	this.horarios = Array(num_horarios); //Array com arrays de genes
	this.val = -1;
	this.isValid = false;
	this.gens = Array();	

	this.generate = function(gens){

			 this.init(this.horarios.length);

			this.gens = gens;

			for(var g in this.gens){
				//Gera um numero aleatório entre 0 e num_horario
				var t = Math.floor((Math.random()*this.horarios.length));				

				this.horarios[t].push(this.gens[g]); //clona o objeto para o horario
			}

			this.eval();

	};

	this.init = function(num){
			for(i=0; i < num; i++ ){
			this.horarios[i] = Array();
		}
	};
	

	this.test = function(){
		for(i=0; i<this.horarios.length; i++){
			console.log(this.horarios[i]);
		}

	}

	//Muta o cromossomo
	//Altera uma turma de horário
	this.mutate = function(){

		for(var i in this.horarios){

			//Verifica o primeiro horário que tiver uma turma
			if(this.horarios.length > 0){

				var t = Math.floor((Math.random()*this.horarios.length));
				//remove a primeira turma e coloca em um lugar randômico
				this.horarios[t].push(this.horarios[i].pop());

				//Reavalia o cromossomo
				this.eval();

				break;
			}
		}

		return this;
	};

	//Avalia o cromossomo
	this.eval = function(){};

	//Troca gens de lugar
	this.swap = function(){};


}

/*
*

cromossomo{
	horario1 { gene1, gene2}
	horario2 { gene5, gene4}
	horario3 { gene6, gene7}

}

8:30 segunda
3 turmas de sisop1
4 de fisica

*/