package com.project.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demospring.entities.Usuario;
import com.project.demospring.repositories.RepositorioUsuario;
import com.project.demospring.services.exceptions.ResourceNotFoundException;
@Service
public class ServicosUsuario {
	@Autowired
	private RepositorioUsuario repositorio;
	public List<Usuario> acharTodos(){
		return repositorio.findAll();
	}
	public Usuario acharPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	public Usuario atualizar(Long id, Usuario obj) {
		Usuario entidade = repositorio.getReferenceById(id);
		atualizarDados(entidade, obj);
		return repositorio.save(entidade);
	}
	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}
