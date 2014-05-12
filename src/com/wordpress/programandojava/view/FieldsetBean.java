package com.wordpress.programandojava.view;

import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;  

import org.primefaces.event.ToggleEvent;  
import org.primefaces.model.Visibility;


@ManagedBean
@SessionScoped
public class FieldsetBean {  
  
	String detalhe;
	
    public void handleToggle(ToggleEvent event) {  
    	
    	if(event.getVisibility().equals(Visibility.VISIBLE) ){
    		detalhe = "Exibindo destaque.";
    	}else if(event.getVisibility().equals(Visibility.HIDDEN)){
    		detalhe = "Ocultando destaque.";
    	}
    	
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Destaque Selecionado", detalhe);  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}  
