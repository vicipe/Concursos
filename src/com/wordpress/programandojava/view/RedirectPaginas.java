package com.wordpress.programandojava.view;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
@SessionScoped
public class RedirectPaginas implements Serializable {
	
	private static final long serialVersionUID = -8521463822382463960L;

	public void redireciona() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("destaqueSelecionado.xhtml");
	}
	
}
