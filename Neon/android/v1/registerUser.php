<?php  
	require_once'../includes/DBOperation.php';
	$response = array();
	$date = date("Y-m-d H:i:s");
	if($_SERVER['REQUEST_METHOD']=='POST'){
		if(
			isset($_POST['username']) and
				isset($_POST['password']) and isset($_POST['email'])
			){
			$db = new DBOperation();
			if($db->forgetUser($_POST['username'],$_POST['password'],$date,$_POST['email'])){
				$response['code'] = false;
				$response['message'] = "User registered successfully";	
			}else{
				$response['code'] = true;
				$response['message'] = "Some error occurred please try again";
			}
		}else{
			$response['code'] = true;
			$response['message'] = "Required fields are missing";	
		}
	}else{
		$response['code'] = true;
		$response['message'] = "Invalid Request";

	}
	echo json_encode($response);

	
?>