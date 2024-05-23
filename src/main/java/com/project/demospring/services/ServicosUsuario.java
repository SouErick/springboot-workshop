package com.project.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demospring.entities.Usuario;
import com.project.demospring.repositories.RepositorioUsuario;
@Service
public class ServicosUsuario {
	@Autowired
	private RepositorioUsuario repositorio;
	public List<Usuario> acharTodos(){
		return repositorio.findAll();
	}
	public Usuario acharPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}
	public Usuario inserir(Usuario obj) {
		return repositorio.save(obj);
	}
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
}
