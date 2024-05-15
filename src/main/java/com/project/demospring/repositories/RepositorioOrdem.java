package com.project.demospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demospring.entities.Ordem;

public interface RepositorioOrdem extends JpaRepository<Ordem, Long> {

}
