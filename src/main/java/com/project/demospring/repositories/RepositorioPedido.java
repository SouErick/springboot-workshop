package com.project.demospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demospring.entities.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

}
