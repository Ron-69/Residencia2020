package org.serratec.grupo06.trabalhofinal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@GetMapping
	public void listarProdutos() {
		
	}
	
	@PostMapping
	public void adicionarProdutos() {
		
	}
	
	@GetMapping("/{id}")
	public void listarProdutoEspecifico() {
		
	}
	
	@GetMapping("/{idcategoria}")
	public void listarProdutosCategoria() {
		
	}
	
	@GetMapping("/{idvendedor}")
	public void listarProdutosVendedor() {
		
	}
	
	@PutMapping("/{id}") 
	public void alterarProduto () {
		
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto() {
		
	}
}
