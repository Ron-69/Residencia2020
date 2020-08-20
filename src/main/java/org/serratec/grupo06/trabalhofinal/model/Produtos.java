package org.serratec.grupo06.trabalhofinal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="PRODUTOS")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "DESCRICAO", length = 140, nullable = false)
	private String descricao;
	
	@Column(name = "QUANTIDADE_ESTOQUE", nullable = false)
	private Integer quantidade;
	
	@Column(name="DATA_FABRICACAO", nullable = false) 
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataFabricacao;
	
	@Column(name = "VALOR", nullable = false)
	private Double valor;

	@Column(name = "ID_CATEGORIA", nullable = false)
	private Integer idCategoria;
	
}
