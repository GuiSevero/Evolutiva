<!DOCTYPE HTML>
<html>
<head>
   <meta charset="utf-8">

</head>
<body>
    <?php

$locale = 'pt_BR';
putenv('LC_ALL='.$locale);

	$args = " " .$_GET['test'] ." " .$_GET['pop'] ." " .$_GET['time'];


    $ret = exec('java -jar ga.jar ' .$args, $result, $res); 
    
    echo implode('<br>', $result);  

?>
</body>
</html>
