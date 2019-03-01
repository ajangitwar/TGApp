<?php
	include('dbconnection.php');
	if (isset($_POST['submit'])){      
        $date = date("Y-m-d H:i:s");
        $query="INSERT INTO `teacher` (TID,Uname,Password,Fullname,Email,CreatedOn,Active,Updated,Mobile) VALUES ('".$_POST["tid"]."','ahsfh','nuldfjdafj','".$_POST["fullname"]."','njfa@gmail.com','$date',1,'$date','".$_POST["mob"]."')";
		$result = mysqli_query($db,$query);
		if ($result === TRUE) {
			
    	} else {

    	}

    }
?>