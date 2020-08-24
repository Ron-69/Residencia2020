package org.serratec.grupo06.trabalhofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import javax.validation.Valid;

import org.serratec.grupo06.trabalhofinal.exception.CategoriaRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.CategoriasNotFoundException;
import org.serratec.grupo06.trabalhofinal.model.Categoria;
import org.serratec.grupo06.trabalhofinal.service.CategoriaService;
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
@RequestMapping("/categoria")
@Api(value="API REST TrabalhoFinal")
@CrossOrigin(origins="*")// qualquer domínio pode acessar a api
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@ExceptionHandler
	@GetMapping
	@ApiOperation(value="Retorna uma lista de Categorias")
	public ResponseEntity<List<Categoria>> listarCategoria(Categoria categoria) {
		return new ResponseEntity<>(categoriaService.listar(categoria),HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PostMapping
	@ApiOperation(value="Insere uma categoria nova")
	public ResponseEntity<Void> inserirCategoria(@Valid @RequestBody Categoria categoria ) {
		categoriaService.inserir(categoria);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ExceptionHandler
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna uma lista de categorias específica")
	public ResponseEntity<Categoria> listarCategoriaEspecifica(@PathVariable Integer id) throws CategoriasNotFoundException {
		Categoria categoriaListada = categoriaService.listarPorId(id);
		return new ResponseEntity<Categoria>(categoriaListada, HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza o nome de uma categoria")
	public ResponseEntity<Void> atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) throws CategoriaRequerParametrosException, CategoriasNotFoundException {
		categoriaService.atualizar(categoria, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@ExceptionHandler
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta definitivamente uma categoria")
	public ResponseEntity<Void> deletarCategoria(@PathVariable Integer id) throws CategoriasNotFoundException {
		categoriaService.deletar(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}