package com.project.demospring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.demospring.entities.Usuario;
import com.project.demospring.repositories.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario(null, "Erick", "erick@gmail.com", "999999999", "5678");
		Usuario u2 = new Usuario(null, "Andrea", "andrea@hotmail.com", "912345678", "4232");
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
	}
	
}
