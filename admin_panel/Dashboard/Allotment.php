<?php $page = 'Allot Student';
              require('dbconnection.php');
              session_start();
  if(!$_SESSION['sess_user']){
    header("location: index.php");
  }
?>
<!DOCTYPE html>
<html lang="en">
 
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
  Allotment 
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../assets/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="dark-edition">
  <div class="wrapper ">

   <?php include("sidebar.php") ?> 
   
    <div class="main-panel">
      <!-- Navbar -->
      <?php include("nav.php") ?> 
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-4 col-md-12">


            <?php
              $query = "SELECT COUNT(*) FROM `student`";
              $result = mysqli_query($db,$query);

              $row=mysqli_fetch_array($result);
              $count=$row[0];
              $titles =  "SELECT * FROM `student` where alloted=0 and Semester=3";
              $title = mysqli_query($db,$titles);
            ?>



              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">3rd Semester</h4>
                  <p class="card-category">This are non alloted Student</p>
                </div>
                <div class="card-body table-responsive">
                  
                  <table class="table table-hover">
                    <form action="dballotment.php" method="post">
                    <thead class="text-warning">
                      <th>ID</th>
                      <th>Name</th>
                      <th>Allot</th>
                    </thead>

                    <tbody>
                        <?php for ($x = 1; $x <= $count; $x++){
                           while( $row = mysqli_fetch_array($title)){
                        ?>
                        
                      <tr>
                        <td><input type="hidden" name="sid" value="<?php echo "{$row[0]}" ?>"><?php echo "{$row[0]}" ?></td>
                        <td><?php echo "{$row[2]}"?></td>
                        <td>
                          <div class="form-check">
                              <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" name="check" >
                                <span class="form-check-sign">
                                  <span class="check"></span>
                                </span>
                              </label>
                          </div>
                        </td>
                      </tr>
                      <?php
                        }
                      }
                       ?>
                    </tbody>
                    <tr>
                        <td>
                          <button type="submit" class="btn btn-primary btn-round" name="submit"> Submit</button>
                        </td>
                      </tr>
                       </form>
                  </table>
                 
                </div>
              </div>
            </div>
            
            <div class="col-lg-4 col-md-12">
              <?php
              $query = "SELECT COUNT(*) FROM `student`";
              $result = mysqli_query($db,$query);

              $row=mysqli_fetch_array($result);
              $count=$row[0];
              $titles =  "SELECT * FROM `student` where alloted=0 and Semester=5";
              $title = mysqli_query($db,$titles);
            ?>

              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">5th Semester</h4>
                  <p class="card-category">This are non alloted Student</p>
                </div>
                <div class="card-body table-responsive">
                  <form action="dballotment.php" method="POST">
                  <table class="table table-hover">
                    <thead class="text-warning">
                      <th>ID</th>
                      <th>Name</th>
                      <th>Allot</th>
                    </thead>
                    <tbody>
                      <?php for ($x = 1; $x <= $count; $x++){
                           while( $row = mysqli_fetch_array($title)){
                        ?>
                        
                      <tr>
                        <td><input type="hidden" name="sid" value="<?php echo "{$row[0]}" ?>"><?php echo "{$row[0]}" ?></td>
                        <td><?php echo "{$row[2]}"?></td>
                        <td>
                          <div class="form-check">
                              <label class="form-check-label">
                                <input class="form-check-input" type="checkbox"  name="check" >
                                <span class="form-check-sign">
                                  <span class="check"></span>
                                </span>
                              </label>
                          </div>
                        </td>
                      </tr>
                      <?php
                        }
                      }
                       ?>
                    </tbody>
                    <tr>
                        <td>
                          <button type="submit" class="btn btn-primary btn-round" name="submit"> Submit</button>
                        </td>
                      </tr>
                      </form>
                  </table>
                
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-12">
              <?php
              $query = "SELECT COUNT(*) FROM `student`";
              $result = mysqli_query($db,$query);

              $row=mysqli_fetch_array($result);
              $count=$row[0];
              $titles =  "SELECT * FROM `student` where alloted=0 and Semester=7";
              $title = mysqli_query($db,$titles);
            ?>

              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">5th Semester</h4>
                  <p class="card-category">This are non alloted Student</p>
                </div>
                <div class="card-body table-responsive">
                  <form action="dballotment.php" method="POST">
                  <table class="table table-hover">
                    <thead class="text-warning">
                      <th>ID</th>
                      <th>Name</th>
                      <th>Allot</th>
                    </thead>
                    <tbody>
                      <?php for ($x = 1; $x <= $count; $x++){
                           while( $row = mysqli_fetch_array($title)){
                        ?>
                        
                      <tr>
                        <td><input type="hidden" name="sid" value="<?php echo "{$row[0]}" ?>"><?php echo "{$row[0]}" ?></td>
                        <td><?php echo "{$row[2]}"?></td>
                        <td>
                          <div class="form-check">
                              <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" name="check">
                                <span class="form-check-sign">
                                  <span class="check"></span>
                                </span>
                              </label>
                          </div>
                        </td>
                      </tr>
                      <?php
                        }
                      }
                       ?>
                    </tbody>
                    <tr>
                        <td>
                          <button type="submit" class="btn btn-primary btn-round" name="submit"> Submit</button>
                        </td>
                      </tr>
                      </form>
                  </table>
                
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

     
<?php include("footer.php") ?> 

<script>
        const x = new Date().getFullYear();
        let date = document.getElementById('date');
        date.innerHTML = '&copy; ' + x + date.innerHTML;
</script>
  </div>
</div>
 
  <!--   Core JS Files   -->
  <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="https://unpkg.com/default-passive-events"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Place this tag in your head or just before your close body tag. -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chartist JS -->
  <script src="../assets/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../assets/js/material-dashboard.js?v=2.1.0"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="../assets/demo/demo.js"></script>
  
</body>
</html>