package com.project.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demospring.entities.Pedido;
import com.project.demospring.repositories.RepositorioPedido;
@Service
public class ServicosPedido {
	@Autowired
	private RepositorioPedido repositorio;
	public List<Pedido> acharTodos(){
		return repositorio.findAll();
	}
	public Pedido acharPorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
