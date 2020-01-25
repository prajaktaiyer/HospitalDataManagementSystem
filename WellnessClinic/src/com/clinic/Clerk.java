package com.clinic;

public class Clerk {
	
	private int Clerk_Id;
	private String Clerk_name;
	private int userId;
	
	
	public Clerk() {}
	

	public Clerk (int Clerk_Id,String Clerk_name,int userId)
	{
		this.Clerk_Id = Clerk_Id;
		this.Clerk_name = Clerk_name;
		this.userId = userId;
	}
	
	public Clerk (String Clerk_name,int userId)
	{

		this.Clerk_name = Clerk_name;
		this.userId = userId;
	}
	
	public Clerk (String Clerk_name)
	{

		this.Clerk_name = Clerk_name;
	}
	

	public Clerk (int  Clerk_Id)
	{

		this.Clerk_Id = Clerk_Id;
	}
	
	
	//setters
	
	

	public void setClerk_Id (int Clerk_Id)
	{
		this.Clerk_Id = Clerk_Id;
	}
	public void setClerk_name (String Clerk_name)
	{
		this.Clerk_name = Clerk_name;
	}
	
	public void setuserId (int userId)
	{
		this.userId = userId;
	}

	
	//getters
	
	public int getClerk_Id()
	{
	 return Clerk_Id;
	}
	
	public String getClerk_name()
	{
		return Clerk_name;
	}
	
	public int getuserId()
	{
	 return userId;
	}
	
	
	
}
