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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name="RUA")
	private String rua;
	
	@NotNull
	@Column(name="NUMERO")
	private Integer numero;
	
	@Column(name="COMPLEMENTO")
	private String complemento;
	
	@NotNull
	@Size(min = 3, max = 30)
	@Column(name="BAIRRO")
	private String bairro;
	
	@NotNull
	@Size(min = 3, max = 30)
	@Column(name="CIDADE")
	private String cidade;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{5}\\-[0-9]{3}$")
	@Column(name="CEP")
	private String cep;
	
	@NotNull
	@Size(min = 3, max = 30)
	@Column(name="ESTADO")
	private String estado;
	
	@OneToMany(targetEntity=Usuario.class, 
	           mappedBy="USUARIO",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private Set<Usuario> usuario;

	public Integer getId() {
		return id;
	}

	/*public Endereco() {}
	
	public Endereco(Integer id, @NotNull @Size(min = 3, max = 50) String rua, @NotNull Integer numero,
			String complmento, @NotNull @Size(min = 3, max = 30) String bairro,
			@NotNull @Size(min = 3, max = 30) String cidade,
			@NotNull @Pattern(regexp = "^[0-9]{5}\\-[0-9]{3}$") String cep,
			@NotNull @Size(min = 3, max = 30) String estado) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complmento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
	}*/


	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
}
