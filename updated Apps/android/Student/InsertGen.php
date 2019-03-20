<?php
	require 'init.php';

	$instinamex = $_POST["InstiNameX"];
	$yearx = $_POST["YearX"];
	$percentagex = $_POST["PercentageX"];
	$instinamexii = $_POST["InstiNameXII"];
	$yearxii = $_POST["YearXII"];	
	$perxii = $_POST["PerXII"];
	
	$sql = "INSERT INTO `geninstitute` (`EID`, `InstiNameX`, `YearX`, `PercentageX`, `InstiNameXII`, `YearXII`, `PerXII`) VALUES ('', '$instinamex', '$yearx', '$percentagex', '$instinamexii', '$yearxii', '$perxii');";

	if(mysqli_query($con,$sql)){
		echo "Data update successfully...";
	}
	else{
		echo "Error while update...";
	}
?>