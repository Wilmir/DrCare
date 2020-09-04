package com.ait.drcare.managedbeans.support;


import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.Prescription;


@ManagedBean
@SessionScoped
public class PrescriptionListBean {
	
	public ArrayList<Pharmacist> pharmacists;
	public ArrayList<Prescription> prescriptions;
	private UserListBean userBean;
	
	@PostConstruct
	public void init() {
		prescriptions  = new ArrayList<Prescription>();

		userBean  = Helper.getBean("userListBean", UserListBean.class);	

			
			
		
	}
	
	


}

