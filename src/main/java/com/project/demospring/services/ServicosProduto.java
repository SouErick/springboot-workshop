package com.project.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demospring.entities.Produto;
import com.project.demospring.repositories.RepositorioProduto;
@Service
public class ServicosProduto {
	@Autowired
	private RepositorioProduto repositorio;
	public List<Produto> acharTodos(){
		return repositorio.findAll();
	}
	public Produto acharPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
}
