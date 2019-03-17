<?php
	require 'init.php';
		$jee = $_POST["JEE"];	
		$mhtcet = $_POST["MHTCET"];
				
		$sql = "INSERT into education (`EID`, `JEE`, `MHTCET`) values(null,'$jee','$mhtcet');";
		
		if(mysqli_query($con,$sql)){
			echo "Data update successfully...";
		}
		else{
			echo "Error while update...";
		}
	
	?>