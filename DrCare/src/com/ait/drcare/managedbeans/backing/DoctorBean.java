package com.ait.drcare.managedbeans.backing;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.User;

@ManagedBean
@ViewScoped
public class DoctorBean {
	private Doctor doctor;
	private UserListBean existingUsers;
	
	@PostConstruct
	public void init() {
		 existingUsers = Helper.getBean("userListBean", UserListBean.class);
		
		String email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
				
		for(User user: existingUsers.getUsers()) {
			if(user.getTheEmail().equalsIgnoreCase(email)) {
				this.doctor = (Doctor) user;
				break;
			}
		}
		
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
