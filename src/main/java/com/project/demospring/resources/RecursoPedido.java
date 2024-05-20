package com.project.demospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demospring.entities.Pedido;
import com.project.demospring.services.ServicosPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoPedido {
	@Autowired
	private ServicosPedido servico;
	@GetMapping
	public ResponseEntity<List<Pedido>> acharTodos(){
		List<Pedido> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> acharPorId(@PathVariable Long id){
		Pedido obj = servico.acharPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
