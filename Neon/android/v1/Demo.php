<?php 
	require_once('init.php');
	$sql = "SELECT * FROM student";
	$i=mysqli_query($con,$sql);
	$num_rows = mysqli_num_rows($i);
	while($row = mysqli_fetch_array($i)){
		$r[]=$row;
		$check=$row['SID'];
	}
	if($check == NULL){
		$r[$num_rows]="Record is not available";
		print(json_encode($r));
	}
	else{
		$r[$num_rows]="success";
		print(json_encode($r));
	}
mysqli_close($con);
?>