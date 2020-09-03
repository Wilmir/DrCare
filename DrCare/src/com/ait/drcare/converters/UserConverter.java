package com.ait.drcare.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.User;

@FacesConverter("com.ait.drcare.converter.UserConverter")
public class UserConverter implements Converter{
	
		private UserListBean dataStore = Helper.getBean("UserListBean", UserListBean.class);
	
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
			return ((User)value).toString();
		}
}