package com.ait.drcare.model;

import java.util.ArrayList;

public class Pharmacist extends User{

	public Pharmacist()
	{
		this.role = "Pharmacist";
	}
	
	public Pharmacist(String name, int ID, String password,
						String email,String address){
		//Send to parent class constructor
		super(name, ID, password, email,address,"Pharmacist");
	}

	
}
