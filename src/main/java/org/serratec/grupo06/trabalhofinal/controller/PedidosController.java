package org.serratec.grupo06.trabalhofinal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

	@GetMapping //Listar todos os pedidos do site!
	public void listarPedidos() {
		
	}
	
	@PostMapping //Inserir um novo pedido.
	public void inserirPedidos() {
		
	}
	
	@GetMapping("/{id}") //Listar um pedido especifico colocando todos os produtos.
	public void listarPedidosEspecifico() {
		
	}
	
	@PostMapping("/{id}") //Criar um pedido Especifico listando seus produtos.
	public void criarPedidoEspecifico() {
		
	}
	
	@PutMapping("/{id}/{idproduto}") //Atualizar um determinado produto em um pedido.
	public void atualizarProdutoEspecificoPedido() { 
		
	}
	
	@DeleteMapping("/{id}/{idproduto}") // Deletar um determinado produto em um pedido.
	public void deletarProdutoEspecificoPedido() {
		
	}
	
	@GetMapping("/{idusuario}") // Listar todos os pedidos de um usuario especifico
	public void listarPedidosDeComprador() {
		
	}
	
	@PutMapping("/{id}") // Atualizar um detemrinado pedido.
	public void atualizarPedidos() {
		
	}
	
	
	@DeleteMapping("/{id}") // Deletar um determinado pedido.
	public void deletarPedidos() {
		
	}
	
	
}
