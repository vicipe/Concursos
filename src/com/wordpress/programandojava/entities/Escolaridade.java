package com.wordpress.programandojava.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ESCOLARIDADE")
@NamedQueries({
		@NamedQuery(name = "Escolaridade.findAll", query = "SELECT e FROM Escolaridade e ORDER BY e.curso ASC"),
		@NamedQuery(name = "Escolaridade.count", query = "SELECT COUNT(e) FROM Escolaridade e") })
public class Escolaridade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "escolaridade_ID")
	private Long id;

	@Column(name = "curso")
	private String curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}