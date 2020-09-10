package com.ait.drcare.managedbeans.support;


import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.drcare.helpers.Helper;
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
	
	private MedicineListBean medicineStore;
	

	@PostConstruct
	public void init() {
		medicineStore = Helper.getBean("medicineListBean", MedicineListBean.class);
	
		//Instantiate Variables
		users = new ArrayList<User>();
		qualifiedDoctorsLicenses = new ArrayList<>();
		qualifiedPharmacistsLicenses = new ArrayList<>();
		patients= new ArrayList<Patient>();
		pharmacists = new ArrayList<Pharmacist>();
		prescriptions =  new ArrayList<Prescription>();
		
		// Doctors
		Doctor d1 = new Doctor("Alan Care", 65467890, "passw0rd", "alan@drcare.ie", "08913486", "Athlone, Co. Westmeath");
		Doctor d2 = new Doctor("Luke Meyer",64448901,"Doc","Doc","087696969","Athlone, Co. Westmeath");
		users.add(d1);
		users.add(d2);
		
		// Allergies
		ArrayList<String> allergies = new ArrayList<String>();
		allergies.add("Penicillin");
		allergies.add("Aspirin");

		// Patients
		Patient p1 = new Patient("John Doe", 3456, "password234", "johndoe@gmail.com", allergies, "18734F", "Athlone, Co. Westmeath");
		Patient p2 = new Patient("Daniel Nelms", 3535, "A", "A",allergies,"A","Grand Canal Dock, Dublin");
		Patient p3 = new Patient("Lingfei Fan", 3536, "A", "pB",allergies,"343","Coosan, Athlone, Co. Westmeath");
		Patient p4 = new Patient("Keith Linehan", 3537, "A", "pC",allergies,"A3413", "Goatstown, Dublin");
		Patient p5 = new Patient("Paloma Pastor", 3538, "A", "pD",allergies,"A999","Bellanode, Sligo");
		Patient p6 = new Patient("Daniel Nelms", 3539, "A", "pE",allergies,"Aw42","Bray, Wicklow");
		Patient p7 = new Patient("Sugar Mercado", 3352, "A", "pF",allergies,"Beans","Malahide, Dubline");
		Patient p8 = new Patient("Thomas Anderson", 3535, "A", "pG",allergies,"BEANSBEANS","Bray, Dublin");
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
		Pharmacist ph2 = new Pharmacist("Bibi Elliot", 6969,"B", "B","B,B,B");
		Pharmacist ph3 = new Pharmacist("Karen May", 2345, "password123", "pharm@totalhealth.ie", "Athlone, Co. Westmeath");
		Pharmacist ph4 = new Pharmacist("Joseph Bloggs", 2345, "password123", "Jose[h@totalhealth.ie", "Athlone, Co. Westmeath");
		Pharmacist ph5 = new Pharmacist("Sunny Bloggs", 2345, "password123", "Sunny@totalhealth.ie", "Athlone, Co. Westmeath");
		users.add(ph1);
		users.add(ph2);
		users.add(ph3);
		users.add(ph4);
		users.add(ph5);
		
		
		
		ArrayList<Medicine> medications = medicineStore.getMedications();
		Medicine med1 = medications.get(0);
		Medicine med2 = medications.get(1);
		Medicine med3 = medications.get(2);
		Medicine med4 = medications.get(3);
		Medicine med5 = medications.get(4);

		// PrescriptionItem(Medicine aMedicine, double aDosagePerDay,int aDuration)
		PrescriptionItem pItem1 =  new PrescriptionItem(med1, 0.25,4);
		PrescriptionItem pItem2 =  new PrescriptionItem(med2, 1, 7);
		PrescriptionItem pItem3 =  new PrescriptionItem(med3, 3, 30);
		PrescriptionItem pItem4 =  new PrescriptionItem(med4, 2, 14);
		PrescriptionItem pItem5 =  new PrescriptionItem(med5, 1, 5);
		
			
		//Prescriptions In Data
		Prescription prescription1 = new Prescription();	
			prescription1.setThePatient(p1);
			prescription1.setThePharmacist(ph2);
			prescription1.setTheDoctor(d2);
			prescription1.setTheStatus("Ready for pickup");
			prescription1.addPrescriptionItem(pItem1);
			prescription1.addPrescriptionItem(pItem2);
			prescriptions.add(prescription1);


		Prescription prescription2 = new Prescription();
			prescription2.setThePatient(p2);
			prescription2.setThePharmacist(ph1);
			prescription2.setTheDoctor(d2);
			prescription2.addPrescriptionItem(pItem3);
			prescription1.addPrescriptionItem(pItem4);
			prescriptions.add(prescription2);

		
		Prescription prescription3 = new Prescription();
			prescription3.setThePatient(p3);
			prescription3.setThePharmacist(ph2);
			prescription3.setTheDoctor(d1);
			prescription3.addPrescriptionItem(pItem5);
			prescriptions.add(prescription3);

		
		Prescription prescription4 = new Prescription();
			prescription4.setThePatient(p4);
			prescription4.setThePharmacist(ph2);
			prescription4.setTheDoctor(d2);		
			prescription4.addPrescriptionItem(pItem1);
			prescriptions.add(prescription4);

			
		Prescription prescription5 = new Prescription();
			prescription5.setThePatient(p5);
			prescription5.setThePharmacist(ph2);
			prescription5.setTheDoctor(d1);	
			prescription5.addPrescriptionItem(pItem1);
			prescriptions.add(prescription5);


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
			System.out.println("Doctor Email:"+p.getTheDoctor().getTheEmail());			
		}
		System.out.println("Number of prescriptions " + prescriptions.size());
		
	}
}
