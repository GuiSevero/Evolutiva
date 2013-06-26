<!DOCTYPE HTML>
<html>
<head>
   <meta charset="utf-8">
    <title>Computação Evolutiva - Trabalho #1</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

</head>
<body>



<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Computação Evolutiva</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Início</a></li>
              <li><a href="#about">Sobre</a></li>              
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <h2>Universidade Federal do Rio Grande do Sul</h2>

		 <h3>
			Trabalho #1 - Computação Evolutiva
		</h3>

		<form id="file-form" enctype="multipart/form-data">

      <label for="pop-inicial"><b>População Inicial</b></label>
      <div class="input-prepend input-append">
        <span class="add-on">10</span>
        <input class="span4" id="range" type="range" min="10" max="300" value="50" step="1">        
        <span class="add-on">300</span>
      </div>
      <input type="number" class="span2" id="pop-inicial" min="10" max="300" value="50"><br>

      <hr>

      <label for="pop-inicial"><b>Taxa de Mutação</b></label>
      <div class="input-prepend input-append">
        <span class="add-on">0%</span>
        <input class="span4" id="range-mutation" type="range" min="0" max="100" value="50" step="0.5">        
        <span class="add-on">100%</span>
      </div>
      <input type="number" class="span2" id="taxa-mutacao" min="0" max="100" value="50" step="0.5"><br>

      <hr>

      <div class="controls controls-row">
        
        <input type="text" placeholder="Professor(a)" id="txtProf" required>
        <b>Professor</b><br>

        
        <input type="text" placeholder="Disciplina" id="txtDisciplina" required>
        <b>Disciplina</b><br>

        
        <input type="number" id="nro_aulas" min="2" max="8" value="2" step="2">
        <b>Créditos</b><br>
        <a class="btn btn-info" id="btnAddProf" class="btn btn-primary">Adicionar</a>
      </div>
      <hr>

      <div span="12">
    <table class="table table table-bordered table-striped table-hover " id="table-prof">
      <thead>
        <th>Professor</th>
        <th>Disciplina</th>
        <th>Créditos</th>
      </thead>
      
      
    </table>
    </div>

      <hr>
      <br>
      <div class="row">
			<a id="start" class="btn  span12">Iniciar</a>
      </div>  

		</form>

    

    <h3>Saída</h3>
		<div id="result" class="well">
    </div>


    </div> <!-- /container -->


    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/bootstrap.js"></script>    
	<script src="js/ga.js"></script>
	<script src="js/gene.js"></script>
	<script src="js/cromossomo.js"></script>
    <script type="text/javascript">	

    var ga = new GA();


		$('#range').change(function(){

					$('#pop-inicial').val($(this).val());
          ga.populationSize = $(this).val();
					
		})

      $('#range-mutation').change(function(){

          $('#taxa-mutacao').val($(this).val());
          ga.mutationRate = $(this).val();
          
    })

    $('#btnAddProf').click(function(){

      if($('#txtProf').val() != '' && $('#txtDisciplina').val() != ''){

        $('#table-prof').append(
        "<tr class='prof'><td>" 
        + $('#txtProf').val() 
        + '</td><td>'
        + $('#txtDisciplina').val()
        + '</td><td>'
        + $('#nro_aulas').val()
        + "</td></tr>"
        );  

        

        //Adiciona o gen
        for(i=0; i < $('#nro_aulas').val() /2 ;i++ ){

            ga.gens.push({
            disciplina: $('#txtDisciplina').val(),
            professor:  $('#txtProf').val(),
            creditos: $('#nro_aulas').val()
          })

		}

        //Reseta os valores
        $('#txtDisciplina').val('');
        $('#txtProf').val('');
         
      }else{
        alert('Preencha Professor e Disciplina');
      }
      
    });

    $('#start').click(function(){

		ga.generatePop();
		ga.run();

    });

    </script>

</body>
</html>

<!--

// Adicionar limite por número de gerações
// Tipo de cross-over?
// Limite por tempo

-->