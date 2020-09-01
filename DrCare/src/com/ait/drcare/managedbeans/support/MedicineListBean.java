package com.ait.drcare.managedbeans.support;


import java.sql.Date;
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
	}
	
	
	public ArrayList<Medicine> getMedicineList(){
		
		ArrayList<Medicine> meds  = new ArrayList<Medicine>();
		meds.add(new Medicine("Medicine"));
		meds.add(new Medicine("Bean Juice"));
		meds.add(new Medicine("Beanies Sip"));
		meds.add(new Medicine("Bean"));
		meds.add(new Medicine("Lrgal"));
		
		return meds;
		
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

	
	
}

