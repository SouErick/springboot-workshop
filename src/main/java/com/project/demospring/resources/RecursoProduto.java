package com.project.demospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demospring.entities.Produto;
import com.project.demospring.services.ServicosProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {
	@Autowired
	private ServicosProduto servico;
	@GetMapping
	public ResponseEntity<List<Produto>> acharTodos(){
		List<Produto> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> acharPorId(@PathVariable Long id){
		Produto obj = servico.acharPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
