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
import com.clinic.Clerk;
public class ClerkDAO {
	
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ClerkDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean insertClerk(Clerk clerk) throws SQLException {
        String sql = "INSERT into Clerk (Clerk_name,userId) VALUES (?,?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        statement.setString(1, clerk.getClerk_name());
        statement.setInt(2, clerk.getuserId());

        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    //fetch records of all doctors from database
    public List<Clerk> listAllClerks() throws SQLException {
        List<Clerk> listClerk = new ArrayList<>();
         
        //Query to fetch all products
        String sql = "SELECT * FROM Clerk";
         
        //establishing connection
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        //Iterate through resultset and create Doctor Objects and add it to list
        while (resultSet.next()) {

            int Clerk_Id = resultSet.getInt("Clerk_Id");
            String Clerk_name = resultSet.getString("Clerk_name");
            int userId = resultSet.getInt("userId");
             
            Clerk clerk = new Clerk(Clerk_Id,Clerk_name,userId);
            listClerk.add(clerk);
        }
        
        resultSet.close();
        statement.close();
         
        //Close connection
        disconnect();
         
        return listClerk;
    } 
    
  //Update records in database
    public boolean updateClerk(Clerk clerk) throws SQLException {
        String sql = "UPDATE Clerk SET Clerk_name = ?";
        sql += " WHERE Clerk_Id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, clerk.getClerk_name());

         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Clerk getClerk(int Clerk_Id) throws SQLException {
    	Clerk clerk = null;
        String sql = "SELECT * FROM Clerk WHERE Clerk_Id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, Clerk_Id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	int ClerkId = resultSet.getInt("Clerk_Id");
            String Clerk_name = resultSet.getString("Clerk_name");
            int userId = resultSet.getInt("userId");


             
             clerk = new Clerk( ClerkId,Clerk_name,userId);
        }
         
        resultSet.close();
        statement.close();
         
        return clerk;
    }
     
    
  //Delete doctor from database
    public boolean deleteClerk(Clerk clerk) throws SQLException {
        String sql = "DELETE FROM Clerk where Clerk_Id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, clerk.getClerk_Id());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }

}
