<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Medi Care</title>
	<!-- Links to Bootstrap CSS JavaScript and CSS files -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js">
</script>

<style>
body {
    background-image: url("resources/images/pic6.jpg");
    background-size: 100% 100%;
	width:100%;
	height:100vh;
    background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
}
	#loginForm{
		margin-top: 25px;
	}
	#footer
	{
	color:white;
	}
	#login
	{
	color:white;
	}
	#registerBtn
	{
	color:white;
	}
</style>
</head>
<body>

	<!-- Navbar including links for patient list and option to add patient -->
    
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark navbar-fixed-top">
         <div class="container">
             <button class="navbar-toggler" data-toggle="collapse" data-target="#Navbar">
                 <span class="navbar-toggler-icon"></span>
             </button>
             <a href="#" class="navbar-brand" style="font-size: 28px;">Medi Care</a>
         </div>
     </nav>
     
     
    <div class="row" id="loginForm">
    	<div class="col-md-4 offset-md-4">
    		<div class="col-md-12" id="login">
    			<h3>Log In</h3>
    		</div>
	        <form action="login" method="post">
			  <div class="form-group">
			    <label for="email">Email address</label>
			    <input type="email" class="form-control" name="email" placeholder="Enter email">
			  </div>
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input type="password" class="form-control" name="password" placeholder="Password">
			  </div>
			  <button id="submitBtn" type="submit" class="btn btn-primary">Submit</button>
				<!--  <button id="registerBtn" type="submit" class="btn btn-primary" onclick="doregister()"> Register</button>  -->
		 		<span style="width: 30px;"></span><a href="" onClick="doregister();" style="text-decoration:underline; font-color:blue;">New User? Click here to Register.</a>
			</form>
    	</div>
    </div> 
</body>
  <!-- Footer -->
	  <footer class="page-footer font-small blue pg-footer" id="footer">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2019 Copyright:
          <a> The Three Musketeers</a>
        </div>
        <!-- Copyright -->
      
      </footer>
      <!-- Footer --> 
      
 <script language="javascript" type="text/javascript">

function doregister()
{
window.open("RegistrationForm.jsp");
}  
</script> 
      
      
<script type="text/javascript">
 
    $('#submitBtn').click(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                password: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>