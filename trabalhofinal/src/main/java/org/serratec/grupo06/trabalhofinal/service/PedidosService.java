package org.serratec.grupo06.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.grupo06.trabalhofinal.exception.PedidosNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.PedidosRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Pedidos;
import org.serratec.grupo06.trabalhofinal.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
	@Autowired
	private PedidosRepository pedidosRepository;
	
	public List<Pedidos> listar(Pedidos pedidos){
		return pedidosRepository.findAll();
	}
	
	public Pedidos inserir(Pedidos pedidos) {
		Pedidos pedidosSalvoNoDB = pedidosRepository.save(pedidos);
		return pedidosSalvoNoDB;
	}
	
	public Pedidos listarPorId(Integer id) throws PedidosNotFoundException {
		Optional<Pedidos> optinalPedido = pedidosRepository.findById(id);
		if(optinalPedido.isPresent()) {
			return optinalPedido.get();
		}
		
		throw new PedidosNotFoundException("Pedido com ID" + id + " não cadastrada");
	}
	
	public Pedidos atualizar(Pedidos pedidos, Integer id) throws PedidosRequerParametrosException, PedidosNotFoundException {
		Pedidos pedidoListado = listarPorId(id);
		if(pedidos == null) throw new PedidosRequerParametrosException("Tem que existir algum paramentro para ser atualizado");
		
		if(pedidos.getValorTotal() != null) {
			pedidoListado.setValorTotal(pedidos.getValorTotal());
		}
		return pedidosRepository.save(pedidoListado);
	}
	
	public String deletar(Pedidos pedidos, Integer id) throws PedidosNotFoundException {
		Pedidos pedidoListado = listarPorId(id);
		pedidosRepository.delete(pedidoListado);
		return "Deletado com sucesso";
	}
	
	
}
