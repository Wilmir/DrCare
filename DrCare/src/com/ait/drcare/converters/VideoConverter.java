package com.ait.drcare.converters;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.managedbeans.support.VideoListBean;
import com.ait.drcare.model.User;
import com.ait.drcare.model.Video;

@FacesConverter("videoConverter")
public class VideoConverter implements Converter{

	   private VideoListBean videoStore;
		
	   @PostConstruct
	   public void init() {
		   videoStore = Helper.getBean("videoListBean", VideoListBean.class);
	   }
	   
	   @Override
	   public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
			for(Video video : videoStore.getVideos()) {
				if(video.getId().equals(value)) {
					return video;	
				}
			}
			
			return null;
		}
	   
	   @Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			return ((Video)value).toString();
		}
}
