package com.project.demospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demospring.entities.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {

}
