<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Medi Care</title>
    
    <!-- Links to Bootstrap CSS Javascript and CSS files -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	
</head>
<body>
    <!-- Navbar including links for inventory list and option to add patient -->
    
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark navbar-fixed-top">
         <div class="container">
             <button class="navbar-toggler" data-toggle="collapse" data-target="#Navbar">
                 <span class="navbar-toggler-icon"></span>
             </button>
             <a href="/WellnessClinic/home" class="navbar-brand" style="font-size: 28px;">Wellness Clinic</a>
             <div class="collapse navbar-collapse" id="Navbar">
                 <ul class="navbar-nav">
                     <li class="nav-item"><a href="/WellnessClinic/patientlist" class="nav-link">Patients</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/clerklist" class="nav-link">Clerks</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/doctorlist" class="nav-link">Doctors</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/addClerk" class="nav-link">Add New Clerk</a></li>
                   	 <li class="nav-item"><a href="logout.jsp" class="nav-link">Logout</a></li>
                 </ul>
             </div>
         </div>
     </nav>
     
     
    <div align="center">
        <c:if test="${clerk != null}">
            <form action="updateClerk" method="post">
        </c:if>
        <c:if test="${clerk == null}">
            <form action="insertClerk" method="post">
        </c:if>
        
        <h2>
             <c:if test="${clerk != null}">
                 Edit Clerk
             </c:if>
             <c:if test="${clerk == null}">
                 Add New Clerk
             </c:if>
         </h2>
        <table border="1" cellpadding="5" class="table table-bordered">
            <c:if test="${clerk != null}">
                <input type="hidden" name="Clerk_Id" value="<c:out value='${clerk.Clerk_Id}' />" />
            </c:if> 
            <tr>
                <th>Clerk Id: </th>
                <td>
                    <input type="text" name="Clerk_Id" size="45"
                            value="<c:out value='${clerk.Clerk_Id}' />"
                        />
                </td>
            </tr>          
            <tr>
                <th>Clerk Name: </th>
                <td>
                    <input type="text" name="Clerk_name" size="45"
                            value="<c:out value='${clerk.Clerk_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>User Id: </th>
                <td>
                    <input type="text" name="userId" size="45"
                            value="<c:out value='${clerk.userId}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save" class="btn btn-primary"/>
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>