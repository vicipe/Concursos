package com.wordpress.programandojava.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import com.wordpress.programandojava.entities.GestaoConcurso;
import com.wordpress.programandojava.entities.Escolaridade;
import com.wordpress.programandojava.repository.GestaoConcursoRepository;
import com.wordpress.programandojava.repository.EscolaridadeRepository;

@ManagedBean
@SessionScoped
public class GestaoConcursoBean {
	private GestaoConcurso gestaoConcurso = new GestaoConcurso();
	private List<GestaoConcurso> gestaoConcursos;
	private Long escolaridadeID;

	public void save() {
		EscolaridadeRepository escolaridadeRepository = new EscolaridadeRepository(
				this.getManager());
		Escolaridade escolaridade = escolaridadeRepository.search(escolaridadeID);
		this.gestaoConcurso.setEscolaridade(escolaridade);

		GestaoConcursoRepository gestaoConcursoRepository = new GestaoConcursoRepository(this.getManager());
		gestaoConcursoRepository.save(this.gestaoConcurso);

		this.gestaoConcurso = new GestaoConcurso();
		this.gestaoConcursos = null;
	}

	public void update() {
		EscolaridadeRepository escolaridadeRepository = new EscolaridadeRepository(
				this.getManager());
		Escolaridade escolaridade = escolaridadeRepository.search(escolaridadeID);
		this.gestaoConcurso.setEscolaridade(escolaridade);

		GestaoConcursoRepository gestaoConcursoRepository = new GestaoConcursoRepository(this.getManager());
		gestaoConcursoRepository.update(this.gestaoConcurso);

		this.gestaoConcurso = new GestaoConcurso();
		this.escolaridadeID = null;
		this.gestaoConcursos = null;
	}

	public void remove(GestaoConcurso gestaoConcurso) {
		GestaoConcursoRepository repository = new GestaoConcursoRepository(this.getManager());
		repository.remove(gestaoConcurso);

		this.gestaoConcursos = null;
	}

	public List<GestaoConcurso> getGestaoConcursos() {
		if (this.gestaoConcursos == null) {
			GestaoConcursoRepository repository = new GestaoConcursoRepository(this.getManager());
			this.gestaoConcursos = repository.getGestaoConcursos();
		}

		return this.gestaoConcursos;
	}

	public Long getCount() {
		GestaoConcursoRepository repository = new GestaoConcursoRepository(this.getManager());

		return repository.getCountGestaoConcursos();
	}

	public String preparaAlterar(GestaoConcurso gestaoConcurso) {
		this.setGestaoConcursos(gestaoConcurso);
		this.setEscolaridadeID(this.getGestaoConcurso().getEscolaridade().getId());

		return "index?faces-redirect=true";
	}

	public GestaoConcurso getGestaoConcurso() {
		return gestaoConcurso;
	}

	public void setGestaoConcursos(GestaoConcurso gestaoConcurso) {
		this.gestaoConcurso = gestaoConcurso;
	}

	public Long getEscolaridadeID() {
		return escolaridadeID;
	}

	public void setEscolaridadeID(Long escolaridadeID) {
		this.escolaridadeID = escolaridadeID;
	}

	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("entityManager");
	}
}