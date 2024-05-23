package com.project.demospring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.demospring.entities.Usuario;
import com.project.demospring.services.ServicosUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	@Autowired
	private ServicosUsuario servico;
	@GetMapping
	public ResponseEntity<List<Usuario>> acharTodos(){
		List<Usuario> lista = servico.acharTodos();
		return ResponseEntity.ok().body(lista);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> acharPorId(@PathVariable Long id){
		Usuario obj = servico.acharPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj){
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		servico.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
