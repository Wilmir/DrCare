package com.ait.drcare;


public class User
{
	private String theName;
	private String theID;
	private String thePassword;
	private String theEmail;
	private String theAddress;
	private String role;
	
	public User()
	{
		
	}
	
	public User(String role)
	{
		this.role = role;
	}
	
	
	public User(String name, String ID, String password,String email,String address, String role)
	{
		this.theName = name;
		this.theID = ID;
		this.thePassword = password;
		this.theEmail = email;
		this.theAddress = address;
		this.role = role;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public String getTheID() {
		return theID;
	}

	public void setTheID(String theID) {
		this.theID = theID;
	}

	public String getThePassword() {
		return thePassword;
	}

	public void setThePassword(String thePassword) {
		this.thePassword = thePassword;
	}

	public String getTheEmail() {
		return theEmail;
	}

	public void setTheEmail(String theEmail) {
		this.theEmail = theEmail;
	}
	
	public String getTheAddress() {
		return theAddress;
	}

	public void setTheAddress(String address) {
		this.theAddress = address;
	}
	
	
	
}
