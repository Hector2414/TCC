package com.impact.impactUsersTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impact.impactUsersTest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findAll();

}
