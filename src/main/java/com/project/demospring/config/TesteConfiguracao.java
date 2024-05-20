package com.project.demospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.demospring.entities.Categoria;
import com.project.demospring.entities.Pagamento;
import com.project.demospring.entities.Pedido;
import com.project.demospring.entities.PedidoDoProduto;
import com.project.demospring.entities.Produto;
import com.project.demospring.entities.Usuario;
import com.project.demospring.entities.enums.StatusPedido;
import com.project.demospring.repositories.RepositorioCategoria;
import com.project.demospring.repositories.RepositorioPedido;
import com.project.demospring.repositories.RepositorioPedidoDoProduto;
import com.project.demospring.repositories.RepositorioProduto;
import com.project.demospring.repositories.RepositorioUsuario;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner{
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	@Autowired
	private RepositorioProduto repositorioProduto;
	
	@Autowired
	private RepositorioPedidoDoProduto repositorioPedidoDoProduto;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria categoria1 = new Categoria(null, "Eletronicos");
		Categoria categoria2 = new Categoria(null, "Livros");
		Categoria categoria3 = new Categoria(null, "Computadores");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		repositorioCategoria.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		repositorioProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategorias().add(categoria2);
		p2.getCategorias().add(categoria1);
		p2.getCategorias().add(categoria3);
		p3.getCategorias().add(categoria3);
		p4.getCategorias().add(categoria3);
		p5.getCategorias().add(categoria2);
		repositorioProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Usuario u1 = new Usuario(null, "Erick", "erick@gmail.com", "999999999", "5678");
		Usuario u2 = new Usuario(null, "Andrea", "andrea@hotmail.com", "912345678", "4232");
		
		Pedido o1 = new Pedido(null, Instant.parse("2024-05-20T18:23:02Z"), StatusPedido.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2024-02-21T20:43:10Z"), StatusPedido.CANCELADO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2024-04-22T04:12:30Z"), StatusPedido.PAGAMENTO_EM_ESPERA, u1);
			
		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioPedido.saveAll(Arrays.asList(o1, o2, o3));
	
		PedidoDoProduto oi1 = new PedidoDoProduto(o1, p1, 2, p1.getPreco()); 
		PedidoDoProduto oi2 = new PedidoDoProduto(o1, p3, 1, p3.getPreco()); 
		PedidoDoProduto oi3 = new PedidoDoProduto(o2, p3, 2, p3.getPreco()); 
		PedidoDoProduto oi4 = new PedidoDoProduto(o3, p5, 2, p5.getPreco()); 
		repositorioPedidoDoProduto.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Pagamento pagamento1 = new Pagamento(null, Instant.parse("2024-05-20T18:23:02Z"), o1);
		o1.setPagamento(pagamento1);
		
		repositorioPedido.save(o1);
	}
	
}
