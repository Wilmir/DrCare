package com.ait.drcare.managedbeans.backing.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.User;

public class UserListBeanTest {
	
	private ArrayList<User> users;
	private UserListBean userList;
	private ArrayList<Patient> patients= new ArrayList<>(); 
	
	@Before
	public void setUp() {
		userList =new UserListBean();
		users=new ArrayList<>();
		
	}

	@Test
	public void testUsersList() {
		Doctor d1 = new Doctor("Alan Care", 1234, "passw0rd", "alan@drcare.ie", "08913486", "Athlone, Co. Westmeath");
		users.add(d1);
		Pharmacist ph1 = new Pharmacist("Mary Bloggs", 2345, "password123", "mary@totalhealth.ie", "Athlone, Co. Westmeath");
		users.add(ph1);
		ArrayList<String> allergies = new ArrayList<String>();
		//allergies.add("Penicillin");
		//allergies.add("Aspirin");
		Patient p1 = new Patient("John Doe", 3456, "password234", "johndoe@gmail.com", allergies, "18734F", "Athlone, Co. Westmeath");
		users.add(p1);
		userList.setUsers(users);
		assertEquals(users,userList.getUsers());
		
	}
	
	@Test
	public void testPatientsList() {
		
		ArrayList<String> allergies = new ArrayList<String>();
		Patient p1 = new Patient("John Doe", 3456, "password234", "johndoe@gmail.com", allergies, "18734F", "Athlone, Co. Westmeath");
		Patient p2 = new Patient("Ross", 3678, "password234", "ros@gmail.com", allergies, "18734F", "Athlone, Co. Westmeath");
	    patients.add(p1);
		patients.add(p2);
	    userList.setPatients(patients);
	    assertEquals(patients,userList.getPatients());
		
	}
	
	@Test
	public void testAddUser() {
		
		userList.setUsers(users);
		Doctor d1 = new Doctor("Alan Care", 1234, "passw0rd", "alan@drcare.ie", "08913486", "Athlone, Co. Westmeath");
		userList.addUser(d1);
		users.add(d1);
		assertEquals(users,userList.getUsers());
		
	}

}
