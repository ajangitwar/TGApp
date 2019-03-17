<?php
include 'init.php';
if ($_SERVER['REQUEST_METHOD']=='POST') {
    if (isset($_POST['username'])) {  
        $username = $_POST['username'];
        $password = $_POST['password'];
        $query = "SELECT * FROM student WHERE Uname='$username' AND Password='$password'";
        $data = mysqli_query($con, $query);
        $total = mysqli_num_rows($data);
        while($row = mysqli_fetch_array($data)){
            $user =  $row['Uname'];
        }
        if($total){
            echo "True";
        }
        else{
            echo "False";
        }
    }
}

?>