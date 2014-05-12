package com.wordpress.programandojava.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "DVD")
@NamedQueries({
		@NamedQuery(name = "DVD.findAll", query = "SELECT d FROM DVD d"),
		@NamedQuery(name = "DVD.count", query = "SELECT COUNT(d) FROM DVD d"),
		@NamedQuery(name = "DVD.findByAno", query="SELECT d FROM DVD d WHERE d.ano = :ano")
})
public class DVD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dvd_ID")
	private Long id;

	@Column(name = "dvd_TITULO", length = 60, nullable = false)
	private String titulo;

	@Column(name = "dvd_PRECO", nullable = false)
	private Double preco;

	@Column(name = "dvd_ANO", nullable = false)
	private int ano;

	@Column(name = "dvd_FAIXA_ETARIA", nullable = false)
	private int faixa_etaria;

	@OneToOne
	@JoinColumn(name="genero_ID")
	private Genero genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getFaixa_etaria() {
		return faixa_etaria;
	}

	public void setFaixa_etaria(int faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}