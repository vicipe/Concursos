package com.wordpress.programandojava.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "GESTAO_CONCURSO")
@NamedQueries({
		@NamedQuery(name = "concurso.findAll", query = "SELECT c FROM GestaoConcurso c"),
		@NamedQuery(name = "concurso.count", query = "SELECT COUNT(c) FROM GestaoConcurso c"),
		@NamedQuery(name = "concurso.findByGestaoConcurso", query="SELECT c FROM GestaoConcurso c WHERE c.escolaridade = :escolaridade")
})
public class GestaoConcurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "concurso_ID")
	private Long id;

	@Column(name = "nome_concurso", length = 60, nullable = false)
	private String nomeConcurso;

	@Column(name = "remuneracao", nullable = false)
	private Double remuneracao;

	@Column(name = "inscricao_ate", nullable = false)
	private Date inscricaoAte;

	@Column(name = "numero_de_vagas", nullable = false)
	private int numeroVagas;

	@OneToOne
	@JoinColumn(name="escolaridade")
	private Escolaridade escolaridade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeConcurso() {
		return nomeConcurso;
	}

	public void setNomeConcurso(String nomeConcurso) {
		this.nomeConcurso = nomeConcurso;
	}

	public Double getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(Double remuneracao) {
		this.remuneracao = remuneracao;
	}

	public Date getInscricaoAte() {
		return inscricaoAte;
	}

	public void setInscricaoAte(Date inscricaoAte) {
		this.inscricaoAte = inscricaoAte;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	
}