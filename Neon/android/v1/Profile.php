<?php 
	include 'init.php';
	$stmt = $con->prepare("SELECT Fullname,Email,Mobile from teacher;");
	$stmt->execute();
	$stmt -> bind_result($Fullname,$Email,$Mobile);
	$product = array();
	while($stmt ->fetch()){
		$temp = array();
		// $temp['SID']= $SID;
		$temp['Fullname']= $Fullname;
		$temp['Email']= $Email;
		$temp['Mobile']= $Mobile;
		array_push($product,$temp);
	}
	echo json_encode(array('profile'=>$product));
?>