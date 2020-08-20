package org.serratec.grupo06.trabalhofinal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereço")
public class EndereçoController {

	@GetMapping
	public void listarEndereço() {
		
	}
	
	@PostMapping
	public void inserirEndereço() {
		
	}
	
	@GetMapping("/{id}")
	public void listarEndereçoEspecifico() {
		
	}
	
	@PutMapping("/{id}")
	public void atualizarEndereço() {
		
	}
	
	@DeleteMapping("/{id}")
	public void deletarEndereço() {
		
	}
	
}
