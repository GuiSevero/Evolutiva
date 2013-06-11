function Cromossomo(num_horarios){

	this._horarios = array(num_horarios); //Array com arrays de genes
	this.val = -1;
	this.isValid = false;

	//Muta o cromossomo
	this.mutate = function(){};

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