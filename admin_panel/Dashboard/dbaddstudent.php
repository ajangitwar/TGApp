<?php
	include('dbconnection.php');
	if (isset($_POST['submit'])){      
        $date = date("Y-m-d H:i:s");
        $query="INSERT INTO student(SID, TID, fullname, Uname, Password, year, semester, CreatedOn, Active, alloted) VALUES ('".$_POST["sid"]."', '0','".$_POST["fname"]."','".$_POST["uname"]."','".$_POST["pass"]."','".$_POST["year"]."','".$_POST["sem"]."','$date','1','0')";
		// $result = ;
		if (mysqli_query($db,$query)) {
            header("location: addstudent.php");			
    	} else {
    		echo "Could not add data".mysqli_error($db);
    	}
    	mysqli_close($db);

    }
?>