package com.clinic;

//Data Access Object
//Manages connection to database and Querying using SQL 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinic.User;



public class PatientDAO {
	
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public PatientDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean insertPatient(Patient newPatient) throws SQLException {
        String sql = "INSERT INTO Patient (patientName , age, sex, height, weight,userId) VALUES (?, ?, ?, ?, ?, ?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, newPatient.getpatientName());
        statement.setInt(2, newPatient.getage());
        statement.setString(3, newPatient.getsex());
        statement.setDouble(4, newPatient.getheight());
        statement.setDouble(5, newPatient.getweight());
        statement.setInt(6, newPatient.getuserId());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    
  //fetch records of all patients from database
    public List<Patient> listAllPatients() throws SQLException {
        List<Patient> listPatient = new ArrayList<>();
         
        //Query to fetch all patients
        String sql = "SELECT * FROM Patient";
         
        //establishing connection
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        //Iterate through resultset and create Doctor Objects and add it to list
        while (resultSet.next()) {

            int patientId = resultSet.getInt("patientId");
            String patientName = resultSet.getString("patientName");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            Double height = resultSet.getDouble("height");
            Double weight = resultSet.getDouble("weight");
            int userId = resultSet.getInt("userId");
            
            Patient patient = new Patient(patientId,patientName,age,sex,height,weight,userId);
            listPatient.add(patient);
        }
        
        resultSet.close();
        statement.close();
         
        //Close connection
        disconnect();
         
        return listPatient;
    } 
    
    
    
    
    //Update records in database
    public boolean updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE Patient SET patientName = ?,age = ?,sex = ?,height = ?,weight = ?";
        sql += " WHERE patientId = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, patient.getpatientName());
        statement.setInt(2, patient.getage());
        statement.setString(3, patient.getsex());
        statement.setDouble(4, patient.getheight());
        statement.setDouble(5, patient.getweight());
        statement.setInt(6, patient.getpatientId());
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Patient getPatient(int patientId) throws SQLException {
    	Patient patient = null;
        String sql = "SELECT * FROM Patient WHERE patientId = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, patientId);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	int patient_Id = resultSet.getInt("patientId");
            String patientName = resultSet.getString("patientName");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            Double height = resultSet.getDouble("height");
            Double weight = resultSet.getDouble("weight");
            int userId = resultSet.getInt("userId");


             
             patient = new Patient( patient_Id,patientName, age,sex ,height,weight,userId);
        }
         
        resultSet.close();
        statement.close();
         
        return patient;
    }
    
    //Delete patient from database
    public boolean deletePatient(Patient patient) throws SQLException {
        String sql = "DELETE FROM Patient where patientId = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong(1, patient.getpatientId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    
    public User checkLogin(String email, String pwd) throws SQLException,ClassNotFoundException {
    	
    	User user = null;
	    String sql = "SELECT * FROM users WHERE email = ? and pwd = ?";
	    
	    connect();
	    
	    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	    statement.setString(1, email);
	    statement.setString(2, pwd);
	
	    ResultSet resultSet = statement.executeQuery();
	
	    
	
	    if (resultSet.next()) {
	        user = new User();
	        user.setFirstName(resultSet.getString("firstName"));
	        user.setLastName(resultSet.getString("lastName"));
	        user.setEmail(email);
	        user.setuserId(resultSet.getString("userId"));


	    }
	    resultSet.close();
        statement.close();
	    return user;
	}

}
