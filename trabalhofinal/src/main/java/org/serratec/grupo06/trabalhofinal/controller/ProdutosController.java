package org.serratec.grupo06.trabalhofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.grupo06.trabalhofinal.exception.ProdutosNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.ProdutosRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Produtos;
import org.serratec.grupo06.trabalhofinal.service.ProdutosService;
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
@RequestMapping("/produtos")
@Api(value="API REST TrabalhoFinal")
@CrossOrigin(origins="*")// qualquer domínio pode acessar a api
public class ProdutosController {

	@Autowired
	ProdutosService produtosService;
	
	
	@ExceptionHandler
	@GetMapping
	@ApiOperation(value="Retorna uma lista de produtos")
	public ResponseEntity<List<Produtos>> listarProdutos(Produtos produtos) {
		return new ResponseEntity<>(produtosService.listar(produtos), HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PostMapping
	@ApiOperation(value="Insere um produto novo")
	public ResponseEntity<Void> adicionarProdutos(@Valid @RequestBody Produtos produtos) {
		produtosService.inserir(produtos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ExceptionHandler
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna uma lista de produtos específicos passando seu id")
	public ResponseEntity<Produtos> listarProdutoEspecifico(@PathVariable Integer id) throws ProdutosNotFoundException {
		Produtos produtosListado= produtosService.listarPorId(id);
		return new ResponseEntity<Produtos>(produtosListado, HttpStatus.OK);
	}
	
	@ExceptionHandler
	@GetMapping("/{idcategoria}")//qual o id do path?
	@ApiOperation(value="Retorna uma lista de produtos por categoria")
	public ResponseEntity<Produtos> listarProdutosCategoria(@PathVariable Integer id) throws ProdutosNotFoundException {
		Produtos produtosListado= produtosService.listarPorId(id);
		return new ResponseEntity<Produtos>(produtosListado, HttpStatus.OK);
	}
	
	@ExceptionHandler
	@GetMapping("/{idvendedor}")
	@ApiOperation(value="Retorna uma lista de produtos por vendedor passando o id do vendedor")
	public ResponseEntity<Produtos> listarProdutosVendedor(@PathVariable Integer id) throws ProdutosNotFoundException {
		Produtos produtosListado= produtosService.listarPorId(id);
		return new ResponseEntity<Produtos>(produtosListado, HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PutMapping("/{id}") 
	@ApiOperation(value="Altera um produto passando seu id")
	public ResponseEntity<Void> alterarProduto (@PathVariable Integer id, Produtos produtos) throws ProdutosRequerParametrosException, ProdutosNotFoundException {
		produtosService.atualizar(produtos, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta um produto passando seu id")
	public ResponseEntity<Void> deletarProduto(@PathVariable Integer id, Produtos produtos) throws ProdutosNotFoundException {
		produtosService.deletar(produtos, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
