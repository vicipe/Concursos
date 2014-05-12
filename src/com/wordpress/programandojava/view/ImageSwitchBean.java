package com.wordpress.programandojava.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ImageSwitchBean implements Serializable{

	private static final long serialVersionUID = 2371298446697613641L;
	
	private List<String> images;

	public ImageSwitchBean() {
		images = new ArrayList<String>();
		images.add("/images/Concursos/agente.jpg");
		images.add("/images/Concursos/civil.jpg");
		images.add("/images/Concursos/correios.jpg");
		images.add("/images/Concursos/policia.jpg");
	}

	public List<String> getImages() {
		return images;
	}
}
