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
	private boolean preview;
	private int queueSize;

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
					
		// set view to edit mode
		preview = false;
	}
	
	public ArrayList<Prescription> getPaidPrescriptions() {
		return paidPrescriptions;
	}

	public void setPaidPrescriptions(ArrayList<Prescription> paidPrescriptions) {
		this.paidPrescriptions = paidPrescriptions;
	}
	
	
	public int getQueueSize() {
		return paidPrescriptions.size();
	}


	public void setQueueSize(int queueSize) {
		this.queueSize = queueSize;
	}


	public void save() {
		boolean dispenseAction = currentPrescription.getTheStatus().equalsIgnoreCase("Order Dispensed");
		
		// if the prescription is dispensed remove it from the queue
		if(dispenseAction)
		{
			paidPrescriptions.remove(currentPrescription);

			// then move to the new top of the queue
			if(paidPrescriptions.size() > 0) {
				setCurrentPrescription(paidPrescriptions.get(0));
			}else {
				currentPrescription = null;
			}
		}
		else // just move to the next prescription in the queue
		{
			int index = paidPrescriptions.indexOf(currentPrescription);
						
			if(index != paidPrescriptions.size() - 1) {
				setCurrentPrescription(paidPrescriptions.get(index+1));
			}else {
				setCurrentPrescription(paidPrescriptions.get(0));
			}
		}
			
	}
	
	
	public boolean isPreview() {
		return preview;
	}

	public void setPreview(boolean preview) {
		this.preview = preview;
	}


	public void preview() {
		preview = !preview;
	}
	
	public Object getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(Object placeholder) {
		this.placeholder = placeholder;
	}
	
}
