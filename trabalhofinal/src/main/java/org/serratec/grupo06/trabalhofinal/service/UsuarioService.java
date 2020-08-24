package org.serratec.grupo06.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.grupo06.trabalhofinal.exception.UsuarioNotFoundException;
import org.serratec.grupo06.trabalhofinal.exception.UsuarioRequerParametrosException;
import org.serratec.grupo06.trabalhofinal.model.Usuario;
import org.serratec.grupo06.trabalhofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listar(Usuario usuario){
		return usuarioRepository.findAll();
	}
	
	public Usuario inserir(Usuario usuario) {
		Usuario usuarioSalvoNoDB = usuarioRepository.save(usuario);
		return usuarioSalvoNoDB;
	}
	
	public Usuario listarPorId(Integer id) throws UsuarioNotFoundException {
		Optional<Usuario> optinalUsuario = usuarioRepository.findById(id);
		if(optinalUsuario.isPresent()) {
			return optinalUsuario.get();
		}
		
		throw new UsuarioNotFoundException("Usuario com ID" + id + " não cadastrada");
	}
	
	public Usuario atualizar(Usuario usuario, Integer id) throws UsuarioRequerParametrosException, UsuarioNotFoundException {
		Usuario usuarioListado = listarPorId(id);
		if(usuario == null) throw new UsuarioRequerParametrosException("Tem que existir algum paramentro para ser atualizado");
		
		if(usuario.getNome() != null) {
			usuarioListado.setNome(usuario.getNome());
		}
		if(usuario.getCelular() != null) {
			usuarioListado.setCelular(usuario.getCelular());
		}
		if(usuario.getEmail() != null) {
			usuarioListado.setEmail(usuario.getEmail());
		}
		if(usuario.getEndereco() != null) {
			usuarioListado.setEndereco(usuario.getEndereco());
		}
		if(usuario.getTelefone() != null) {
			usuarioListado.setTelefone(usuario.getTelefone());
		}
		if(usuario.getSenha() != null) {
			usuarioListado.setSenha(usuario.getUsuario());
		}
		
		return usuarioRepository.save(usuarioListado);
	}
	
	public String deletar(Usuario usuario, Integer id) throws UsuarioNotFoundException {
		Usuario usuarioListado = listarPorId(id);
		usuarioRepository.delete(usuarioListado);
		return "Deletado com sucesso";
	}
	
}
