<?php
include 'connection.php';
if ($_SERVER['REQUEST_METHOD']=='POST') {

    if (isset($_POST['username'])) {
           
        $username = $_POST['username'];
        $password = $_POST['password'];
        $query = "SELECT * FROM teacher WHERE Uname='$username' AND Password='$password'";
        $data = mysqli_query($conn, $query);
        $total = mysqli_num_rows($data);
        $row = mysqli_fetch_array($data);
        if($total){
            $stmt = $conn->prepare("SELECT TID,fullname,email,mobile,salutation FROM teacher where TID = '".$row['TID']."' ;");
     
            //executing the query 
            $stmt->execute();
     
            //binding results to the query 
            $stmt->bind_result($TID,$fullname,$email,$mobile,$salutation);
            $teacher = array(); 
            while($stmt->fetch()){
                $temp = array();

                $temp['status'] = 'true';
                $temp['TID'] = $TID; 
                $temp['fullname'] = $fullname; 
                $temp['email'] = $email; 
                $temp['mobile'] = $mobile; 
                $temp['salutation']= $salutation;
                array_push($teacher, $temp);
            }
            echo json_encode(array('teacherObj' =>$teacher));
        }
        else{
            $teacher = array(); 
           
                $temp = array();
                $temp['status'] = 'false';
                array_push($teacher, $temp);
            echo json_encode(array('teacherObj' =>$teacher));
        }
    }
}

?>