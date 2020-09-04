package com.ait.drcare.model;

import com.sun.org.apache.xml.internal.security.signature.reference.ReferenceData;

public class User
{
	protected String theName;
	protected int theID;
	protected String thePassword;
	protected String theEmail;
	protected String theAddress;
	protected String role;
	protected boolean accountLock = false;
	boolean canEdit;
	protected int failedAttempts = 0;
	
	public User()
	{
		
	}
	
	public User(String name, int ID, String password,String email,String address, String role)
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

	public int getTheID() {
		return theID;
	}

	public void setTheID(int theID) {
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


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getAccountLock() {
		return accountLock;
	}

	public void setAccountLock(boolean lock) {
		this.accountLock = lock;
	}
	
	public int getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts() {
		this.failedAttempts++;
	}

	public void resetFailedAttempts() {
		failedAttempts=0;
	}

	
	@Override
	public String toString() {
		return "User [theName=" + theName + ", theID=" + theID + ", thePassword=" + thePassword + ", theEmail="
				+ theEmail + ", theAddress=" + theAddress + ", role=" + role + "]";
		
	}
	public boolean isCanEdit() {
		return canEdit;
	}
	
	public void setCanEdit(boolean canEdit) {
		this.canEdit= canEdit;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
	      return false;
	    if (!(obj instanceof User))
	      return false;
	    else
	      return true;
	}
	
	
}
