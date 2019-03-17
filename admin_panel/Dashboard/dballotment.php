<?php
	include('dbconnection.php');
	$id = $_POST["allot"];
	// echo "hello";
	if(isset($_POST['submit'])){
		if(isset($_POST['check'])){
			$query = "UPDATE `student` SET `alloted` = '1' WHERE sid ='".$_POST["sid"]."';";
			if(mysqli_query($db,$query)){
				if(isset($id)){
					$q = "UPDATE `student` SET `TID` = '$id';";
					if(mysqli_query($db,$q)){
		            	header("location: Allotment.php");			
					}
					else{
						header("location: Allotment.php");
					}
				}
			}
		}
	}
  ?>