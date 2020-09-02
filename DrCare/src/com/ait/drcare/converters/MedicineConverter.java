package com.ait.drcare.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.MedicineListBean;
import com.ait.drcare.model.Medicine;

@FacesConverter("medicineConverter")
public class MedicineConverter implements Converter{

	private MedicineListBean dataStore = Helper.getBean("medicineListBean", MedicineListBean.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		for(Medicine medicine : dataStore.getMedications()) {
			if(medicine.getTheName().equals(value)) {
				return medicine;
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Medicine)value).toString();
	}
}
