<?php 
	include 'init.php';
	$stmt = $con->prepare("SELECT SID,fullname,year,semester from student;");
	$stmt->execute();
	$stmt -> bind_result($SID,$fullname,$year,$semester);
	$product = array();
	while($stmt ->fetch()){
		$temp = array();
		$temp['SID']= $SID;
		$temp['fullname']= $fullname;
		$temp['year']= $year;
		$temp['semester']= $semester;
		array_push($product,$temp);
	}
	echo json_encode(array('list'=>$product));
?>