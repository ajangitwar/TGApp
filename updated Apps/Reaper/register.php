<?php 
 
 $user = $_POST['name'];
 $username = $_POST['username'];
 $pass = $_POST['password'];

$que = "SELECT username from reg where username = '$username'";
$res = $conn->query($que);
if (mysqli_num_rows($res) > 0) {
	echo "User Exists !";

	mysqli_close($conn);

}else{

	$que = "INSERT INTO reg (name,username,password) VALUES('$user','$username','$pass');";

	if(mysqli_query($conn,$que)){
		echo "data inserted";
	}else{
		echo "failed to insert";
	}

	mysqli_close($conn);
}
?>