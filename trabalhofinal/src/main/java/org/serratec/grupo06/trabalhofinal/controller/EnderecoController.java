package org.serratec.grupo06.trabalhofinal.controller;

import org.serratec.grupo06.trabalhofinal.service.EnderecoService;

import java.util.List;

import org.serratec.grupo06.trabalhofinal.exception.EnderecoNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.EnderecoRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Endereco;
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
@RequestMapping("/endereco")
@Api(value="API REST TrabalhoFinal")
@CrossOrigin(origins="*")// qualquer domínio pode acessar a api
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@ExceptionHandler
	@GetMapping
	@ApiOperation(value="Retorna uma lista de endereços")
	public ResponseEntity<List<Endereco>> listarEndereco(Endereco endereco) {
		return new ResponseEntity<>(enderecoService.listar(endereco), HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PostMapping
	@ApiOperation(value="Insere um endereço novo")
	public ResponseEntity<Void> inserirEndereco(@RequestBody Endereco endereco) {
		enderecoService.inserir(endereco);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ExceptionHandler
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna uma lista de endereços específicos")
	public ResponseEntity<Endereco> listarEnderecoEspecifico(@PathVariable Integer id) throws EnderecoNotFoundException {
		Endereco enderecoListado = enderecoService.listarPorId(id);
		return new ResponseEntity<Endereco>(enderecoListado, HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza um endereço passando o id")
	public ResponseEntity<Void> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) throws EnderecoRequerParametrosException, EnderecoNotFoundException {
		enderecoService.atualizar(endereco, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta definitivamente um endereço passando o id")
	public ResponseEntity<Void> deletarEndereco(@PathVariable Integer id) throws EnderecoNotFoundException {
		enderecoService.deletar(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}