package com.clinic;


//User Model Class
//Contains fields corresponding to the attributes of User entity in Database 
public class User {
  private String userId;
  private String email;
  private String pwd;
  private String firstName;
  private String lastName;
  private int roleId; 
  
  public User() {};
  
  public User(String email , String pwd , String firstName, String lastName, int roleId, String userId)
	{
	this.userId =userId;
	this.email = email;
	this.pwd = pwd;
	this.firstName = firstName;
	this.lastName = lastName;
	this.roleId = roleId;
	}
  
  //Setters
  public void setuserId(String userId) {
		this.userId = userId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;		
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;		
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setroleId(int roleId) {
		this.roleId = roleId;
	}
	
	//Getters
    public String getuserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getpwd() {
        return pwd;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    
    public int getroleId() {
        return roleId;
    }
}
