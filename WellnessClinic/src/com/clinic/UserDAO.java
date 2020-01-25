package com.clinic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public User insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (email,pwd,firstName,lastName,roleId,userId) VALUES (?,?, ?, ?, ?,?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getpwd());
        statement.setString(3, user.getFirstName());
        statement.setString(4, user.getFirstName());
        statement.setInt(5, user.getroleId());
        statement.setString(6, user.getuserId());

        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
       
        
        //return rowInserted;
        String new_user = "SELECT * FROM users WHERE email = ? and pwd = ?";
	    PreparedStatement statement1 = jdbcConnection.prepareStatement(new_user);
	    statement1.setString(1, user.getEmail());
	    statement1.setString(2,user.getpwd());
	    ResultSet resultSet = statement1.executeQuery();
	
	    if (resultSet.next()) {
	        user = new User();
	        user.setuserId(resultSet.getString("userId"));
	        user.setFirstName(resultSet.getString("firstName"));
	        user.setLastName(resultSet.getString("lastName"));
	        user.setEmail(resultSet.getString("email"));
	        user.setroleId(resultSet.getInt("roleId"));
	    }
	    resultSet.close();
        statement1.close();
        disconnect();
	    return user;
	    
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
	        user.setroleId(resultSet.getInt("roleId"));
	        user.setuserId(resultSet.getString("userId"));
	        user.setEmail(email);
	    }
	    resultSet.close();
        statement.close();
	    return user;
	}
       
        
    }
