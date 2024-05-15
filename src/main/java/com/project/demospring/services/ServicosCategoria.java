package com.project.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demospring.entities.Categoria;
import com.project.demospring.repositories.RepositorioCategoria;
@Service
public class ServicosCategoria {
	@Autowired
	private RepositorioCategoria repositorio;
	public List<Categoria> acharTodos(){
		return repositorio.findAll();
	}
	public Categoria acharPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
