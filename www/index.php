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

      <label for="pop-inicial"><b>Tamanho Máximo da População</b></label>
      <div class="input-prepend input-append">
        <span class="add-on">10</span>
        <input class="span4" id="range" type="range" min="25" max="3000" value="50" step="1">        
        <span class="add-on">300</span>
      </div>
      <input type="number" class="span2" id="pop-inicial" min="25" max="3000" value="50"><br>

      <hr>

      <label for="pop-inicial"><b>Limite de Tempo (minutos)</b></label>
      <div class="input-prepend input-append">
        <span class="add-on">1</span>
        <input class="span4" id="range-mutation" type="range" min="1" max="10" value="1" step="1">        
        <span class="add-on">10</span>
      </div>
      <input type="number" class="span2" id="taxa-mutacao" min="1" max="10" value="1" step="1"><br>

      <select id="test">
        <option value="teste1.json" selected>Teste 1</option>
        <option value="teste2.json">Teste 2</option>
      </select>


      
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
    <script type="text/javascript">	

		$('#range').change(function(){

					$('#pop-inicial').val($(this).val());
					
		})

      $('#range-mutation').change(function(){

          $('#taxa-mutacao').val($(this).val());
          
    })


    $('#start').click(function(){

      $('#result').html("Executando...");

		 $.get('ga.php',
      {
         test: $('#test').val()
         ,pop: $('#pop-inicial').val()
         ,time: $('#taxa-mutacao').val()
      }, function(data){

       $('#result').html(data);
     })
		
    });

    </script>

</body>
</html>

<!--

// Adicionar limite por número de gerações
// Tipo de cross-over?
// Limite por tempo

-->