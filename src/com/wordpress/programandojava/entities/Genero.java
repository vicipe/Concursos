package com.wordpress.programandojava.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "GENERO")
@NamedQueries({
		@NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g ORDER BY g.nome ASC"),
		@NamedQuery(name = "Genero.count", query = "SELECT COUNT(g) FROM Genero g") })
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genero_ID")
	private Long id;

	@Column(name = "genero_NOME")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}