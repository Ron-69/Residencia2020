package org.serratec.grupo06.trabalhofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.grupo06.trabalhofinal.exception.PedidosNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.PedidosRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Pedidos;
import org.serratec.grupo06.trabalhofinal.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedidos")
@Api(value="API REST TrabalhoFinal")//para acesar documentação tem que subir aplicação e http://localhost:8080/swagger-ui.html produtos-resouce
@CrossOrigin(origins="*")// qualquer domínio pode acessar a api
public class PedidosController {

	@Autowired
	PedidosService pedidosService;
	
	@ExceptionHandler
	@GetMapping //Listar todos os pedidos do site!
	@ApiOperation(value="Retorna uma lista de pedidos")
	public ResponseEntity<List<Pedidos>> listarPedidos(Pedidos pedidos) {
	
		return new ResponseEntity<>(pedidosService.listar(pedidos), HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PostMapping //Inserir um novo pedido.
	@ApiOperation(value="Insere um pedido novo")
	public ResponseEntity<Void> inserirPedidos(@Valid @RequestBody Pedidos pedidos) {
		pedidosService.inserir(pedidos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ExceptionHandler
	@GetMapping("/{id}") //Listar um pedido especifico colocando todos os produtos.
	@ApiOperation(value="Retorna uma lista de pedidos específicos")
	public ResponseEntity<Pedidos> listarPedidosEspecifico(@PathVariable Integer id) throws PedidosNotFoundException {
		Pedidos pedidoListado = pedidosService.listarPorId(id);
		return new ResponseEntity<Pedidos>(pedidoListado, HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PostMapping("/{id}") //Criar um pedido Especifico listando seus produtos.
	@ApiOperation(value="Insere um pedido específico passando o id")
	public ResponseEntity<Void> criarPedidoEspecifico(@Valid @RequestBody Pedidos pedidos) {
		pedidosService.inserir(pedidos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ExceptionHandler
	@PutMapping("/{id}/{idproduto}") //Atualizar um determinado produto em um pedido.
	@ApiOperation(value="Atualiza um pedido específico passando o id")
	public ResponseEntity<Void> atualizarProdutoEspecificoPedido(@PathVariable Integer id, @RequestBody Pedidos pedidos) throws PedidosRequerParametrosException, PedidosNotFoundException { 
		pedidosService.atualizar(pedidos, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	@DeleteMapping("/{id}/{idproduto}") // Deletar um determinado produto em um pedido.
	@ApiOperation(value="Deleta um produto específico de um pedido")
	public ResponseEntity<Void> deletarProdutoEspecificoPedido(@PathVariable Integer id, Pedidos pedidos) throws PedidosNotFoundException{
		pedidosService.deletar(pedidos, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	//Será que precisa criar um método passando pedido e Id_Usuario?
	@ExceptionHandler
	@GetMapping("/{idusuario}") // Listar todos os pedidos de um usuario especifico
	@ApiOperation(value="Retorna a lista de pedidos de um comprador passando o id so usuario")
	public ResponseEntity<List<Pedidos>> listarPedidosDeComprador(Pedidos pedidos) {
		return new ResponseEntity<>(pedidosService.listar(pedidos), HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PutMapping("/{id}") // Atualizar um determinado pedido.
	@ApiOperation(value="Atualiza os pedidos passando o id")
	public ResponseEntity<Void> atualizarPedidos(@PathVariable Integer id, Pedidos pedidos) throws PedidosNotFoundException, PedidosRequerParametrosException {
		pedidosService.atualizar(pedidos, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	@DeleteMapping("/{id}") // Deletar um determinado pedido.
	@ApiOperation(value="Deleta definitivamente um pedido passando o id")
	public ResponseEntity<Void> deletarPedidos(@PathVariable Integer id, Pedidos pedidos) throws PedidosNotFoundException {
		pedidosService.deletar(pedidos, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
