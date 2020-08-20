package org.serratec.grupo06.trabalhofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@Column(name="NOME", length = 20, nullable = false)
	private String nome;
	
	@Column(name="DESCRICAO", length = 140, nullable = false)
	private String descricao;

	public Categoria() {
		
	}
	
	public Categoria(Integer iD, String nome, String descricao) {
		ID = iD;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Categoria [ID=" + ID + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	
}
