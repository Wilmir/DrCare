package com.ait.drcare.managedbeans.controller;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class FileDownloadView {
    private StreamedContent file;
    
    public FileDownloadView() {
    	InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/userguide/userguide.pdf");  	
    	file = new DefaultStreamedContent(stream, "application/pdf", "userguide.pdf");  
    }
 
    public StreamedContent getFile() {
        return file;
    }
}
