package com.clinic;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Appointment {
	
	private int appointment_Id;
	private String appointment_date;
	private int slot_Id;
	private int patientId;
	private int doctor_Id;
	private String avail_status;
	private String patientName;
	private String doctor_name;
	private String timing;
	
	
	public Appointment() {}
	
	public Appointment (int appointment_Id)
	{
		this.appointment_Id = appointment_Id;
	}
	
	public Appointment (int appointment_Id,String appointment_date,String  timing,String patientName,String doctor_name,String  avail_status)
	{
		this.appointment_Id = appointment_Id;
		this.appointment_date = appointment_date;
		this.timing = timing;
		this.patientName = patientName;
		this.doctor_name = doctor_name;
		this.avail_status = avail_status;
	}
	

	public Appointment (int appointment_Id,String appointment_date,int slot_Id,int patientId,int doctor_Id,String avail_status)
	{
		this.appointment_Id = appointment_Id;
		this.appointment_date = appointment_date;
		this.slot_Id = slot_Id;
		this.patientId = patientId;
		this.doctor_Id = doctor_Id;
		this.avail_status = avail_status;
	}
	
	public Appointment (String appointment_date,int slot_Id,int patientId,int doctor_Id,String avail_status)
	{
		this.appointment_date = appointment_date;
		this.slot_Id = slot_Id;
		this.patientId = patientId;
		this.doctor_Id = doctor_Id;
		this.avail_status = avail_status;
	}
	
	//setters
	public void settiming (String timing)
	{
		this.timing = timing;
	}
	public void setpatientName (String patientName)
	{
		this.patientName = patientName;
	}
	public void setdoctor_name (String doctor_name)
	{
		this.doctor_name = doctor_name;
	}
	public void setappointment_Id (int appointment_Id)
	{
		this.appointment_Id = appointment_Id;
	}
	public void setappointment_date (String appointment_date)
	{
		this.appointment_date = appointment_date;
	}
	
	public void setslot_Id (int slot_Id)
	{
		this.slot_Id = slot_Id;
	}
	public void setpatientId (int patientId)
	{
		this.patientId = patientId;
	}
	public void setdoctor_Id (int doctor_Id)
	{
		this.doctor_Id = doctor_Id;
	}
	public void setavail_status (String avail_status)
	{
		this.avail_status = avail_status;
	}

	
	//getters
	public int getappointment_Id()
	{
	 return appointment_Id;
	}
	
	public String getappointment_date() {
	    return appointment_date;
	}
	
	public int getslot_Id()
	{
	 return slot_Id;
	}
	public int getpatientId()
	{
	 return patientId;
	}
	public int getdoctor_Id()
	{
	 return doctor_Id;
	}
	public String getavail_status()
	{
	 return avail_status;
	}
	
	public String gettiming()
	{
		return timing;
	}
	public String getpatientName()
	{
		return patientName;
	}
	public String getdoctor_name()
	{
		return doctor_name;
	}
	
	
	
	
	
}
