<?php
	if(isset($_POST['logout'])){
		session_start();
		unset($_SESSION['sess_user']);
		session_destroy();
		header("location:index.php");
	}
  ?>