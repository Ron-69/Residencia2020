package org.serratec.grupo06.trabalhofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRINHO")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="QUANTIDADE")
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name="ID_PEDIDO", referencedColumnName = "id")
	private Produtos produtos;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUTO", referencedColumnName = "id")
	private Pedidos pedidos;

	/*public Carrinho() {}
	
	public Carrinho(Integer id, Integer quantidade, Produtos produtos, Pedidos pedidos) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produtos = produtos;
		this.pedidos = pedidos;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	

}
