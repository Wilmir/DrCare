package com.ait.drcare.managedbeans.backing.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.ait.drcare.managedbeans.backing.UserLoginBean;


public class UserLoginBeanTest {
	
	private UserLoginBean user= new UserLoginBean();
	
	
	  @Before 
	  public void setUp() {
		  
		  user.setEmail("user@ait.ie"); 
		  user.setPassword("password"); 
		  
	  }
	 
	  @Test
	  public void testGetters() {
	  assertEquals("user@ait.ie",user.getEmail());
	  assertEquals("password",user.getPassword()); 
	  }
	 
	
}
