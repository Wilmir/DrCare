package com.ait.drcare.managedbeans.backing;

import java.util.ArrayList;

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
	private Prescription currentPrescription;	
	private UserListBean dataStore;
	private Object placeholder;
	private ArrayList<Prescription> paidPrescriptions;

	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);	
		paidPrescriptions = new ArrayList<>();
		
		String email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		
		//find user in database
		for (Pharmacist pharmacist : dataStore.getPharmacists()) {
			if (pharmacist.getTheEmail().equals(email)) {
				currentUser = pharmacist;
				break;
			}
		}	
		
		if(currentUser.getPrescriptions()!= null && currentUser.getPrescriptions().size() > 0) {
			
			// filter paid prescriptions
			for(Prescription prescription: currentUser.getPrescriptions()) {
				if(prescription.getTheStatus().equalsIgnoreCase("ready for pickup")) {
					paidPrescriptions.add(prescription);
				}
			}
			
			// set current prescription to the first paid prescription
			if(paidPrescriptions.size() > 0) {
				this.currentPrescription = paidPrescriptions.get(0);
			}
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
	
	public ArrayList<Prescription> getPaidPrescriptions() {
		return paidPrescriptions;
	}

	public void setPaidPrescriptions(ArrayList<Prescription> paidPrescriptions) {
		this.paidPrescriptions = paidPrescriptions;
	}
	
	
	public void save() {
		// if the prescription is dispensed remove it from the queue
		if(currentPrescription.getTheStatus().equalsIgnoreCase("Order Dispensed")) {
			System.out.println("You changed the status");
			paidPrescriptions.remove(currentPrescription);
			
			if(paidPrescriptions.size() > 0) {
				currentPrescription = paidPrescriptions.get(0);
			}else {
				currentPrescription = null;
			}
		}
	}
	
	public Object getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(Object placeholder) {
		this.placeholder = placeholder;
	}	
}
