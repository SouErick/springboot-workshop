package com.project.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demospring.entities.Ordem;
import com.project.demospring.repositories.RepositorioOrdem;
@Service
public class ServicosOrdem {
	@Autowired
	private RepositorioOrdem repositorio;
	public List<Ordem> acharTodos(){
		return repositorio.findAll();
	}
	public Ordem acharPorId(Long id) {
		Optional<Ordem> obj = repositorio.findById(id);
		return obj.get();
	}
}
