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
             <a href="/WellnessClinic/AdminHomePage.jsp" class="navbar-brand" style="font-size: 28px;">Wellness Clinic</a>
             <div class="collapse navbar-collapse" id="Navbar">
                 <ul class="navbar-nav">
                     <li class="nav-item"><a href="/WellnessClinic/patientlist" class="nav-link">Patients</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/appointmentlist" class="nav-link">Appointments</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/doctorlist" class="nav-link">Doctors</a></li>
                     <li class="nav-item"><a href="/WellnessClinic/addAppointment" class="nav-link">Add Appointment</a></li>
                   	 <li class="nav-item"><a href="logout.jsp" class="nav-link">Logout</a></li>
                 </ul>
             </div>
         </div>
     </nav>
     
     
    <div align="center">
        <c:if test="${appointment != null}">
            <form action="updateAppointment" method="post">
        </c:if>
        <c:if test="${appointment == null}">
            <form action="insertAppointment" method="post">
        </c:if>
        
        <h2>
             <c:if test="${appointment != null}">
                 Edit Appointment
             </c:if>
             <c:if test="${appointment == null}">
                 Add New Appointment
             </c:if>
         </h2>
        <table border="1" cellpadding="5" class="table table-bordered">
            <c:if test="${appointment != null}">
                <input type="hidden" name="appointment_Id" value="<c:out value='${appointment.appointment_Id}' />" />
            </c:if> 
            <tr>
                <th>Appointment Id: </th>
                <td>
                    <input type="hidden" name="appointment_Id" size="45"
                            value="<c:out value='${appointment.appointment_Id}' />"
                        />
                </td>
            </tr>          
            <tr>
                <th>Appointment Date: </th>
                <td>
                    <input type="text" name="appointment_date" size="45" placeholder = "yyyy-mm-dd" id="apt-date"
                            value="<c:out value='${appointment.getappointment_date()}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Slot: </th>
                <td>
                    <%-- <input type="text" name="slot_Id" size="45"
                            value="<c:out value='${appointment.slot_Id}' />"
                    /> --%>
                    <select name="slot_Id" id="slot_Id" value="<c:out value='${appointment.slot_Id}' />">
                    	<option value="0"></option>
                    	<option value="1"> 9:00 - 9:15 am</option>
						<option value="2"> 9:15 - 9:30 am</option>
						<option value="3"> 9:45 - 10:00 am</option>
						<option value="4">10:00 - 10:15 am</option>
						<option value="5">10:15 - 10:30 am</option>
						<option value="6">10:30 - 10:45 am</option>
						<option value="7">10:45 - 11:00 am</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Patient: </th>
                <td>
                    <%-- <input type="text" name="patientId" size="45"
                            value="<c:out value='${appointment.patientId}' />" --%>
                            
                     <select name="patientId" id="patientId" value ="<c:out value= '${appointment.patientId}' />">
                     <option>SELECT</option>
                     <option value="1">Prajakta Iyer</option>
					 <option value="3">Kewal</option>
					 <option value="5">Sowmya</option>
					 <option value="7">Karan</option>
                     </select>  
                </td>
            </tr>
            <tr>
                <th>Doctor: </th>
                <td>
                    <%-- <input type="text" name="doctor_Id" size="45" id="doctor-id"
                            value="<c:out value='${appointment.doctor_Id}' />"
                    /> --%>
                    <select name="doctor_Id" id="doctor-id" value="<c:out value='${appointment.doctor_Id}' />">
                    	<option>SELECT</option>
                    	<option value="1">Ajith Nair</option>
						<option value="2">John Jacob</option>
						<option value="3">Anthony</option>
						<option value="4">Julia</option>
						<option value="5">Mary John</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Availability: </th>
                <td>
                    <input type="text" name="avail_status" size="45"
                            value="<c:out value='${appointment.getavail_status()}' />"
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
/* $aptdate = $('#apt-date');
$doctorId = $('#doctor-id').val()

$aptdate.change (
    function() {
        $.ajax({
            type: "GET",
            url: "getSlots",
            data: {date: $aptdate.val(), doctor_id : $doctorId },
            success: function(data){
                $("#slot_id").append(data)
            }
        });
    }
); */
</script>