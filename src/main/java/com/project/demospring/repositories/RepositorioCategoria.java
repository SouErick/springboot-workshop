package com.project.demospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demospring.entities.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
