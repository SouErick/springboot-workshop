package com.project.demospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.demospring.entities.Categoria;
import com.project.demospring.entities.Ordem;
import com.project.demospring.entities.Usuario;
import com.project.demospring.entities.enums.StatusOrdem;
import com.project.demospring.repositories.RepositorioCategoria;
import com.project.demospring.repositories.RepositorioOrdem;
import com.project.demospring.repositories.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioOrdem repositorioOrdem;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria categoria1 = new Categoria(null, "Eletronicos");
		Categoria categoria2 = new Categoria(null, "Livros");
		Categoria categoria3 = new Categoria(null, "Computadores");
		
		Usuario u1 = new Usuario(null, "Erick", "erick@gmail.com", "999999999", "5678");
		Usuario u2 = new Usuario(null, "Andrea", "andrea@hotmail.com", "912345678", "4232");
		
		Ordem o1 = new Ordem(null, Instant.parse("2024-05-20T18:23:02Z"), StatusOrdem.PAGO, u1);
		Ordem o2 = new Ordem(null, Instant.parse("2024-02-21T20:43:10Z"), StatusOrdem.CANCELADO, u2);
		Ordem o3 = new Ordem(null, Instant.parse("2024-04-22T04:12:30Z"), StatusOrdem.PAGAMENTO_EM_ESPERA, u1);
			
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioOrdem.saveAll(Arrays.asList(o1, o2, o3));
		repositorioCategoria.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
	}
	
}
