function Cromossomo(num_horarios){

	this._horarios = Array(num_horarios); //Array com arrays de genes
	this.val = -1;
	this.isValid = false;
	this.gens = Array();	

	this.generate = function(gens){

			 this.init(this._horarios.length);

			this.gens = jQuery.extend({}, gens);

			for(var g in this.gens){
				//Gera um numero aleatório entre 0 e num_horario
				var t = Math.floor((Math.random()*this._horarios.length));				

				this._horarios[t].push(this.gens[g]); //clona o objeto para o horario
			}

			this.eval();

	};

	this.init = function(num){
		for(i=0; i < num; i++ ){
			this._horarios[i] = Array();
		}
	};


	this.test = function(){
		for(i=0; i<this._horarios.length; i++){
			console.log(this._horarios[i]);
		}

	}

	//Muta o cromossomo
	//Altera uma turma de horário
	this.mutate = function(){

		for(var i in this._horarios){

			//Verifica o primeiro horário que tiver uma turma
			if(this._horarios.length > 0){

				var t = Math.floor((Math.random()*this._horarios.length));
				//remove a primeira turma e coloca em um lugar randômico
				this._horarios[t].push(this._horarios[i].pop());

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