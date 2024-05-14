package com.project.demospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demospring.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
