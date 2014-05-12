package com.wordpress.programandojava.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.wordpress.programandojava.entities.GestaoConcurso;

public class GestaoConcursoRepository {
	private EntityManager entityManager;

	public GestaoConcursoRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(GestaoConcurso gestaoConcurso) {
		this.entityManager.persist(gestaoConcurso);
		this.entityManager.flush();
	}

	public void update(GestaoConcurso gestaoConcurso) {
		this.entityManager.merge(gestaoConcurso);
		this.entityManager.flush();
	}

	public void remove(GestaoConcurso gestaoConcurso) {
		GestaoConcurso gestaoConcursoTemp = new GestaoConcurso();
		gestaoConcursoTemp = this.entityManager.find(GestaoConcurso.class, gestaoConcurso.getId());

		this.entityManager.remove(gestaoConcursoTemp);
	}

	public GestaoConcurso find(Long ID) {
		return this.entityManager.find(GestaoConcurso.class, ID);
	}

	@SuppressWarnings("unchecked")
	public List<GestaoConcurso> getGestaoConcursos() {
		return this.entityManager.createNamedQuery("GestaoConcurso.findAll")
				.getResultList();
	}

	public Long getCountGestaoConcursos() {
		return (Long) this.entityManager.createNamedQuery("GestaoConcurso.count")
				.getSingleResult();
	}
}
