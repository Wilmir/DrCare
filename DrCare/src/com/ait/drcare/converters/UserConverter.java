package com.ait.drcare.converters;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.User;

@FacesConverter("userConverter")
public class UserConverter implements Converter{
	
	   private UserListBean dataStore;
	
	   @PostConstruct
	   public void init() {
		 dataStore = Helper.getBean("userListBean", UserListBean.class);
	   }
	
	   @Override
	   public Object getAsObject(FacesContext facesContext, 
	      UIComponent component, String value) {
			for(User user : dataStore.getUsers()) {
				if(user.getTheName().equals(value)) {
					return user;
					
				}
			}
			
			return null;
			}
	   @Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			return ((User)value).getTheName();
		}
}