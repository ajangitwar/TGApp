<?php
	include('dbconnection.php');
	$sid = $_POST["sid"];
	if(isset($_POST['submit'])){
		if(isset($_POST['check'])){
			$query = "UPDATE `student` SET `alloted` = '1' WHERE sid ='$sid';";
			if(mysqli_query($db,$query)){
            	header("location: Allotment.php");			
			}
			else{
				header("location: Allotment.php");
			}
		}
	}
  ?>