<?php
	require 'init.php';
	$fname = $_POST["Fullname"];
	$paddr = $_POST["Paddress"];
	$taddr = $_POST["Taddress"];
	$mob = $_POST["MobNo"];
	$email = $_POST["Email"];
	$gender = $_POST["gender"];
	$blood = $_POST["Blood"];
	$dob = $_POST["DOB"];
	$height = $_POST["Height"];
	$weight = $_POST["weight"];
	$uid = $_POST["UID"];
	$pan = $_POST["PAN"];

	$sql = "INSERT into personal(`PID`, `Fullname`, `Paddress`, `Taddress`, `MobNo`, `Email`, `gender`, `Blood`, `DOB`, `Height`, `weight`, `UID`, `PAN`) values(null,'$fname','$paddr','$taddr','$mob','$email','$gender','$blood','$dob','$height','$weight','$uid','$pan');";

	if(mysqli_query($con,$sql)){
		echo "Data update successfully...";
	}
	else{
		echo "Error while update...";
	}
	?>