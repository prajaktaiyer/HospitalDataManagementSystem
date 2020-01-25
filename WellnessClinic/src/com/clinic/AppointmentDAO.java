package com.clinic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinic.User;
import com.clinic.Patient;

import com.clinic.Doctor;

public class AppointmentDAO {
	
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public AppointmentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    //Manage database connection
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    //disconnect connection after completing transaction
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
  //insert records into database table
    public boolean insertAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT into Appointment( appointment_date, slot_Id, patientId, doctor_Id, avail_status) VALUES (?,?,?,?,?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, appointment.getappointment_date());
        statement.setInt(2, appointment.getslot_Id());
        statement.setInt(3, appointment.getpatientId());
        statement.setInt(4, appointment.getdoctor_Id());
        statement.setString(5, "Booked");
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    //fetch records of all Appointments from database
    public List<Appointment> listAllAppointments() throws SQLException {
        List<Appointment> listAppointment = new ArrayList<>();
         
        //Query to fetch all Appointments
        String sql = "SELECT distinct(Appointment.appointment_Id),Appointment.appointment_date,Slot.timing,Patient.patientName,Doctor.doctor_name,Appointment.avail_status "
        		+ "FROM Appointment "
        		+ "inner join Slot on Appointment.slot_Id= Slot.slot_Id "
        		+ "inner join Patient on Appointment.patientId = Patient.patientId "
        		+ "inner join Doctor on Appointment.doctor_Id= Doctor.doctor_id order by appointment_Id ";
         
        //establishing connection
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        //Iterate through resultset and create Doctor Objects and add it to list
        while (resultSet.next()) {

            int appointment_Id = resultSet.getInt("appointment_Id");
            String appointment_date = resultSet.getString("appointment_date");
            String timing = resultSet.getString("timing");
            String patientName = resultSet.getString("patientName");
            String doctor_name = resultSet.getString("doctor_name");
            String avail_status = resultSet.getString("avail_status");
            
            Appointment appointment = new Appointment(appointment_Id, appointment_date , timing, patientName, doctor_name,  avail_status);
            listAppointment.add(appointment);
        }
        
        resultSet.close();
        statement.close();
         
        //Close connection
        disconnect();
         
        return listAppointment;
    } 
    
    
  //fetch records of all Appointments by doctor from database
    public List<Appointment> listAllAppointmentsByDoctor() throws SQLException {
        List<Appointment> listAppointment = new ArrayList<>();
         
        //Query to fetch all Appointments
        String sql = "SELECT distinct(Appointment.appointment_Id),Appointment.appointment_date,Slot.timing,Patient.patientName,Doctor.doctor_name,Appointment.avail_status "
        		+ "FROM Appointment "
        		+ "inner join Slot on Appointment.slot_Id= Slot.slot_Id " 
        		+ "inner join Patient on Appointment.patientId = Patient.patientId "
        		+ "inner join Doctor on Appointment.doctor_Id= Doctor.doctor_id "
        		+ "inner join users on users.email=Doctor.doctor_email "
        		+ "WHERE Doctor.doctor_Id=3 order by appointment_Id";
         
        //establishing connection
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        //Iterate through resultset and create Doctor Objects and add it to list
        while (resultSet.next()) {

            int appointment_Id = resultSet.getInt("appointment_Id");
            String appointment_date = resultSet.getString("appointment_date");
            String timing = resultSet.getString("timing");
            String patientName = resultSet.getString("patientName");
            String doctor_name = resultSet.getString("doctor_name");
            String avail_status = resultSet.getString("avail_status");
            
            Appointment appointment = new Appointment(appointment_Id, appointment_date , timing, patientName, doctor_name,  avail_status);
            listAppointment.add(appointment);
        }
        
        resultSet.close();
        statement.close();
         
        //Close connection
        disconnect();
         
        return listAppointment;
    } 
    
  //Update records in database
    public boolean updateAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE Appointment SET appointment_date = ?,slot_Id = ?, patientId= ?,doctor_Id= ?,avail_status = ?";
        sql += " WHERE appointment_Id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, appointment.getappointment_date());
        statement.setInt(2, appointment.getslot_Id());
        statement.setInt(3, appointment.getpatientId());
        statement.setInt(4, appointment.getdoctor_Id());
        statement.setString(5, appointment.getavail_status());
        statement.setInt(6, appointment.getappointment_Id());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Appointment getAppointment(int appointment_Id) throws SQLException {
    	Appointment appointment = null;
        String sql = "SELECT * FROM Appointment WHERE appointment_Id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, appointment_Id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	 int appointmentId = resultSet.getInt("appointment_Id");
             String appointment_date = resultSet.getString("appointment_date");
             int slot_Id = resultSet.getInt("slot_Id");
             int patientId = resultSet.getInt("patientId");
             int doctor_Id = resultSet.getInt("doctor_Id");
             String avail_status = resultSet.getString("avail_status");


             
             appointment = new Appointment(appointmentId, appointment_date , slot_Id, patientId, doctor_Id,  avail_status);
        }
         
        resultSet.close();
        statement.close();
         
        return appointment;
    }
     
    
  //Delete Appointment from database
    public boolean deleteAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE Appointment SET avail_status = ?";
         sql += " WHERE appointment_Id = ?";				
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, "Cancelled");
        statement.setInt(2, appointment.getappointment_Id());
        
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    
    public List<Slot> getPendingSLots(String date, int doctor_id) throws SQLException{
    	List<Slot> slots = new ArrayList<Slot>();
    	Slot slot;
        String sql = "SELECT slot_id, timing FROM Slot WHERE slot_id NOT IN (SELECT slot_id FROM Appointment WHERE appointment_date = ? AND doctor_Id = ?) ";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, date);
        statement.setInt(2, doctor_id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
             int slot_Id = resultSet.getInt("slot_Id");
             String timing = resultSet.getString("timing");

             slot = new Slot(slot_Id, timing);
             slots.add(slot);
        }
         
        resultSet.close();
        statement.close();
        return slots;
    }

}
