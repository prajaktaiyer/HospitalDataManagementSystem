package com.clinic;

public class Slot {
	private int slot_id;
	private String timing;

	public int getslot_id() {
		return slot_id;
	}
	
	public String gettiming() {
		return timing;
	}
	
	public void setslot_id(int slot_id) {
		this.slot_id = slot_id; 
	}
	
	public void settiming(String timing) {
		this.timing = timing; 
	}
	
	public Slot(int slot_id, String timing) {
		this.slot_id = slot_id;
		this.timing = timing;
	}
}
