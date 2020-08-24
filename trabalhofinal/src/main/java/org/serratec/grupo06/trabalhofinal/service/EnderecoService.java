package org.serratec.grupo06.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.grupo06.trabalhofinal.exception.EnderecoNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.EnderecoRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Endereco;
import org.serratec.grupo06.trabalhofinal.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> listar(Endereco endereco){
		return enderecoRepository.findAll();
	}
	
	public Endereco inserir(Endereco endereco) {
		Endereco enderecoSalvoNoDB = enderecoRepository.save(endereco);
		return enderecoSalvoNoDB;
	}
	
	public Endereco listarPorId(Integer id) throws EnderecoNotFoundException {
		Optional<Endereco> optinalEndereco = enderecoRepository.findById(id);
		if(optinalEndereco.isPresent()) {
			return optinalEndereco.get();
		}
		
		throw new EnderecoNotFoundException("Endereço com ID" + id + " não cadastrada");
	}
	
	public Endereco atualizar(Endereco endereco, Integer id) throws EnderecoRequerParametrosException, EnderecoNotFoundException {
		Endereco enderecoListado = listarPorId(id);
		if(endereco == null) throw new EnderecoRequerParametrosException("Tem que existir algum paramentro para ser atualizado");
		
		if(endereco.getRua() != null) {
			enderecoListado.setRua(endereco.getRua());
		}
		if(endereco.getNumero() != null) {
			enderecoListado.setRua(endereco.getRua());
		}
		if(endereco.getComplemento() != null) {
			enderecoListado.setComplemento(endereco.getComplemento());
		}
		if(endereco.getBairro() != null) {
			enderecoListado.setBairro(endereco.getBairro());
		}
		if(endereco.getCep() != null) {
			enderecoListado.setCep(endereco.getCep());
		}
		if(endereco.getCidade() != null) {
			enderecoListado.setCidade(endereco.getCidade());
		}
		if(endereco.getEstado() != null) {
			enderecoListado.setEstado(endereco.getEstado());
		}
		return enderecoRepository.save(enderecoListado);
	}
	
	public void deletar(Integer id) throws EnderecoNotFoundException {
		Endereco enderecoListado = listarPorId(id);
		enderecoRepository.delete(enderecoListado);
	}
	
}