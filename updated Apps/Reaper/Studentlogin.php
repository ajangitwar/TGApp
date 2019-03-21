<?php
include 'connection.php';
if ($_SERVER['REQUEST_METHOD']=='POST') {

    if (isset($_POST['username'])) {
           
        $username = $_POST['username'];
        $password = $_POST['password'];
        $query = "SELECT * FROM student WHERE Uname='$username' AND Password='$password'";
        $data = mysqli_query($conn, $query);
        $total = mysqli_num_rows($data);
        $row = mysqli_fetch_array($data);
        if($total){
            $stmt = $conn->prepare("SELECT SID,TID,fullname,year,semester FROM student where SID = '".$row['SID']."' ;");
     
            //executing the query 
            $stmt->execute();
     
            //binding results to the query 
            $stmt->bind_result($SID,$TID,$fullname,$year,$semester);
            $student = array(); 
            while($stmt->fetch()){
                $temp = array();

                $temp['status'] = 'true';
                $temp['SID'] = $SID; 
                $temp['TID'] = $TID; 
                $temp['fullname'] = $fullname; 
                $temp['year'] = $year; 
                $temp['semester'] = $semester; 
                array_push($student, $temp);
            }
            echo json_encode(array('studentObj' =>$student));
        }
        else{
            $teacher = array(); 
           
                $temp = array();
                $temp['status'] = 'false';
                array_push($student, $temp);
            echo json_encode(array('studentObj' =>$student));
        }
    }
}

?>