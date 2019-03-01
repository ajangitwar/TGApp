<?php
include('dbconnection.php');
if (isset($_POST['submit'])){      
    if (isset($_POST['username']) && isset($_POST['pass'])){
        $fname=$_POST['fname'];
        $email=$_POST['email'];                 
        $username=$_POST['username'];
        $pass=$_POST['pass'];
        $repass=$_POST['repass'];
        $date = date('Y-m-d H:i:s');
        $msg="";
        $slquery = "SELECT * FROM admin WHERE email = '$email'";
        $selectresult = mysqli_query($db,$slquery);
        if(mysqli_num_rows($selectresult)>0){
            // $msg = 'Email already exists';
        }
        elseif($pass != $repass){
            $msg = "Passwords doesn't match";
        }
        else{
            $query = "UPDATE `admin` SET `Password`=$pass WHERE AID=1";
            mysqli_query($db,$query);
        }
    }
}
?>