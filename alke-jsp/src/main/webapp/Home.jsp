<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/afe84ff5fe.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="<KEY>" crossorigin="anonymous"> 
    <link rel="stylesheet" href="./css/styles.css">
    <title>Login</title>
</head>
<body>

  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Alkewallet Bank</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="customerregister.jsp">Crear cuenta</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    <!-- This is the main container that holds the login form and the logo. -->
    <div class="container text-light d-flex justify-content-center flex-column min-vh-100 align-items-center">
        <!-- This is a placeholder for any live alerts that may appear on the page. -->
        <div id="liveAlertPlaceholder"></div>
        <div class="row row-cols-auto">

            <!-- This is the login form. -->
            <form action= "Home" method="post" id="loginForm">
                <!-- This is the logo of the bank. -->
                <div>
                    <img class="alke-icon" src="./img/Alke_Wallet_Brand.png" alt="Alke Wallet">
                </div>

                <!-- This is the username input field. -->
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <i class="fas fa-user icon-user"></i>
                        </div>
                        <input type="text" id="username" placeholder="Username" class="form-control border-3 border-success mb-3">
                    </div>
                </div>

                <!-- This is the password input field. -->
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <i class="fas fa-key icon-key"></i>
                        </div>
                        <input type="password" id="password" placeholder="Password" class="form-control border-3 border-success mb-3">
                    </div>
                </div>

                <!-- This is the submit button for the login form. -->
               <a href="customerlogin.jsp"> <button type="submit" class="custom-btn btn text-light mt-3 bg-gradient bg-success">Log in</button></a>
            </form>
        </div>
    </div>
<footer>
    <div id="footer">
        <p>&copy; 2024 Alkewallet Bank</p>
        <div id="social-media">
            <a href="https://facebook.com" class="social-link">Facebook</a>
            <a href="https://twitter.com" class="social-link">Twitter</a>
            <a href="https://instagram.com" class="social-link">Instagram</a>
        </div>
    </div>
</footer>
 <!-- This is the script file for the login page. -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="<KEY>" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="./js/script.js"></script>
</body>
</html>