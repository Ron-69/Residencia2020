package org.serratec.grupo06.trabalhofinal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="CATEGORIA")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@NotNull
	@Size(min = 3, max = 20)
	@Column(name="NOME")
	private String nome;
	
	@NotNull
	@Size(min = 3, max = 140)
	@Column(name="DESCRICAO")
	private String descricao;
	
	@OneToMany(targetEntity = Produtos.class, mappedBy = "PRODUTOS",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Produtos> Produtos;
	
	/*public Categoria() {
		
	}
	
	public Categoria(Integer iD, String nome, String descricao) {
		ID = iD;
		this.nome = nome;
		this.descricao = descricao;
	}*/

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