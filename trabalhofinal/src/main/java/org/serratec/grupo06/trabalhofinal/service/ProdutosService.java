package org.serratec.grupo06.trabalhofinal.service;

import java.util.List;
import java.util.Optional;
import org.serratec.grupo06.trabalhofinal.exception.ProdutosNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.ProdutosRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Produtos;
import org.serratec.grupo06.trabalhofinal.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	public List<Produtos> listar(Produtos produtos){
		return produtosRepository.findAll();
	}
	
	public Produtos inserir(Produtos produtos) {
		Produtos produtosSalvoNoDB = produtosRepository.save(produtos);
		return produtosSalvoNoDB;
	}
	
	public Produtos listarPorId(Integer id) throws ProdutosNotFoundException {
		Optional<Produtos> optinalProdutos = produtosRepository.findById(id);
		if(optinalProdutos.isPresent()) {
			return optinalProdutos.get();
		}
		
		throw new ProdutosNotFoundException("Produto com ID" + id + " não cadastrada");
	}
	
	public Produtos atualizar(Produtos produtos, Integer id) throws ProdutosRequerParametrosException, ProdutosNotFoundException {
		Produtos produtoListado = listarPorId(id);
		if(produtos == null) throw new ProdutosRequerParametrosException("Tem que existir algum paramentro para ser atualizado");
		if(produtos.getNome() != null) {
			produtoListado.setNome(produtos.getNome());
		}
		if(produtos.getDescricao() != null) {
			produtoListado.setDescricao(produtos.getDescricao());
		}
		if(produtos.getCategoria() != null) {
			produtoListado.setCategoria(produtos.getCategoria());
		}
		if (produtos.getDataFabricacao() != null) {
			produtoListado.setDataFabricacao(produtos.getDataFabricacao());
		}
		if (produtos.getQuantidade() != null) {
			produtoListado.setQuantidade(produtos.getQuantidade());
		}
		if (produtos.getValor() != null) {
			produtoListado.setValor(produtos.getValor());
		}
		return produtosRepository.save(produtoListado);
	}
	
	public String deletar(Produtos categoria, Integer id) throws ProdutosNotFoundException {
		Produtos produtoListado = listarPorId(id);
		produtosRepository.delete(produtoListado);
		return "Deletado com sucesso";
	}
}
