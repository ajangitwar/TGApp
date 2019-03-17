<?php  
	// echo "enter";
	class DBOperation{
		private $con;
		function __construct(){
			require_once dirname(__FILE__).'/DBConnect.php';
			$db = new DBConnect();
			$this->con = $db->connect();
		}
		function forgetUser($username,$password,$date,$email){
			// $password = md5($pass);
			// $stmt = $this->con->prepare("INSERT INTO `users` (`id`, `username`, `password`) VALUES (null,'$username','$password');");
			
			$stmt = $this->con->prepare("UPDATE teacher SET Uname='".$username."',Password='".$password."',Updated='".$date."';");
			$stmt->bind_param("sss",$username,$password,$date);
			if($stmt->execute()){
				return true;
			}else{
				return false;
			}
		}
	}
?>