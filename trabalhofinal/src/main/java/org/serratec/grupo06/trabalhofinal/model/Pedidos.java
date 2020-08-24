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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="PEDIDOS")
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Column(name = "DATA_PEDIDO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataPedido;
	
	@NotNull
	@Column(name="VALOR_TOTAL")
	private Double valorTotal;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO_COMPRADOR", referencedColumnName = "id")
	private Usuario Usuario;
	
	@OneToMany(targetEntity=Pedidos.class, 
	           mappedBy="CARRINHO",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private Set<Pedidos> pedidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}


	/*public Set<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(Set<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}*/
	
	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal + ", Usuario="
				+ Usuario + ", pedidos=" + pedidos + "]";
	}

}
