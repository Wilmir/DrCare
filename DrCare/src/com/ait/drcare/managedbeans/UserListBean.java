package com.ait.drcare.managedbeans;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.User;


@ManagedBean
@SessionScoped
public class UserListBean {
	private ArrayList<User> users;
	
	private ArrayList<Integer> qualifiedDoctorsLicenses;
	
	private ArrayList<Integer> qualifiedPharmacistsLicenses;
	
	private ArrayList<Patient> patients;


	

	@PostConstruct
	public void init() {
		//predefined user list
		users = new ArrayList<User>();
		qualifiedDoctorsLicenses = new ArrayList<>();
		qualifiedPharmacistsLicenses = new ArrayList<>();
		patients= new ArrayList<Patient>();
		
		Doctor d1 = new Doctor("Alan Care", 1234, "passw0rd", "alan@drcare.ie", "08913486", "Athlone, Co. Westmeath");
		users.add(d1);
		Pharmacist ph1 = new Pharmacist("Mary Bloggs", 2345, "password123", "mary@totalhealth.ie", "Athlone, Co. Westmeath");
		users.add(ph1);
		ArrayList<String> allergies = new ArrayList<String>();
		allergies.add("Penicillin");
		allergies.add("Aspirin");
		Patient p1 = new Patient("John Doe", 3456, "password234", "johndoe@gmail.com", allergies, "18734F", "Athlone, Co. Westmeath");
		users.add(p1);
		//patients.add(p1);
		
		//Quick test users
		Patient p2 = new Patient("Patient A", 3535, "A", "A",allergies,"A","A,A,A");
		Pharmacist ph2 = new Pharmacist("Pharmacist B", 6969,"B", "B","B,B,B");
		Doctor doco = new Doctor("Doc",5050,"Doc","Doc","087696969","Doc,Doc,doc");
		users.add(p2);		
		users.add(ph2);
		users.add(doco);
		//patients.add(p2);
		
		//add patients to a separate arraylist
		for(int counter=0; counter<users.size(); counter++) {
			if (users.get(counter) instanceof Patient) {
				patients.add((Patient) users.get(counter));
			}
		}
		
		// valid doctors licenses range from 300000000 - 300090000
		for(int i=300000000; i<=300090000; i++) {
			qualifiedDoctorsLicenses.add(i);
		}
		
		// valid pharmacist licenses range from 600000000 - 600090000
		for(int i=600000000; i<=60009000; i++) {
			qualifiedPharmacistsLicenses.add(i);
		}
		
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public ArrayList<Integer> getQualifiedDoctorsLicenses() {
		return qualifiedDoctorsLicenses;
	}

	public ArrayList<Integer> getQualifiedPharmacistsLicenses() {
		return qualifiedPharmacistsLicenses;
	}

	public void addUser(User user) {
		users.add(user);
	}
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	public String editPatient(Patient patient) {
		patient.setCanEdit(true);
		return null;
	}
}
