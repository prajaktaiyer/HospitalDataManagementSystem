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
             <a href="/WellnessClinic/AdminHomePage.jsp" class="navbar-brand" style="font-size: 28px;">Medi Care</a>
             <div class="collapse navbar-collapse" id="Navbar">
                 <ul class="navbar-nav">
                     <li class="nav-item"><a href="/WellnessClinic/patientlist" class="nav-link">Patients</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/appointmentlist" class="nav-link">Appointments</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/doctorlist" class="nav-link">Doctors</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/addPatient" class="nav-link">Add New Patient</a></li>
                   	 <li class="nav-item"><a href="logout.jsp" class="nav-link">Logout</a></li>
                 </ul>
             </div>
         </div>
     </nav>
     
     
    <div align="center">
        <c:if test="${patient != null}">
            <form action="updatePatient" method="post">
        </c:if>
        <c:if test="${patient == null}">
            <form action="insertPatient" method="post">
        </c:if>
        
        <h2>
             <c:if test="${patient != null}">
                 Edit Patient
             </c:if>
             <c:if test="${patient == null}">
                 Add New Patient
             </c:if>
         </h2>
        <table border="1" cellpadding="5" class="table table-bordered">
            <c:if test="${patient != null}">
                <input type="hidden" name="patientId" value="<c:out value='${patient.patientId}' />" />
            </c:if> 
            <tr>
                <th>Patient Id: </th>
                <td>
                    <input type="hidden" name="patientId" size="45"
                            value="<c:out value='${patient.patientId}' />"
                        />
                </td>
            </tr>          
            <tr>
                <th>Patient Name: </th>
                <td>
                    <input type="text" name="patientName" size="45"
                            value="<c:out value='${patient.patientName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Age: </th>
                <td>
                    <input type="text" name="age" size="45"
                            value="<c:out value='${patient.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Sex: </th>
                <td>
                    <input type="text" name="sex" size="45"
                            value="<c:out value='${patient.sex}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Height: </th>
                <td>
                    <input type="text" name="height" size="45"
                            value="<c:out value='${patient.height}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Weight: </th>
                <td>
                    <input type="text" name="weight" size="45"
                            value="<c:out value='${patient.weight}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Id: </th>
                <td>
                    <input type="text" name="userId" size="45"
                            value="<c:out value='${patient.userId}' />"
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