<?php
	include('dbconnection.php');
	if (isset($_POST['submit'])){ 
		// $uname = $_POST['uname'];
		// $pass = $_POST['pass'];      
        $date = date("Y-m-d H:i:s");
        $query="INSERT INTO `teacher` (TID,Uname,Password,Fullname,Email,CreatedOn,Active,Updated,Mobile) VALUES (null,'".$_POST["uname"]."','".$_POST["pass"]."','".$_POST["fullname"]."','".$_POST["email"]."','$date',1,'$date','".$_POST["mob"]."')";
		$result = mysqli_query($db,$query);
		if ($result === TRUE) {
			
    	} else {

    	}
    	mysqli_close($db);
    }
?>