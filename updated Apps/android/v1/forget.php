<?php
	require "init.php";
	$name = $_POST["fullname"];
	$email = $_POST["email"];
	$username = $_POST["username"];
	$password = $_POST["password"];

	$sql = "select * from teacher where Email like '".$email."' and TID like '".."';";

	$result = mysqli_query($con,$sql);
	$response = array();

	if(mysqli_num_rows($result)>0){
		$code = "failed";
		$message = "User already exist...";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode($response);

	}
	else{
		$sql = "update teacher set Uname='".$username."',Password='".$password."' where TID ='123456';";
		$result = mysqli_query($con,$sql);
		$code = "success";
		$message = "Update successfully. Now you can login..";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode($response);
	}
		// echo $result;
	// }
	// 	$sql = "update teacher set Uname='".$username."',Password='".$password."';";
	// 	$result = mysqli_query($con,$sql);
	// 	$code = "success";
	// 	$message = "update successfully..";
	// 	array_push($response,array("code"=>$code,"message"=>$message));
	// 	echo json_encode($response);
	// }
	// else{
	// 	$code = "failed";
	// 	$message = "Sorry, You are not authentication!! ";
	// 	array_push($response,array("code"=>$code,"message"=>$message));
	// 	echo json_encode($response);
	// }
	mysql_close($con);

?>