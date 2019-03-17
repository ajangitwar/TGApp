<?php
	require 'init.php';
	// if(isset($_POST['FName']) and isset($_POST['FMobNo']) and isset($_POST['FOcc']) and isset($_POST['MName']) and isset($_POST['MMobNo']) and isset($_POST['MOcc'])){
	if(isset($_POST["MMobNo"])){
		$mmob = $_POST["MMobNo"];
	}
		$fname = $_POST["FName"];
		$fmob = $_POST["FMobNo"];
		$focc = $_POST["FOcc"];
		$mname = $_POST["MName"];
		// $mmob = $_POST["MMobNo"];
		$mocc = $_POST["MOcc"];
		$sql = "INSERT into family (`FID`, `FName`, `FMobNo`, `FOcc`, `MName`, `MMobNo`, `MOcc`) values(null,'$fname','$fmob','$focc','$mname','".$mmob."','$mocc');";
	
		if(mysqli_query($con,$sql)){
			echo "Data update successfully...";
		}
		else{
			echo "Error while update...";
		}
	// }
	
	?>