package com.ait.drcare;

import java.util.ArrayList;

public class Pharmacist extends User{

	
	//Orders currently assigned to be dispensed here
	private ArrayList<Prescription> orders;

	
	
	public Pharmacist()
	{
		this.role = "Pharmacist";
	}
	
	public Pharmacist(String name, String ID, String password,
						String email,String address){
		//Send to parent class constructor
		super(name, ID, password, email,address,"Pharmacist");
		
	}

	public ArrayList<Prescription> getOrders() {
		return orders;
	}

	public void AddOrder(Prescription order){
		
	}

	public void UpdateOrder() {
		
	}
	
	public void DispenseOrder() {
		
	}

	public void setOrders(ArrayList<Prescription> orders) {
		this.orders = orders;
	}
	
	
}
