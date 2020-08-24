package org.serratec.grupo06.trabalhofinal.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "PRODUTOS")
public class Produtos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(min = 3, max = 40)
	@Column(name = "NOME")
	private String nome;

	@NotNull
	@Size(min = 3, max = 140)
	@Column(name = "DESCRICAO")
	private String descricao;

	@NotNull
	@Column(name = "QUANTIDADE_ESTOQUE")
	private Integer quantidade;

	@NotNull
	@Column(name = "DATA_FABRICACAO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataFabricacao;

	@NotNull
	@Column(name = "VALOR")
	private Double valor;

	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA", referencedColumnName = "id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name="ID_USUARIO_VENDEDOR", referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToMany(targetEntity=Produtos.class, 
	           mappedBy="CARRINHO",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private Set<Produtos> produtos;


	/*public Produtos() {}
	
	public Produtos(Integer id, String nome, String descricao, Integer quantidade, Date dataFabricacao, Double valor,
			Categoria categoria, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.dataFabricacao = dataFabricacao;
		this.valor = valor;
		this.categoria = categoria;
		this.usuario = usuario;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Produtos [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", dataFabricacao=" + dataFabricacao + ", valor=" + valor + ", categoria=" + categoria + ", usuario="
				+ usuario + "]";
	}



}