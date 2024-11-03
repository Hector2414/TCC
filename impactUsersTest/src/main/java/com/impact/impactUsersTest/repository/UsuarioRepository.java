package com.impact.impactUsersTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impact.impactUsersTest.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByNomeUsuario(String nomeUsuario);
}
