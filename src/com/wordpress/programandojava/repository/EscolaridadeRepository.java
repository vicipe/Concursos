package com.wordpress.programandojava.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.wordpress.programandojava.entities.Escolaridade;

public class EscolaridadeRepository {
	private EntityManager entityManager;

	public EscolaridadeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Escolaridade search(Long ID) {
		return this.entityManager.find(Escolaridade.class, ID);
	}

	public void save(Escolaridade escolaridade) {
		this.entityManager.persist(escolaridade);
		this.entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Escolaridade> getEscolaridade() {
		return this.entityManager.createNamedQuery("Escolaridade.findAll")
				.getResultList();
	}
}