<?php 
	$host = "localhost";
	$uname = "root";
	$pw = "";
	$db = "tgapp";

	$con = mysqli_connect($host,$uname,$pw,$db);
	if ($con) {
		// echo "connected successfully!";
	}else {
		echo "failed to connect!";
	}
 ?>