package com.project.demospring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demospring.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	@GetMapping
	public ResponseEntity<Usuario> acharTodos(){
		Usuario u = new Usuario(1L, "Marcos", "marcos@gmail.com", "9999999", "123");
		return ResponseEntity.ok().body(u);
	}
}
