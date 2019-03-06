<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
   Dashboard
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
<div class="sidebar" data-color="purple" data-background-color="black" data-image="../assets/img/sidebar-2.jpg">
      <div class="logo">
        <a href="http://www.creative-tim.com" class="simple-text logo-normal">
           <img src="images/tg.png" class="brand-logo" style="width: 50px;height: 70px;"><br>
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li id="#link1" class="nav-item  <?php if($page == 'Dashboard'){echo 'active';} ?> ">
            <a class="nav-link" href="dashboard.php">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          <li id="#link2" class="nav-item <?php if($page == 'Admin Profile'){echo 'active';} ?>">
            <a class="nav-link" href="Admininfo.php">
              <i class="material-icons">person</i>
              <p>User Profile</p>
            </a>
          </li>
          <li class="nav-item <?php if($page == 'Notifications'){echo 'active';} ?> ">
            <a id="#link6" class="nav-link" href="notifications.php">
              <i class="material-icons">notifications</i>
              <p>Notifications</p>
            </a>
          </li>
          <!-- <li class="nav-item <?php if($page == 'Allot Student'){echo 'active';} ?>">
            <a id="#link5" class="nav-link" href="Allotment.php">
              <i class="material-icons">touch_app</i>
              <p>Allot Student</p>
            </a>
          </li> -->
          <li class="nav-item <?php if($page == 'Register Teacher'){echo 'active';} ?>">
            <a id="#link5" class="nav-link" href="addteacher.php">
              <i class="material-icons">person_add</i>
              <p>Register Teachers</p>
            </a>
          </li>
          <li class="nav-item <?php if($page == 'Register Student'){echo 'active';} ?>">
            <a id="#link5" class="nav-link" href="addstudent.php">
              <i class="material-icons">queue</i>
              <p>Register Student</p>
            </a>
          </li>
          <li class="nav-item ">
            
            <a id="#link5" class="nav-link" href="logout.php">
              <!-- <form action="logout.php" method="POST"> -->
              <i class="material-icons">launch</i>
              <p  name="logout">Log Out</p>
              <!-- </form> -->
            </a>
            
          </li>
        </ul>
        <div class="logo"></div>
      </div>
    </div>


