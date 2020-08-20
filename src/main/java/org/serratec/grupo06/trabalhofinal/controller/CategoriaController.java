package org.serratec.grupo06.trabalhofinal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@GetMapping
	public void listarCategoria() {
	}
	
	@PostMapping
	public void inserirCategoria() {
	}
	
	@GetMapping("/{id}")
	public void listarCategoriaEspecifica() {
		
	}
	
	@PutMapping("/{id}")
	public void atualizarCategoria() {
		
	}
	
	@DeleteMapping("/{id}")
	public void deletarCategoria() {
		
	}
}
