package com.ait.drcare.managedbeans.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.backing.DoctorBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;


@ManagedBean
@RequestScoped
public class DoctorController {

	private UserListBean dataStore;
	private DoctorBean doctorBean;
	
	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);		
		doctorBean = Helper.getBean("doctorBean", DoctorBean.class);		

	}
		
	public void search() {
        List<Patient> allPatients = dataStore.getPatients();
        List<Patient> results =  allPatients.stream().filter(new Predicate<Patient>() {
			@Override
			public boolean test(Patient t) {
				return t.getTheName().toLowerCase().contains(doctorBean.getQuery());
			}
		}).collect(Collectors.toList());
        
        doctorBean.setPatients(results);
	}
	
	
	public void showAllPatients() {
        doctorBean.setPatients(dataStore.getPatients());
        doctorBean.setQuery("");
	}
	
	public void dialogReturnListener(SelectEvent selectEvent) {
		System.out.println("The prescription form is closed.");
				
		// String newPrescriptionID =((Prescription)selectEvent.getObject()).getTheName();
		
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if(currentInstance != null) {
            currentInstance.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The new prescription has been successfully saved", ""));
        }		
		return;
	}
	
	
}
