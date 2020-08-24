package org.serratec.grupo06.trabalhofinal.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serratec.grupo06.trabalhofinal.exception.CarrinhoRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.CategoriaRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.EnderecoRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.PedidosRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.ProdutosRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.UsuarioRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.CarrinhoNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.CategoriasNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.EnderecoNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.PedidosNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.ProdutosNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.UsuarioNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(CarrinhoNotFoundException.class)
	public ResponseEntity<Void> trataCarrinhoNotFound(CarrinhoNotFoundException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(EnderecoNotFoundException.class)
	public ResponseEntity<Void> trataEnderecoNotFound(EnderecoNotFoundException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(PedidosNotFoundException.class)
	public ResponseEntity<Void> trataPedidosNotFound(PedidosNotFoundException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(ProdutosNotFoundException.class)
	public ResponseEntity<Void> trataProdutosNotFound(ProdutosNotFoundException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(CategoriasNotFoundException.class)
	public ResponseEntity<Void> trataCategoriasNotFound(CategoriasNotFoundException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(UsuarioNotFoundException.class)
	public ResponseEntity<Void> trataUsuarioNotFound(UsuarioNotFoundException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(CarrinhoRequerParametrosException.class)
	public ResponseEntity<Void> trataCarrinhoRequerParametros(CarrinhoRequerParametrosException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(EnderecoRequerParametrosException.class)
	public ResponseEntity<Void> trataEnderecoRequerParametros(EnderecoRequerParametrosException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(PedidosRequerParametrosException.class)
	public ResponseEntity<Void> trataPedidosRequerParametros(PedidosRequerParametrosException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(ProdutosRequerParametrosException.class)
	public ResponseEntity<Void> trataProdutosRequerParametros(ProdutosRequerParametrosException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(CategoriaRequerParametrosException.class)
	public ResponseEntity<Void> trataCategoriaRequerParametros(CategoriaRequerParametrosException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(UsuarioRequerParametrosException.class)
	public ResponseEntity<Void> trataUsuarioRequerParametros(UsuarioRequerParametrosException exception) {
		String mensagem = exception.getMessage();
		return ResponseEntity.notFound()
							.header("x-erro-msg", mensagem)
							.build();

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> trataValidacoes(MethodArgumentNotValidException exception){
	Map<String, String> errosMap = new HashMap<String, String>();
	List<ObjectError> errosEncontrados = exception.getBindingResult().getAllErrors();
	for (ObjectError erro : errosEncontrados) {
	FieldError fieldError = (FieldError) erro;
	String atributo = fieldError.getField();
	String mensagem = fieldError.getDefaultMessage();
	errosMap.put(atributo, mensagem);
	}
	return ResponseEntity.badRequest().body(errosMap);
	}
}