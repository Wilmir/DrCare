package com.ait.drcare;

import java.util.ArrayList;

public class Pharmacist extends User{

	private ArrayList<Prescription> orders;

	
	
	public Pharmacist()
	{
		
	}
	
	public Pharmacist(String name, String ID, String password,
						String email,String address){
		
		super(name, ID, password, email,address);
		
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
	
	
}
