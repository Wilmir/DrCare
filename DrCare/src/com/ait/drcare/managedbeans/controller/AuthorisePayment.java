package com.ait.drcare.managedbeans.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.model.*;
import com.ait.drcare.payment.PaymentServices;
import com.paypal.base.rest.PayPalRESTException;

@ManagedBean
@SessionScoped
public class AuthorisePayment {
	private Prescription presc;

	public String pay(Prescription prescription) throws IOException {
		presc = prescription;
		try {
			PaymentServices paymentServices = new PaymentServices();
			String approvalLink = paymentServices.authorisePayment(prescription);
			FacesContext.getCurrentInstance().getExternalContext().redirect(approvalLink);
		} catch (PayPalRESTException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
    public void setPrescValue() {
    	presc.setTheStatus("Ready for pickup");
    }
}
