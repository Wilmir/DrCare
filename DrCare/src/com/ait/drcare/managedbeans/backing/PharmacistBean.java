package com.ait.drcare.managedbeans.backing;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.Prescription;

@ManagedBean
@ViewScoped
public class PharmacistBean {
	private Pharmacist currentUser;
	private UserListBean dataStore;
	private Prescription currentPrescription;	
	private Object placeholder;

	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);	
		
		String email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		
		//find user in database
		for (Pharmacist pharmacist : dataStore.getPharmacists()) {
			if (pharmacist.getTheEmail().equals(email)) {
				currentUser = pharmacist;
				break;
			}
		}	
		
		if(currentUser.getPrescriptions().size() > 0) {
			this.currentPrescription = currentUser.getPrescriptions().get(0);
		}
		
	}

	public Pharmacist getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Pharmacist currentUser) {
		this.currentUser = currentUser;
	}

	public Prescription getCurrentPrescription() {
		return currentPrescription;
	}

	public void setCurrentPrescription(Prescription currentPrescription) {
		this.currentPrescription = currentPrescription;
	}

	public Object getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(Object placeholder) {
		this.placeholder = placeholder;
	}
	
}
