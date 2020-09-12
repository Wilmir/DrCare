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
		
		// Medicine(String name, String strength, double price)
		medications.add(new Medicine("Accutane", "12.5 mg", 2.00));
		medications.add(new Medicine("Collagen", "25 mg", 3.50));
		medications.add(new Medicine("Levothyroxine", "100 mg", 5.20));
		medications.add(new Medicine("Metformin", "10 mg", 4.25));
		medications.add(new Medicine("Vimovo","10 mg", 2.25));
		medications.add(new Medicine("Dymista","23 g", 35));
		medications.add(new Medicine("Eye Drops","10mg/g", 32.5));

		
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

