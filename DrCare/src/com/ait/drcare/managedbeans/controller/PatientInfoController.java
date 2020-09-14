package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.*;

@ManagedBean
@ViewScoped
public class PatientInfoController {
	private String userEmail;
	private Patient currentUser;
	private ArrayList<Patient> patients;
	private UserListBean dataStore;

	@PostConstruct
	public void init() {
		userEmail = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		dataStore = Helper.getBean("userListBean", UserListBean.class);
		patients = dataStore.getPatients();
		for (Patient patient : patients) {
			if (patient.getTheEmail().equals(userEmail)) {
				currentUser = patient;
				break;
			}
		}
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Patient getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Patient currentUser) {
		this.currentUser = currentUser;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

}
