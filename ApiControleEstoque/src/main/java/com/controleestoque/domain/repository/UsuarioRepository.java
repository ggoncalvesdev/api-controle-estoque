package com.controleestoque.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.controleestoque.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login);
	
}