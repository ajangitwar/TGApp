<?php 
 
include 'connection.php';
 //creating a query
$stmt = $conn->prepare("SELECT TID, fullname, email, mobile, salutation FROM teacher where TID = 8055;");
 
 //executing the query 
$stmt->execute();
 
 //binding results to the query 
$stmt->bind_result($TID, $fullname, $email, $mobile ,$salutation);
 
$teacher = array(); 
 
 //traversing through all the result 
while($stmt->fetch()){
	$temp = array();
	
	$temp['TID'] = $TID; 
	$temp['fullname'] = $fullname; 
	$temp['email'] = $email; 
	$temp['mobile'] = $mobile; 
	$temp['salutation']= $salutation;
	array_push($teacher, $temp);
}
 
 //displaying the result in json format 
 echo json_encode(array('teacherObj' =>$teacher)); 	

 ?>