package com.clinic;

public class Doctor {
	
	  private int doctor_Id;
	  private String doctor_name;
	  private String doctor_email;
	  private String specialisation;
	  private String weekly_off;
	  private int userId; 
	  private int Reg_Number;
	  
	  public Doctor() {};
	  
	  public Doctor ( String doctor_name, String email, String specialisation, String weekly_off ,int userId, int Reg_Number) 
		{
			this.doctor_name = doctor_name;
			this.doctor_email = email;
			this.specialisation = specialisation;
			this.weekly_off = weekly_off;
			this.userId = userId;
			this.Reg_Number = Reg_Number;
			}
	  
	  public Doctor ( String doctor_name, String email, String specialisation, String weekly_off ) 
		{
			this.doctor_name = doctor_name;
			this.doctor_email = email;
			this.specialisation = specialisation;
			this.weekly_off = weekly_off;
			}
	  
	  public Doctor (int doctor_Id, String doctor_name, String email, String specialisation, String weekly_off ,int userId, int Reg_Number) 
		{
		  	this.doctor_Id = doctor_Id;
		  	this.doctor_email = email;
			this.doctor_name = doctor_name;
			this.specialisation = specialisation;
			this.weekly_off = weekly_off;
			this.userId = userId;
			this.Reg_Number = Reg_Number;
			}
	  
	  public Doctor (int doctor_Id, String doctor_name, String email, String specialisation, String weekly_off ) 
		{
		  	this.doctor_Id = doctor_Id;
		  	this.doctor_email = email;
			this.doctor_name = doctor_name;
			this.specialisation = specialisation;
			this.weekly_off = weekly_off;
			}
	  
	  public Doctor (int doctor_Id) 
		{
		  	this.doctor_Id = doctor_Id;
			}
	  
	  //Setters
	  public void setdoctor_Id(int doctor_Id) {
			this.doctor_Id = doctor_Id;
		}
	  public void setdoctor_name(String doctor_name) {
			this.doctor_name = doctor_name;
		}
	  
	  public void setdoctor_email(String doctor_email) {
			this.doctor_email = doctor_email;
		}
	  public void setspecialisation(String specialisation) {
		  this.specialisation = specialisation;
		}
	  public void setweekly_off(String weekly_off) {
		  this.weekly_off = weekly_off;
		}
	  
	  public void setReg_Number(int Reg_Number) {
			this.Reg_Number = Reg_Number;
		}
	  public void setuserId(int userId) {
			this.userId = userId;
		}
	  
	  
	//Getters
	    public int getdoctor_Id() {
	        return doctor_Id;
	    }
	    
	    public String getdoctor_name() {
	        return doctor_name;
	    }
	    
	    public String getdoctor_email() {
	        return doctor_email;
	    }
	    public String getspecialisation() {
	        return specialisation;
	    }
	    
	    public String getweekly_off() {
	        return weekly_off;
	    }
	    public int getuserId() {
	        return userId;
	    }
	    
	    public int getReg_Number() {
	        return Reg_Number;
	    }
	    
	    
	  
	  
	 
}
