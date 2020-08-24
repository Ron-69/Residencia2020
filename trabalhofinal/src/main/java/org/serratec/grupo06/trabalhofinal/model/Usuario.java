package org.serratec.grupo06.trabalhofinal.model;

import java.io.Serializable;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(min = 3, max = 40)
	@Column(name="NOME", length = 40, nullable = false)
	private String nome;
	
	@NotNull
	@Column(name="CPF", unique = true)
	@Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$")
	private String cpf;
	
	
	@NotNull
	@Column(name = "USUARIO", unique = true)
	private String usuario;
	
	@NotNull
	@Size(min = 8, max = 15)
	@Column(name = "SENHA")
	private String senha;
	
	@NotNull
	@Email
	@Column(name = "EMAIL")
	private String email;
	
	@NotNull
	@Column(name = "DATA_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataNascimento;
	
	@Column(name = "TELEFONE")
	private Long telefone;
	
	@NotNull
	@Column(name = "CELULAR")
	private Long celular;
	
	@ManyToOne
	@JoinColumn(name="ID_ENDERECO", referencedColumnName = "id")
	private Endereco endereco;
	
	@OneToMany(targetEntity=Produtos.class, 
	           mappedBy="PRODUTOS",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private Set<Produtos> produtos;
	
	@OneToMany(targetEntity=Pedidos.class, 
	           mappedBy="PEDIDOS",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private Set<Pedidos> pedidos;

	
	/*public Usuario() {}
	
	public Usuario(Integer id, @NotNull @Size(min = 3, max = 40) String nome,
			@NotNull @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$") String cpf,
			@NotNull String usuario, @NotNull @Size(min = 8, max = 15) String senha, @NotNull @Email String email,
			@NotNull Date datanascimento, Long telefone, @NotNull Long celular, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		this.dataNascimento = datanascimento;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatanascimento() {
		return dataNascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.dataNascimento = datanascimento;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
