<?php
		session_start();
		echo $_SESSION['sess_user'];
		$_SESSION['sess_user']="";
	// if(isset($_SESSION['sess_user'])){
		session_destroy();
		// header("location:index.php");
	// }
	// else{
		header("location:index.php");
		
	// }
  ?>