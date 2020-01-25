package com.clinic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clinic.*;

//Controller Class
//It manages routing of requests from the user and loads corresponding views
//Capture User Interactions and invokes corresponding methods and business logic

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDAO patientDAO;
	private UserDAO userDAO;
	private ClerkDAO clerkDAO;
	private DoctorDAO doctorDAO;
	private AppointmentDAO appointmentDAO;

	public void init() {

		// Setting up database connection based on values mentioned in the web.xml
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
		patientDAO = new PatientDAO(jdbcURL, jdbcUsername, jdbcPassword);
		clerkDAO = new ClerkDAO(jdbcURL, jdbcUsername, jdbcPassword);
		doctorDAO = new DoctorDAO(jdbcURL, jdbcUsername, jdbcPassword);
		appointmentDAO = new AppointmentDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// Managing POST requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// Managing GET Requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		// routing of requests
		try {
			switch (action) {
			
			case "/doctorlist":
				showDoctor(request, response);
				break;
			case "/patientlist":
				showPatient(request, response);
				break;
			case "/clerklist":
				showClerk(request, response);
				break;
			case "/appointmentlist":
				showAppointment(request, response);
				break;
			case "/addDoctor":
				addDoctor(request, response);
				break;
			case "/addPatient":
				addPatient(request, response);
				break;
			case "/addAppointment":
				addAppointment(request, response);
				break;
			case "/addClerk":
				addClerk(request, response);
				break;
			case "/insertDoctor":
				insertDoctor(request, response);
				break;
			case "/insertPatient":
				insertPatient(request, response);
				break;
			case "/insertClerk":
				insertClerk(request, response);
				break;
			case "/insertAppointment":
				insertAppointment(request, response);
				break;
			case "/updateDoctor":
				updateDoctor(request, response);
				break;
			case "/updatePatient":
				updatePatient(request, response);
				break;
			case "/updateClerk":
				updateClerk(request, response);
				break;
			case "/updateAppointment":
				updateAppointment(request, response);
				break;
			case "/deleteDoctor":
				deleteDoctor(request, response);
				break;
			case "/deletePatient":
				deletePatient(request, response);
				break;
			case "/deleteClerk":
				deleteClerk(request, response);
				break;
			case "/deleteAppointment":
				deleteAppointment(request, response);
				break;
			case "/editDoctor":
				showDoctorEditForm(request, response);
				break;
			case "/editPatient":
				showPatientEditForm(request, response);
				break;
			case "/editClerk":
				showClerkEditForm(request, response);
				break;
			case "/editAppointment":
				showAppointmentEditForm(request, response);
				break;
			case "/login":
				login(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/registerUser":
				insertUser(request, response);
				break;
			case "/getSlots":
				getAppointmentSlots(request,response);
				break;
			case "/doctorappointmentlist":
				getDoctorAppointmentList(request,response);
				break;
			default:
				showHome(request, response); // Default route to home page
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	// Patient List
	private void showPatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Patient> listpatient = patientDAO.listAllPatients();
		request.setAttribute("listpatient", listpatient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PatientList.jsp");
		dispatcher.forward(request, response);
	}

//doctorlist
	private void showDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Doctor> listdoctor = doctorDAO.listAllDoctors();
		request.setAttribute("listdoctor", listdoctor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorList.jsp");
		dispatcher.forward(request, response);
	}

	// clerklist
	private void showClerk(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Clerk> listclerk = clerkDAO.listAllClerks();
		request.setAttribute("listclerk", listclerk);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClerkList.jsp");
		dispatcher.forward(request, response);
	}

	// appointmentlist
	private void showAppointment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Appointment> listappointment = appointmentDAO.listAllAppointments();
		request.setAttribute("listappointment", listappointment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AppointmentList.jsp");
		dispatcher.forward(request, response);
	}
	
// appointmentlist
	private void getDoctorAppointmentList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Appointment> listappointment = appointmentDAO.listAllAppointmentsByDoctor();
		request.setAttribute("listappointment", listappointment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorAppointmentList.jsp");
		dispatcher.forward(request, response);
	}

	// Add new Doctor
	private void addDoctor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorForm.jsp");
		dispatcher.forward(request, response);
	}

	// Add new Patient
	private void addPatient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("PatientForm.jsp");
		dispatcher.forward(request, response);
	}

	// Add new Clerk
	private void addClerk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClerkForm.jsp");
		dispatcher.forward(request, response);
	}

	// Add new Appointment
	private void addAppointment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AppointmentForm.jsp");
		dispatcher.forward(request, response);
	}

	// Insert Doctor into database
	private void insertDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String doctor_name = request.getParameter("doctor_name");
		String doctor_email = request.getParameter("doctor_email");
		String specialisation = request.getParameter("specialisation");
		String weekly_off = request.getParameter("weekly_off");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int Reg_Number = Integer.parseInt(request.getParameter("Reg_Number"));

		Doctor newdoctor = new Doctor(doctor_name, doctor_email, specialisation, weekly_off, userId, Reg_Number);
		doctorDAO.insertDoctor(newdoctor);
		response.sendRedirect("doctorlist");
	}

	// Insert Patient into database
	private void insertPatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String patientName = request.getParameter("patientName");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		Double height = Double.parseDouble(request.getParameter("height"));
		Double weight = Double.parseDouble(request.getParameter("weight"));
		int userId = Integer.parseInt(request.getParameter("userId"));

		Patient newpatient = new Patient(patientName, age, sex, height, weight, userId);
		patientDAO.insertPatient(newpatient);
		response.sendRedirect("patientlist");
	}

	// Insert Clerk into database
	private void insertClerk(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String Clerk_name = request.getParameter("Clerk_name");
		int userId = Integer.parseInt(request.getParameter("userId"));

		Clerk newclerk = new Clerk(Clerk_name, userId);
		clerkDAO.insertClerk(newclerk);
		response.sendRedirect("clerklist");
	}

	// Insert Appointment into database
	private void insertAppointment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String appointment_date = request.getParameter("appointment_date");
		int slot_Id = Integer.parseInt(request.getParameter("slot_Id"));
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		int doctor_Id = Integer.parseInt(request.getParameter("doctor_Id"));
		String avail_status = request.getParameter("avail_status");
		
		System.out.println("Date: " + appointment_date + ", Slot: " + slot_Id + ", Patient: " + patientId + ", Doctor: " + doctor_Id + "Status: " + avail_status);

		Appointment newappointment = new Appointment(appointment_date, slot_Id, patientId, doctor_Id, avail_status);
		appointmentDAO.insertAppointment(newappointment);
		response.sendRedirect("appointmentlist");
	}

	// Update edited Doctors
	private void updateDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String doctor_name = request.getParameter("doctor_name");
		String doctor_email = request.getParameter("doctor_email");
		String specialisation = request.getParameter("specialisation");
		String weekly_off = request.getParameter("weekly_off");

		Doctor newDoctor = new Doctor(doctor_name, doctor_email, specialisation, weekly_off);
		doctorDAO.updateDoctor(newDoctor);
		response.sendRedirect("doctorlist");
	}

	// Update edited Patients
	private void updatePatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String patientName = request.getParameter("patientName");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		Double height = Double.parseDouble(request.getParameter("height"));
		Double weight = Double.parseDouble(request.getParameter("weight"));
		int patientId =  Integer.parseInt(request.getParameter("patientId"));

		Patient newPatient = new Patient(patientId,patientName, age, sex, height, weight, 0);
		patientDAO.updatePatient(newPatient);
		response.sendRedirect("patientlist");
	}

	// Update edited Clerks
	private void updateClerk(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String Clerk_name = request.getParameter("Clerk_name");

		Clerk newClerk = new Clerk(Clerk_name);
		clerkDAO.updateClerk(newClerk);
		response.sendRedirect("clerklist");
	}

	// Update edited Appointments
	private void updateAppointment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String appointment_date = request.getParameter("appointment_date");
		int slot_Id = Integer.parseInt(request.getParameter("slot_Id"));
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		int doctor_Id = Integer.parseInt(request.getParameter("doctor_Id"));
		String avail_status = request.getParameter("avail_status");
		int appointment_id = Integer.parseInt(request.getParameter("appointment_Id"));

		Appointment newAppointment = new Appointment(appointment_id, appointment_date, slot_Id, patientId, doctor_Id,
				avail_status);
		appointmentDAO.updateAppointment(newAppointment);
		response.sendRedirect("appointmentlist");
	}

	// Delete Doctors
	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int doctor_Id = Integer.parseInt(request.getParameter("doctor_Id"));

		Doctor doctor = new Doctor(doctor_Id);
		doctorDAO.deleteDoctor(doctor);
		response.sendRedirect("doctorlist");

	}

	// Delete Patients
	private void deletePatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int patientId = Integer.parseInt(request.getParameter("id"));

		Patient patient = new Patient(patientId);
		patientDAO.deletePatient(patient);
		response.sendRedirect("patientlist");

	}

	// Delete Clerks
	private void deleteClerk(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int Clerk_Id = Integer.parseInt(request.getParameter("id"));

		Clerk clerk = new Clerk(Clerk_Id);
		clerkDAO.deleteClerk(clerk);
		response.sendRedirect("clerklist");

	}

	// Delete Appointments
	private void deleteAppointment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int appointment_Id = Integer.parseInt(request.getParameter("id"));

		Appointment appointment = new Appointment(appointment_Id);
		appointmentDAO.deleteAppointment(appointment);
		response.sendRedirect("appointmentlist");

	}

	// Show form to edit selected Doctor
	private void showDoctorEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("doctor_Id"));
		Doctor existingdoctor = doctorDAO.getDoctor(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorForm.jsp");
		request.setAttribute("doctor", existingdoctor);
		dispatcher.forward(request, response);

	}

	// Show form to edit selected Patient
	private void showPatientEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Patient existingPatient = patientDAO.getPatient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PatientForm.jsp");
		request.setAttribute("patient", existingPatient);
		dispatcher.forward(request, response);

	}

	// Show form to edit selected Clerk
	private void showClerkEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("Clerk_Id"));
		Clerk existingClerk = clerkDAO.getClerk(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClerkForm.jsp");
		request.setAttribute("clerk", existingClerk);
		dispatcher.forward(request, response);

	}

	// Show form to edit selected Appointment
	private void showAppointmentEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Appointment existingAppointment = appointmentDAO.getAppointment(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AppointmentForm.jsp");
		request.setAttribute("appointment", existingAppointment);
		dispatcher.forward(request, response);

	}

	// Login based on user credentials entered
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");

		try {
			User user = userDAO.checkLogin(email, pwd);
			String destPage = "login.jsp";

			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				switch (user.getroleId()) {
				case 1:
					destPage = "AdminHomePage.jsp";
					break;
				case 2:
					destPage = "doctor.jsp";
					break;
				case 3:
					destPage = "clerk.jsp";
					break;

				}
			} else {
				String message = "Invalid email/password";
				request.setAttribute("message", message);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);

		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}

	// logout
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.removeAttribute("user");
			RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp");
			dispatcher.forward(request, response);
		}

	}

	// user Registration
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destPage = "RegistrationForm.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		dispatcher.forward(request, response);
	}

	// Show form to edit selected Clerk
	private void showHome(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");

		int roleId = Integer.parseInt(request.getParameter("roleId"));
		String userId = request.getParameter("userId");

		User newUser = new User(email, password, firstName, lastName, roleId, userId);
		userDAO.insertUser(newUser);
		response.sendRedirect("login");
	}
	
	private void getAppointmentSlots(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String date = request.getParameter("date");
		int doctor_id = Integer.parseInt(request.getParameter("doctor_id").toString());
		
		List<Slot> slots = appointmentDAO.getPendingSLots(date, doctor_id);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String output = "";
		
		for(Slot s : slots) {
			output += "<option value='"+ s.getslot_id() +"'>" + s.gettiming() +"</option>";
		}
		out.print(output);
	}

}
