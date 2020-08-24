package org.serratec.grupo06.trabalhofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.grupo06.trabalhofinal.exception.UsuarioNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.UsuarioRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Usuario;
import org.serratec.grupo06.trabalhofinal.service.UsuarioService;
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
@RequestMapping("/usuario")
@Api(value="API REST TrabalhoFinal")
@CrossOrigin(origins="*")// qualquer domínio pode acessar a api
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@ExceptionHandler
	@GetMapping
	@ApiOperation(value="Retorna uma lista de usuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios(Usuario usuario) {
		return new ResponseEntity<>(usuarioService.listar(usuario), HttpStatus.CREATED);
	}

	@ExceptionHandler
	@PostMapping
	@ApiOperation(value="Insere um usuario novo")
	public ResponseEntity<Void> inserirUsuarios(@Valid @RequestBody Usuario usuario) {
		usuarioService.inserir(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@ExceptionHandler
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna uma lista de usuários específicos passando o id")
	public ResponseEntity<Usuario> listarUsuarioEspecifico(@PathVariable Integer id) throws UsuarioNotFoundException {
		Usuario usuariosListado= usuarioService.listarPorId(id);
		return new ResponseEntity<Usuario>(usuariosListado, HttpStatus.OK);
	}
	
	@ExceptionHandler
	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza um usuário passando o id")
	public ResponseEntity<Void> atualizarUsuario(@PathVariable Integer id, Usuario usuario) throws UsuarioRequerParametrosException, UsuarioNotFoundException {
		usuarioService.atualizar(usuario, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@ExceptionHandler
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta um usuário passando o id")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id, Usuario usuario) throws UsuarioNotFoundException {
		usuarioService.deletar(usuario, id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}