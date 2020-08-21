package com.ait.drcare.managedbeans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import com.ait.drcare.Doctor;
import com.ait.drcare.Patient;
import com.ait.drcare.Pharmacist;
import com.ait.drcare.User;

@ManagedBean
@SessionScoped
public class UserListBean {
	private ArrayList<User> users;
	
	@PostConstruct
	public void init() {
		//predefined user list
		users = new ArrayList<User>();
		Doctor d1 = new Doctor("Alan Care", "1234", "passw0rd", "alan@drcare.ie", "08913486", "Athlone, Co. Westmeath");
		users.add(d1);
		Pharmacist ph1 = new Pharmacist("Mary Bloggs", "2345", "password123", "mary@totalhealth.ie", "Athlone, Co. Westmeath");
		users.add(ph1);
		ArrayList<String> allergies = new ArrayList<String>();
		allergies.add("Penicillin");
		allergies.add("Aspirin");
		Patient p1 = new Patient("John Doe", "3456", "password234", "johndoe@gmail.com", allergies, "18734F", "Athlone, Co. Westmeath");
		users.add(p1);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		users.add(user);
	}

}
