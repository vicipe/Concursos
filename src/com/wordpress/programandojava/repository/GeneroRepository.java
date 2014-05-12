package com.wordpress.programandojava.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.wordpress.programandojava.entities.Genero;

public class GeneroRepository {
	private EntityManager entityManager;

	public GeneroRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Genero search(Long ID) {
		return this.entityManager.find(Genero.class, ID);
	}

	public void save(Genero genero) {
		this.entityManager.persist(genero);
		this.entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Genero> getGeneros() {
		return this.entityManager.createNamedQuery("Genero.findAll")
				.getResultList();
	}
}