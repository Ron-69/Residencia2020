package org.serratec.grupo06.trabalhofinal.service;

import org.serratec.grupo06.trabalhofinal.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.serratec.grupo06.trabalhofinal.exception.CategoriaRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.exception.CategoriasNotFoundException;
import org.serratec.grupo06.trabalhofinal.model.Categoria;

@Service
public class CategoriaService {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar(Categoria Categoria){
		return categoriaRepository.findAll();
	}
	
	
	public Categoria inserir(Categoria categorias) {
		Categoria categoriasSalvoNoDB = categoriaRepository.save(categorias);
		return categoriasSalvoNoDB;
	}
	
	
	public Categoria listarPorId(Integer id) throws CategoriasNotFoundException {
		Optional<Categoria> optinalCategorias = categoriaRepository.findById(id);
		if(optinalCategorias.isPresent()) {
			return optinalCategorias.get();
		}
		
		throw new CategoriasNotFoundException("Categoria com ID" + id + " não cadastrada");
	}
	
	
	public Categoria atualizar(Categoria categoria, Integer id) throws CategoriaRequerParametrosException, CategoriasNotFoundException {
		Categoria categoriaListada = listarPorId(id);
		if(categoria == null) throw new CategoriaRequerParametrosException("Tem que existir algum paramentro para ser atualizado");
		if(categoria.getNome() != null) {
			categoriaListada.setNome(categoria.getNome());
		}
		if(categoria.getDescricao() != null) {
			categoriaListada.setDescricao(categoria.getDescricao());
		}
		
		return categoriaRepository.save(categoriaListada);
	}
	
	
	public void deletar(Integer id) throws CategoriasNotFoundException {
		Categoria categoriaListada = listarPorId(id);
		categoriaRepository.delete(categoriaListada);
	}

	
}