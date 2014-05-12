package com.wordpress.programandojava.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.wordpress.programandojava.entities.Escolaridade;
import com.wordpress.programandojava.repository.EscolaridadeRepository;

@ManagedBean
@SessionScoped
public class EscolaridadeBean {
	private List<Escolaridade> escolaridades = null;
	private Escolaridade escolaridade = new Escolaridade();

	public List<Escolaridade> getEscolaridades() {
		if (this.escolaridades == null) {
			EscolaridadeRepository repository = new EscolaridadeRepository(
					this.getManager());
			this.escolaridades = repository.getEscolaridade();
		}
		return this.escolaridades;
	}

	public void save() {
		EscolaridadeRepository escolaridadeRepository = new EscolaridadeRepository(
				this.getManager());
		escolaridadeRepository.save(this.escolaridade);

		this.escolaridade = new Escolaridade();
		this.escolaridades = null;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("entityManager");
	}
}