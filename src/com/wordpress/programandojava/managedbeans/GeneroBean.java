package com.wordpress.programandojava.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.wordpress.programandojava.entities.Genero;
import com.wordpress.programandojava.repository.GeneroRepository;

@ManagedBean
@SessionScoped
public class GeneroBean {
	private List<Genero> generos = null;
	private Genero genero = new Genero();

	public List<Genero> getGeneros() {
		if (this.generos == null) {
			GeneroRepository repository = new GeneroRepository(
					this.getManager());
			this.generos = repository.getGeneros();
		}

		return this.generos;
	}

	public void save() {
		GeneroRepository generoRepository = new GeneroRepository(
				this.getManager());
		generoRepository.save(this.genero);

		this.genero = new Genero();
		this.generos = null;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("entityManager");
	}
}