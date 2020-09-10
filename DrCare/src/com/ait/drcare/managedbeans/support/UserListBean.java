package com.ait.drcare.managedbeans.support;


import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Medicine;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.PrescriptionItem;
import com.ait.drcare.model.User;


@ManagedBean
@SessionScoped
public class UserListBean {
	
	private ArrayList<User> users;
	
	private ArrayList<Integer> qualifiedDoctorsLicenses;
	
	private ArrayList<Integer> qualifiedPharmacistsLicenses;
	
	private ArrayList<Patient> patients;
	
	private ArrayList<Pharmacist> pharmacists;

	
	private ArrayList<Prescription> prescriptions;
	

	@PostConstruct
	public void init() {
		//Instantiate Variables
		users = new ArrayList<User>();
		qualifiedDoctorsLicenses = new ArrayList<>();
		qualifiedPharmacistsLicenses = new ArrayList<>();
		patients= new ArrayList<Patient>();
		pharmacists = new ArrayList<Pharmacist>();
		prescriptions =  new ArrayList<Prescription>();
		
		// Doctors
		Doctor d1 = new Doctor("Alan Care", 1234, "passw0rd", "alan@drcare.ie", "08913486", "Athlone, Co. Westmeath");
		Doctor doco = new Doctor("Doc",5050,"Doc","Doc","087696969","Doc,Doc,doc");
		users.add(d1);
		users.add(doco);
		
		// Allergies
		ArrayList<String> allergies = new ArrayList<String>();
		allergies.add("Penicillin");
		allergies.add("Aspirin");

		// Patients
		Patient p1 = new Patient("John Doe", 3456, "password234", "johndoe@gmail.com", allergies, "18734F", "Athlone, Co. Westmeath");
		Patient p2 = new Patient("Patient A", 3535, "A", "A",allergies,"A","A,A,A");
		Patient p3 = new Patient("Patient B", 3536, "A", "pB",allergies,"343","A,A,A");
		Patient p4 = new Patient("Patient C", 3537, "A", "pC",allergies,"A3413","A,A,A");
		Patient p5 = new Patient("Patient D", 3538, "A", "pD",allergies,"A999","A,A,A");
		Patient p6 = new Patient("Patient E", 3539, "A", "pE",allergies,"Aw42","A,A,A");
		Patient p7 = new Patient("Patient F", 3352, "A", "pF",allergies,"Beans","A,A,A");
		Patient p8 = new Patient("Patient G", 3535, "A", "pG",allergies,"BEANSBEANS","A,A,A");
		users.add(p1);
		users.add(p2);	
		users.add(p3);
		users.add(p4);
		users.add(p5);
		users.add(p6);
		users.add(p7);
		users.add(p8);
		

		// Pharmacist
		Pharmacist ph1 = new Pharmacist("Mary Bloggs", 2345, "password123", "mary@totalhealth.ie", "Athlone, Co. Westmeath");
		Pharmacist ph2 = new Pharmacist("Pharmacist B", 6969,"B", "B","B,B,B");
		Pharmacist ph3 = new Pharmacist("Pharm Acist", 2345, "password123", "pharm@totalhealth.ie", "Athlone, Co. Westmeath");
		Pharmacist ph4 = new Pharmacist("Joseph Bloggs", 2345, "password123", "Jose[h@totalhealth.ie", "Athlone, Co. Westmeath");
		Pharmacist ph5 = new Pharmacist("Sunny Bloggs", 2345, "password123", "Sunny@totalhealth.ie", "Athlone, Co. Westmeath");
		users.add(ph1);
		users.add(ph2);
		users.add(ph3);
		users.add(ph4);
		users.add(ph5);
		
		
		// Medicine
		Medicine med = new Medicine("Med Bean", 203);

		
		// Prescription Item
		PrescriptionItem pItem1 =  new PrescriptionItem(med, 0.25,4);
			pItem1.setSubtotal(20.0);


		//Prescriptions In Data
		Prescription prescription1 = new Prescription("Tommy 2 strings", new Date());		
			prescription1.setTheItem(pItem1);
			prescription1.setThePatient(p2);
			prescription1.setThePharmacist(ph2);
			prescription1.setTheStatus("Ready for pickup");
			prescriptions.add(prescription1);
			ph2.AddOrder(prescription1);



		Prescription prescription2 = new Prescription("Beany 2 strings", new Date());
			prescription2.setTheItem(pItem1);
			prescription2.setThePatient(p1);
			prescription2.setThePharmacist(ph1);
			prescriptions.add(prescription2);
			ph1.AddOrder(prescription2);

		
		Prescription prescription3 = new Prescription("Beans McBeans", new Date());
			prescription3.setThePharmacist(ph2);
			ph2.AddOrder(prescription3);

		
		Prescription prescription4 = new Prescription("Tommy loves Beans", new Date());
			prescription4.setThePharmacist(ph2);
		
			
		Prescription prescription5 = new Prescription("Tommy 5 trings", new Date());
			prescription5.setThePharmacist(ph2);
		
			
		//add patients, and pharmacist to a separate arraylist
		for(User user: users) {
			if (user instanceof Patient) {
				patients.add((Patient) user);
			}else if(user instanceof Pharmacist) {
				pharmacists.add((Pharmacist) user);
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


	public ArrayList<Pharmacist> getPharmacists(){
		return pharmacists;
	}
	
	
	

	public ArrayList<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public void setPharmacists(ArrayList<Pharmacist> pharmacists) {
		this.pharmacists = pharmacists;
	}


	// getPrescriptions for a specific patient
	public ArrayList<Prescription> getPrescriptions(Patient patient){
		ArrayList<Prescription> prescriptionsForUser = new ArrayList<Prescription>();
		//Insert code to only display for x user
		for (Prescription prescription : prescriptions) {
			if (prescription.getThePatient().equals(patient)) {
				prescriptionsForUser.add(prescription);
			}
		}
		return prescriptionsForUser;
	}
	
	// Pharmacist
	public ArrayList<Prescription> getPrescriptions(Pharmacist pharmacist){
		ArrayList<Prescription> prescriptionsForUser = new ArrayList<Prescription>();
		//Insert code to only display for x user
		for (Prescription prescription : prescriptions) {
			if (prescription.getThePharmacist().equals(pharmacist)) {
				prescriptionsForUser.add(prescription);
			}
		}
		return prescriptionsForUser;
	}
	
	
	public void addPrescription(Prescription newPrescription) {
		
		prescriptions.add(newPrescription);
		
		PrintPrescriptions();
	}
	
	
	public void PrintPrescriptions() {
		System.out.println("UserListBean PrintPrescriptions");
		
		for (Prescription p : prescriptions) {
			System.out.println("Patient Email:"+p.getThePatient().getTheEmail());
			System.out.println("Pharmacist Email:"+p.getThePharmacist().getTheEmail());
			
		}
		System.out.println("Number of prescriptions " + prescriptions.size());
		
	}
}
