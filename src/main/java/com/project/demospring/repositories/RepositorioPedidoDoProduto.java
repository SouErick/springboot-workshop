package com.project.demospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demospring.entities.PedidoDoProduto;
import com.project.demospring.entities.pk.PedidoPK;

public interface RepositorioPedidoDoProduto extends JpaRepository<PedidoDoProduto, PedidoPK> {

}