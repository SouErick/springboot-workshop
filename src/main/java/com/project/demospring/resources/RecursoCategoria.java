package com.project.demospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demospring.entities.Categoria;
import com.project.demospring.services.ServicosCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursoCategoria {
	@Autowired
	private ServicosCategoria servico;
	@GetMapping
	public ResponseEntity<List<Categoria>> acharTodos(){
		List<Categoria> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> acharPorId(@PathVariable Long id){
		Categoria obj = servico.acharPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
