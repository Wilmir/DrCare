package com.ait.drcare.managedbeans.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Patient;


@ManagedBean
@RequestScoped
public class DoctorController {

	private UserListBean dataStore;
	
	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);		
	}
	
	// autocomplete search feature
	public List<Object> completeSearch(String query) {
	        final String queryLowerCase = query.toLowerCase();
	        List<Patient> allPatients = dataStore.getPatients();
	        return allPatients.stream().filter(new Predicate<Patient>() {
				@Override
				public boolean test(Patient t) {
					return t.getTheName().toLowerCase().startsWith(queryLowerCase);
				}
			}).collect(Collectors.toList());
	}
	
}
