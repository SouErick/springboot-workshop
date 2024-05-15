package com.project.demospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demospring.entities.Ordem;
import com.project.demospring.services.ServicosOrdem;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursoOrdem {
	@Autowired
	private ServicosOrdem servico;
	@GetMapping
	public ResponseEntity<List<Ordem>> acharTodos(){
		List<Ordem> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ordem> acharPorId(@PathVariable Long id){
		Ordem obj = servico.acharPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
