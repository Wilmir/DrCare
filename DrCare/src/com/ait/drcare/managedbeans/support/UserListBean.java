package com.ait.drcare.managedbeans.support;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.ait.drcare.model.Video;


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
		Doctor d1 = new Doctor("Alan Care", 65467890, "passw0rd", "alan@drcare.ie", "08913486", "Athlone, Co. Westmeath");
		Doctor d2 = new Doctor("Luke Meyer",64448901,"Doc","doc@drcare.ie","087696969","Athlone, Co. Westmeath");
		users.add(d1);
		users.add(d2);
		
		// Allergies
		ArrayList<String> allergies = new ArrayList<String>();
		allergies.add("Penicillin");
		allergies.add("Aspirin");

		// Patient(String name,int ID,String Password,String Email, ArrayList<String> Allergies,String medicalCard,String address)
		Patient p1 = new Patient("John Doe", 3456, "password234", "johndoe@gmail.com", allergies, "A18734", "Grand Canal Dock, Co. Dublin");
		Patient p2 = new Patient("Daniel Nelms", 3535, "A", "test@gmail.com",allergies,"A78645","Hanover Quay,  Dublin");
		Patient p3 = new Patient("Lingfei Fan", 3536, "A", "lingfei@gmail.com",allergies,"A3435","The Point, Dublin 1, Co. Dublin");
		Patient p4 = new Patient("Keith Linehan", 3537, "A", "klinehan@gmail.com",allergies,"A3413", "Goatstown, Dublin");
		Patient p5 = new Patient("Paloma Pastor", 3538, "A", "ppastor@hotmail.com",allergies,"A999","Bellanode, Sligo");
		Patient p6 = new Patient("Guy Abimbola", 3539, "A", "guya@gmail.com",allergies,"A4219","Droghea, Co. Louth");
		Patient p7 = new Patient("Sugar Khouiami", 3352, "A", "sugar@hotmail.com",allergies,"A78645","Malahide, Dublin");
		Patient p8 = new Patient("Francis Lucena", 3535, "A", "flucena@gmail.com",allergies,"A45675","Bray, Wicklow");
		Patient p9 = new Patient("James Lanagan", 3535, "A", "jlanagan@gmail.com",allergies,"A83421","The Foundry, Dublin");
		Patient p10 = new Patient("Ciaran White", 3535, "A", "ciaran@gmail.com",allergies,"A67543","Maynooth, Co.Kildare");
		Patient p11 = new Patient("Andreas Romer", 3535, "A", "andreas@gmail.com",allergies,"A32415","Bray, Wicklow");
			users.add(p1);
			users.add(p2);	
			users.add(p3);
			users.add(p4);
			users.add(p5);
			users.add(p6);
			users.add(p7);
			users.add(p8);
			users.add(p9);
			users.add(p10);
			users.add(p11);
			
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
		
		// Medicine(String name, String strength, double price)
		Medicine med1 = new Medicine("Accutane", "12.5 mg", 2.00);
		Medicine med2 = new Medicine("Collagen", "25 mg", 3.50);
		Medicine med3 = new Medicine("Levothyroxine", "100 mg", 5.20);
		Medicine med4 = new Medicine("Metformin", "10 mg", 4.25);
		Medicine med5 = new Medicine("Vimovo","10 mg", 2.25);
		Medicine med6 = new Medicine("Dymista","23 g", 35);
		Medicine med7 = new Medicine("Eye Drops","10mg/g", 32.5);
		
		// PrescriptionItem(Medicine aMedicine, double aDosagePerDay,int aDuration)
		PrescriptionItem pItem1 =  new PrescriptionItem(med1, 0.25,4);
		PrescriptionItem pItem2 =  new PrescriptionItem(med2, 1, 7);
		PrescriptionItem pItem3 =  new PrescriptionItem(med3, 3, 30);
		PrescriptionItem pItem4 =  new PrescriptionItem(med4, 2, 14);
		PrescriptionItem pItem5 =  new PrescriptionItem(med5, 1, 5);
		PrescriptionItem pItem6 =  new PrescriptionItem(med6, 1, 5);
		PrescriptionItem pItem7 =  new PrescriptionItem(med7, 1, 1);
		PrescriptionItem pItem8 =  new PrescriptionItem(med7, 1, 1);
		PrescriptionItem pItem9 =  new PrescriptionItem(med7, 1, 1);

			
		// Prescription(Patient patient, Pharmacist pharmacist, Doctor doctor)
		Prescription prescription1 = new Prescription(p1, ph2, d2);	
			prescription1.setTheStatus("Ready for pickup");
			prescription1.addPrescriptionItem(pItem1);
			prescription1.addPrescriptionItem(pItem8);
			prescriptions.add(prescription1);
			prescription1.addVideo(new Video("vykYmXIiOs0","Accutane"));


		Prescription prescription2 = new Prescription(p2, ph1, d2);
			prescription2.addPrescriptionItem(pItem2);
			prescriptions.add(prescription2);

		
		Prescription prescription3 = new Prescription(p3, ph2, d1);
			prescription3.setTheStatus("Ready for pickup");
			prescription3.addPrescriptionItem(pItem3);
			prescriptions.add(prescription3);

		
		Prescription prescription4 = new Prescription(p4, ph2, d2);	
			prescription4.setTheStatus("Ready for pickup");
			prescription4.addPrescriptionItem(pItem4);
			prescriptions.add(prescription4);

			
		Prescription prescription5 = new Prescription(p5, ph2, d1);
			prescription5.setTheStatus("Ready for pickup");
			prescription5.addPrescriptionItem(pItem5);
			prescriptions.add(prescription5);
			
		
		Prescription prescription6 = new Prescription(p6, ph2, d1);
			prescription6.setTheStatus("Ready for pickup");
			prescription6.addPrescriptionItem(pItem6);
			prescriptions.add(prescription6);
	
		Prescription prescription7 = new Prescription(p7, ph2, d1);
			prescription7.setTheStatus("Ready for pickup");
			prescription7.addPrescriptionItem(pItem7);
			prescriptions.add(prescription7);
			
		Prescription prescription8 = new Prescription(p2, ph2, d2);
			prescription8.setTheStatus("Order Dispensed");
			prescription8.addPrescriptionItem(pItem9);
			prescriptions.add(prescription8);
			prescription8.addVideo(new Video("vykYmXIiOs0","Accutane"));

			
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
		// sort the patients alphabetically by name before returning
		Collections.sort(patients, new Comparator<Patient>() {

			@Override
			public int compare(Patient p1, Patient p2) {
				return (p1.getTheName()).compareTo(p2.getTheName());
			}

		});
	
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}


	public ArrayList<Pharmacist> getPharmacists(){
		// sort the patients alphabetically by name before returning
		Collections.sort(pharmacists, new Comparator<Pharmacist>() {

			@Override
			public int compare(Pharmacist p1, Pharmacist p2) {
				return (p1.getTheName()).compareTo(p2.getTheName());
			}

		});
		
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
		
		
	}
	

}
