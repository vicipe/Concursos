package com.wordpress.programandojava.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.wordpress.programandojava.entities.DVD;
import com.wordpress.programandojava.entities.Genero;
import com.wordpress.programandojava.repository.DvdRepository;
import com.wordpress.programandojava.repository.GeneroRepository;

@ManagedBean
@SessionScoped
public class DvdBean {
	private DVD dvd = new DVD();
	private List<DVD> dvds;
	private Long generoID;

	public void save() {
		GeneroRepository generoRepository = new GeneroRepository(
				this.getManager());
		Genero genero = generoRepository.search(generoID);
		this.dvd.setGenero(genero);

		DvdRepository dvdRepository = new DvdRepository(this.getManager());
		dvdRepository.save(this.dvd);

		this.dvd = new DVD();
		this.dvds = null;
	}

	public void update() {
		GeneroRepository generoRepository = new GeneroRepository(
				this.getManager());
		Genero genero = generoRepository.search(generoID);
		this.dvd.setGenero(genero);

		DvdRepository dvdRepository = new DvdRepository(this.getManager());
		dvdRepository.update(this.dvd);

		this.dvd = new DVD();
		this.generoID = null;
		this.dvds = null;
	}

	public void remove(DVD dvd) {
		DvdRepository repository = new DvdRepository(this.getManager());
		repository.remove(dvd);

		this.dvds = null;
	}

	public List<DVD> getDvds() {
		if (this.dvds == null) {
			DvdRepository repository = new DvdRepository(this.getManager());
			this.dvds = repository.getDVDs();
		}

		return this.dvds;
	}

	public Long getCount() {
		DvdRepository repository = new DvdRepository(this.getManager());

		return repository.getCountDVDs();
	}

	public String preparaAlterar(DVD dvd) {
		this.setDvd(dvd);
		this.setGeneroID(this.getDvd().getGenero().getId());

		return "index?faces-redirect=true";
	}

	public DVD getDvd() {
		return dvd;
	}

	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}

	public Long getGeneroID() {
		return generoID;
	}

	public void setGeneroID(Long generoID) {
		this.generoID = generoID;
	}

	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("entityManager");
	}
}