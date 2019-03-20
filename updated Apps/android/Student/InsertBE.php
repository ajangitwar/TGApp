<?php
	require 'init.php';
	$instinamebe = $_POST["InstiName"];
	$branch = $_POST["Branch"];
	$iper = $_POST["Iper"];
	$iiper = $_POST["IIper"];
	$iiiper = $_POST["IIIper"];
	$ivper = $_POST["IVper"];
	$vper = $_POST["Vper"];
	$viper = $_POST["VIper"];
	$viiper = $_POST["VIIper"];
	$viiiper = $_POST["VIIIper"];
	$backlog = $_POST["backlogs"];

	// $sql = "INSERT into `beinfo` (`EID`, `InstiName`, `Branch`, `Iper`, `IIper`, `IIIper`, `IVper`, `Vper`, `VIper`, `VIIper`, `VIIIper`, `backlogs`) values(null,'$instinamebe','$branch','$iper','$iiper','$iiiper','$ivper','$vper','$viper','$viiper','$viiiper','$backlog');";	

	$sql = "INSERT INTO `beinfo` (`EID`, `InstiName`, `Branch`, `Iper`, `IIper`, `IIIper`, `IVper`, `Vper`, `VIper`, `VIIper`, `VIIIper`, `backlogs`) VALUES ('', '$instinamebe', '$branch', '$iper', '$iiper', '$iiiper', '$ivper', '$vper', '$viper', '$viiper', '$viiiper', '$backlog');";

	if(mysqli_query($con,$sql)){
		echo "Data update successfully...";
	}
	else{
		echo "Error while update...";
	}
?>	