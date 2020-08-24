package org.serratec.grupo06.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.grupo06.trabalhofinal.exception.CarrinhoNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.CarrinhoRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Carrinho;
import org.serratec.grupo06.trabalhofinal.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public List<Carrinho> listar(Carrinho carrinho){
		return carrinhoRepository.findAll();
	}
	
	public Carrinho inserir(Carrinho carrinho) {
		Carrinho carrinhoSalvoNoDB = carrinhoRepository.save(carrinho);
		return carrinhoSalvoNoDB;
	}
	
	public Carrinho listarPorId(Integer id) throws CarrinhoNotFoundException {
		Optional<Carrinho> optinalCarrinho = carrinhoRepository.findById(id);
		if(optinalCarrinho.isPresent()) {
			return optinalCarrinho.get();
		}
		
		throw new CarrinhoNotFoundException("Pedido com ID" + id + " não cadastrada");
	}
	
	public Carrinho atualizar(Carrinho carrinho, Integer id) throws CarrinhoRequerParametrosException, CarrinhoNotFoundException {
		Carrinho carrinhoListado = listarPorId(id);
		if(carrinho == null) throw new CarrinhoRequerParametrosException("Tem que existir algum paramentro para ser atualizado");
		
		if(carrinho.getQuantidade() != null) {
			carrinhoListado.setQuantidade(carrinho.getQuantidade());
		}
		return carrinhoRepository.save(carrinhoListado);
	}
	
	public String deletar(Carrinho carrinho, Integer id) throws CarrinhoNotFoundException {
		Carrinho pedidoListado = listarPorId(id);
		carrinhoRepository.delete(pedidoListado);
		return "Deletado com sucesso";
	}
	
	
}
