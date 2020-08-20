package org.serratec.grupo06.trabalhofinal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@GetMapping
	public void listarUsuarios() {
		
	}
	
	@PostMapping
	public void inserirUsuarios() {
		
	}
	
	@GetMapping("/{id}")
	public void listarUsuarioEspecifico() {
		
	}
	
	@PutMapping("/{id}")
	public void atualizarUsuario() {
		
	}
	
	@DeleteMapping("/{id}")
	public void deletarUsuario() {
		
	}
}
