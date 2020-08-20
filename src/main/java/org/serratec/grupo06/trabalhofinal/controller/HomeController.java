package org.serratec.grupo06.trabalhofinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping
	public String leia() {
		return "Seja bem-vindo ao Marktplace do Grupo 06";
	}
	
}
