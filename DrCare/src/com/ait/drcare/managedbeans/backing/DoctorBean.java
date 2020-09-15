package com.ait.drcare.managedbeans.backing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.User;

@ManagedBean
@SessionScoped
public class DoctorBean {
	private Doctor doctor;
	private Patient currentPatient;
	private Prescription currentPrescription;
	private UserListBean dataStore;
	private List<Patient> patients;
	private String query;
	private int searchResultSize;
	private int allPatientsSize;

	
	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);	
		
		currentPatient = dataStore.getPatients().get(0);
	}

	public Doctor getDoctor() {
		String email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		
		for(User user: dataStore.getUsers()) {
			if(user.getTheEmail().equalsIgnoreCase(email)) {
				this.doctor = (Doctor) user;
				break;
			}
		}
		
		patients = dataStore.getPatients();
				
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
		this.query = "";
		this.currentPrescription = null;
	}

	public Prescription getCurrentPrescription() {
		return currentPrescription;
	}

	public void setCurrentPrescription(Prescription currentPrescription) {
		this.currentPrescription = currentPrescription;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query.toLowerCase();
	}

	public int getSearchResultSize() {
		return patients.size();
	}

	public void setSearchResultSize(int searchResultSize) {
		this.searchResultSize = searchResultSize;
	}

	public int getAllPatientsSize() {
		return dataStore.getPatients().size();
	}

	public void setAllPatientsSize(int allPatientsSize) {
		this.allPatientsSize = allPatientsSize;
	}

}
