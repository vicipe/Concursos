package com.wordpress.programandojava.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.wordpress.programandojava.entities.DVD;

public class DvdRepository {
	private EntityManager entityManager;

	public DvdRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(DVD dvd) {
		this.entityManager.persist(dvd);
		this.entityManager.flush();
	}

	public void update(DVD dvd) {
		this.entityManager.merge(dvd);
		this.entityManager.flush();
	}

	public void remove(DVD dvd) {
		DVD dvdTemp = new DVD();
		dvdTemp = this.entityManager.find(DVD.class, dvd.getId());

		this.entityManager.remove(dvdTemp);
	}

	public DVD find(Long ID) {
		return this.entityManager.find(DVD.class, ID);
	}

	@SuppressWarnings("unchecked")
	public List<DVD> getDVDs() {
		return this.entityManager.createNamedQuery("DVD.findAll")
				.getResultList();
	}

	public Long getCountDVDs() {
		return (Long) this.entityManager.createNamedQuery("DVD.count")
				.getSingleResult();
	}
}
