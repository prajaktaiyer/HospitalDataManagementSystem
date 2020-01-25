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

public class DoctorDAO {
	
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public DoctorDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean insertDoctor(Doctor newDoctor) throws SQLException {
        String sql = "INSERT into Doctor(doctor_name,doctor_email,specialisation,weekly_off,userId,Reg_Number) VALUES (?,?,?,?,?,?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, newDoctor.getdoctor_name());
        statement.setString(2, newDoctor.getdoctor_email());
        statement.setString(3, newDoctor.getspecialisation());
        statement.setString(4, newDoctor.getweekly_off());
        statement.setInt(5, newDoctor.getuserId());
        statement.setInt(6, newDoctor.getReg_Number());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    //fetch records of all doctors from database
    public List<Doctor> listAllDoctors() throws SQLException {
        List<Doctor> listDoctor = new ArrayList<>();
         
        //Query to fetch all doctors
        String sql = "SELECT * FROM Doctor";
         
        //establishing connection
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        //Iterate through resultset and create Doctor Objects and add it to list
        while (resultSet.next()) {

            int doctor_Id = resultSet.getInt("doctor_Id");
            String doctor_name = resultSet.getString("doctor_name");
            String doctor_email = resultSet.getString("doctor_email");
            String specialisation = resultSet.getString("specialisation");
            String weekly_off = resultSet.getString("weekly_off");
            int userId = resultSet.getInt("userId");
            int Reg_Number = resultSet.getInt("Reg_Number");
             
            Doctor doctor = new Doctor(doctor_Id, doctor_name ,doctor_email, specialisation, weekly_off, userId,  Reg_Number);
            listDoctor.add(doctor);
        }
        
        resultSet.close();
        statement.close();
         
        //Close connection
        disconnect();
         
        return listDoctor;
    } 
    
  //Update records in database
    public boolean updateDoctor(Doctor doctor) throws SQLException {
        String sql = "UPDATE Doctor SET doctor_name = ?,doctor_email = ?, specialisation = ?,weekly_off = ?";
        sql += " WHERE doctor_Id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, doctor.getdoctor_name());
        statement.setString(2, doctor.getdoctor_email());
        statement.setString(3, doctor.getspecialisation());
        statement.setString(4, doctor.getweekly_off());
        statement.setInt(5, doctor.getdoctor_Id());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Doctor getDoctor(int doctor_Id) throws SQLException {
    	Doctor doctor = null;
        String sql = "SELECT * FROM Doctor WHERE doctor_Id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, doctor_Id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	int doctorId = resultSet.getInt("doctor_Id");
        	String doctor_email = resultSet.getString("doctor_email");
            String doctor_name = resultSet.getString("doctor_name");
            String specialisation = resultSet.getString("specialisation");
            String weekly_off = resultSet.getString("weekly_off");
            int userId = resultSet.getInt("userId");
            int Reg_Number = resultSet.getInt("Reg_Number");


             
             doctor = new Doctor( doctorId,doctor_name,doctor_email, specialisation,weekly_off,userId,Reg_Number);
        }
         
        resultSet.close();
        statement.close();
         
        return doctor;
    }
     
    
  //Delete doctor from database
    public boolean deleteDoctor(Doctor doctor) throws SQLException {
        String sql = "DELETE FROM Doctor where doctor_Id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, doctor.getdoctor_Id());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }

}
