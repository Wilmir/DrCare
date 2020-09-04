package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.managedbeans.backing.*;
import com.ait.drcare.model.*;


@ManagedBean
@SessionScoped
public class DoctorController {
	private Patient currentPatient;
	private ArrayList<Prescription> prescriptions;
	private UserListBean dataStore;
	
	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);
	}
	
	public void show(Patient patient) {
		this.currentPatient = patient;
	}

}
