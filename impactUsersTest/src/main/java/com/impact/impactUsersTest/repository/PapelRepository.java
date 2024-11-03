package com.impact.impactUsersTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impact.impactUsersTest.model.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long>{

	Papel findByNomePapel (String nomePapel);
}
