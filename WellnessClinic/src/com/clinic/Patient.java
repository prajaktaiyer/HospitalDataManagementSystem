package com.clinic;

public class Patient {
	
	  private int patientId;
	  private String patientName;
	  private int age;
	  private String sex;
	  private double height; 
	  private double weight; 
	  private int userId;
	  
	  
	 
	  
	  public Patient( int patientId , String patientName , int age,
			  String sex,double height, double weight, int userId)
		{
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.userId = userId;

		}
	  
	  public Patient(  String patientName , int age,
			  String sex,double height, double weight, int userId)
		{
		this.patientName = patientName;
		this.age = age;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.userId = userId;

		}
	  
	  public Patient(  String patientName , int age,
			  String sex,double height, double weight)
		{
		this.patientName = patientName;
		this.age = age;
		this.sex = sex;
		this.height = height;
		this.weight = weight;

		}
	  
	  public Patient(int patientId)
		{
		this.patientId = patientId;
		}
	  
	  //Setters
	  public void setpatientId(int patientId) {
			this.patientId = patientId;
		}
		public void setpatientName(String patientName) {
			this.patientName = patientName;		
		}
		public void setage(int age) {
			this.age = age;
		}
		public void setsex(String sex) {
			this.sex = sex;
		}
		public void setheight(double height) {
			this.height = height;
		}
		public void setweight(double weight) {
			this.weight = weight;
		}
		public void setuserId(int userId) {
			this.userId = userId;
		}
		
		//Getters

		//Getters
	    public int getpatientId() {
	        return patientId;
	    }
	    public String getpatientName() {
	        return patientName;
	    }
	    public String getsex() {
	        return sex;
	    }
	    public int getage() {
	        return age;
	    }
	    public double getheight() {
	    	return height;
	    }
	    public double getweight() {
	    	return weight;
	    }
	    public int getuserId() {
	    	return userId;
	    }


}
