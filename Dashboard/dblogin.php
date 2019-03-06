<?php
   include('dbconnection.php');
   session_start();
   $msg = "";
   if($_SERVER["REQUEST_METHOD"] == "POST") {
      $sqlquery = "SELECT Uname, Password from admin where AID = 1";
      $result  = mysqli_query($db,$sqlquery);
      $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $count = mysqli_num_rows($result);      
      if($row['Uname'] == $_POST['user'] && $row['Password'] == $_POST['pass']){
         // session_start();
         $_SESSION['sess_user'] = $_POST['user'];
         header("location: dashboard.php");
      }else {
           $msg = "Invalid Username or Password!!!";
      }
   }
      mysqli_close($db);
   
?>
