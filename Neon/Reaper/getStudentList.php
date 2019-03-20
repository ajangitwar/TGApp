<?php 
 
include 'connection.php';
 //creating a query
$stmt = $conn->prepare("SELECT SID, fullname, year, semester FROM student;");
 
 //executing the query 
$stmt->execute();
 
 //binding results to the query 
$stmt->bind_result($SID, $fullname, $year, $semester);
 
$products = array(); 
 
 //traversing through all the result 
while($stmt->fetch()){
	$temp = array();
	$temp['SID'] = $SID; 
	$temp['fullname'] = $fullname; 
	$temp['year'] = $year; 
	$temp['semester'] = $semester; 
	array_push($products, $temp);
}
 
 //displaying the result in json format 
 echo json_encode(array('studentObj' =>$products)); 	

 ?>