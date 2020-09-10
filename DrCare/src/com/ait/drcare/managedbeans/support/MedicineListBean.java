package com.ait.drcare.managedbeans.support;


import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.ait.drcare.model.Medicine;


@ManagedBean
@SessionScoped
public class MedicineListBean {
	
	public ArrayList<Medicine> medications;
	private double theDosage = 20;
	private int theDays = 20;
	private int testDay = 2;
	
	@PostConstruct
	public void init() {
		medications  = new ArrayList<Medicine>();
		theDosage  = 10;
		theDays = 1;
		
		medications.add(new Medicine("Almogran", 2.00));
		medications.add(new Medicine("Amytryptyline", 3.50));
		medications.add(new Medicine("Lyrica", 5.20));
		medications.add(new Medicine("Carmustin", 4.25));
		medications.add(new Medicine("Vimovo", 2.25));

		
		ArrayList<String> ingredients = new ArrayList<>();
			ingredients.add("Sugar");
			ingredients.add("Spice");
			ingredients.add("And everything nice");

		
		ArrayList<String> sideEffects = new ArrayList<>();
			sideEffects.add("Constipation");
			sideEffects.add("Dizziness");
			sideEffects.add("Dry mouth");
			
			
		for(Medicine medicine : medications) {
			medicine.setTheContents(ingredients);
			medicine.setTheSideEffects(sideEffects);
		}	
	}
		
	public double getDosage() {
		return theDosage;
	}
	public int getDays() {
		return theDays;
	}
	
	public int getTestDay() {
		return testDay;
	}


	public ArrayList<Medicine> getMedications() {
		return medications;
	}


	public void setMedications(ArrayList<Medicine> medications) {
		this.medications = medications;
	}

}

