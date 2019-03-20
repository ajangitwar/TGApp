<?php
include 'connection.php';
if ($_SERVER['REQUEST_METHOD']=='POST') {

    if (isset($_POST['username'])) {
       
    $username = $_POST['username'];
    $password = $_POST['password'];
    $query = "SELECT * FROM student WHERE Uname='$username' AND Password='$password'";
    $data = mysqli_query($conn, $query);
    $total = mysqli_num_rows($data);
    while($row = mysqli_fetch_array($data)){
        $user =  $row['Uname'];
    }
    if($total){
        $_SESSION['username']=$user;

        // $result['success'] = "1";
        // $result['user'] = $user;

        // print_r($result);
        echo "True";
    }
    else{
        //  $result['success'] = "0";
        // $result['user'] = "Login Failed";
        // print_r($result);
        echo "False";
    }

  /*
    require_once 'connection.php';

    $sql = "SELECT name FROM reg WHERE username = 'Aj' and password = 'rocks'";
   
    $res = $conn->query($sql);
    $row= mysqli_num_rows($res);

    */
    }
}

?>