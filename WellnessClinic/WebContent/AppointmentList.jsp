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
		#patientTable{
			margin-top: 25px;
		}
		.underflow{
			background-color: #F08080;
		}
	</style>
</head>
<body>

    <!-- Navbar including links for Clerk list and option to add Clerk -->
    
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
                     <li class="nav-item"><a href="/WellnessClinic/addAppointment" class="nav-link">Add Appointment</a></li>
                   	 <li class="nav-item"><a href="logout.jsp" class="nav-link">Logout</a></li>
                 </ul>
             </div>
         </div>
     </nav>
	
	
    <div align="center">
        <table border="1" cellpadding="5" id="appointmentTable" class="table table-bordered">
            <%-- <caption><h2>WellnessClinic</h2></caption> --%>
            <tr>
            	<th>
            		Search
            	</th>
            	<th>
            		<input type="text" id="searchText" onkeyup="searchAppointment()" placeholder="Search">
            	</th>
            	<th colspan="9">
            		<select name="searchBy" id="searchBy">
            			<option value="5" selected="selected">Availability</option>
            		</select>
            	</th>
            </tr>
            <tr>
                <th>Appointment ID</th>
                <th>Appointment Date</th>
                <th>Slot</th>
                <th>Patient</th>
                <th>Doctor</th>
                <th>Availability</th>
            </tr>
            <c:forEach var="appointment" items="${listappointment}">
                <tr>
                    <td><c:out value="${appointment.getappointment_Id()}" /></td>
                    <td><c:out value="${appointment.getappointment_date()}" /></td>
                    <td><c:out value="${appointment.gettiming()}" /></td>
                    <td><c:out value="${appointment.getpatientName()}" /></td>
                    <td><c:out value="${appointment.getdoctor_name()}" /></td>
                    <td><c:out value="${appointment.getavail_status()}" /></td>
                    <td>
                        <a href="/WellnessClinic/editAppointment?id=<c:out value='${appointment.getappointment_Id()}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/WellnessClinic/deleteAppointment?id=<c:out value='${appointment.getappointment_Id()}' />">Cancel</a>                     
                    </td>
                </tr>
            </c:forEach>
            
        </table>
        
        
    </div>
    <!-- Footer -->
	  <footer class="page-footer font-small blue">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2019 Copyright:
          <a> The Three Musketeers</a>
        </div>
        <!-- Copyright -->
      
      </footer>
      <!-- Footer -->   
</body>
<script>

/* JavaScript function to search records in the table based on the search parameter selected */
function searchAppointment() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue, searcBy, searchIndex;
  input = document.getElementById("searchText");
  filter = input.value.toUpperCase();
  table = document.getElementById("appointmentTable");
  tr = table.getElementsByTagName("tr");
  var e = document.getElementById("searchBy");
  searcBy = e.options[e.selectedIndex].value;
  
  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[searcBy];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

</script>
</html>