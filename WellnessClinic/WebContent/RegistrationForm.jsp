<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Medi Care</title>
    
    <!-- Links to Bootstrap CSS JavaSript and CSS files -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	
	<style>
		.underflow{
			background-color: #F08080;
		}
	</style>
</head>
<body>

    <!-- Navbar including links for doctor list and option to add doctor -->
    
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark navbar-fixed-top">
         <div class="container">
             <button class="navbar-toggler" data-toggle="collapse" data-target="#Navbar">
                 <span class="navbar-toggler-icon"></span>
             </button>
             <a href="/WellnessClinic/home" class="navbar-brand" style="font-size: 28px;">Medi Care</a>
             <div class="collapse navbar-collapse" id="Navbar">
                 <!-- <ul class="navbar-nav">
                     <li class="nav-item"><a href="/WellnessClinic/patientlist" class="nav-link">Patients</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/clerklist" class="nav-link">Clerks</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/doctorlist" class="nav-link">Doctors</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/appointmentlist" class="nav-link">Appointments</a></li>
                   	 <li class="nav-item"><a href="logout.jsp" class="nav-link">Logout</a></li>
                 </ul> -->
             </div>
         </div>
     </nav>
     
     <div class="reg-form" style="margin-top:30px;">
     	<form action="registerUser">
		  <div class="container">
		
		    <h3>User Registeration</h3>
		    <p>Please fill in this form to create an account.</p>
		    <hr>
		    <h4>Account Details:</h4>
		    
		    <table>
		    	<tr>
		    		<td><label for="firstName"><b>First Name</b></label></td>
		    		<td><input type="text" class="form-control" placeholder="Enter First Name" name="firstName" required></td>
		    	</tr>
		    	<tr>
		    		<td><label for="lastName"><b>Last Name</b></label></td>
		    		<td><input type="text" class="form-control" placeholder="Enter Last Name" name="lastName" required></td>
		    	</tr>
		    	<tr>
		    		<td><label for="email"><b>Email</b></label></td>
		    		<td><input type="text" class="form-control" placeholder="Enter Email" name="email" required></td>
		    	</tr>
		    	<tr>
		    		<td><label for="pwd"><b>Password</b></label></td>
		    		<td><input type="password" class="form-control" placeholder="Enter Password" name="pwd" required></td>
		    	</tr>
		    	<tr>
		    		<td><label for="pwd-repeat"><b>Repeat Password</b></label></td>
		    		<td><input type="password" class="form-control" placeholder="Repeat Password" name="pwd-repeat" required></td>
		    	</tr>
		    </table>
		    <hr>
		    
			<h4>Role</h4>
			
			<table>
				<tr>
					<td>
						<label class="container">Doctor
						  <input type="radio" checked="checked" name="roleId"  value="2">
						  <span class="checkmark"></span>
						</label>
					</td>
					<td>
						<label class="container">Clerk
						  <input type="radio" name="roleId" value="3">
						  <span class="checkmark"></span>
						</label>
					</td>
<!-- 					<td>
						<label class="container">Patient
						  <input type="radio" name="roleId" value="4">
						  <span class="checkmark"></span>
						</label>
					</td> -->
				</tr>
			</table>
		    
		    <hr>
		    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
		
		    <button type="submit" class="registerbtn">Register</button>
		  </div>
		  
		  <div class="container signin">
		    <p>Already have an account? <a href="/WellnessClinic/login">Sign in</a>.</p>
		  </div>
		</form>
     </div>


</script>
</html>