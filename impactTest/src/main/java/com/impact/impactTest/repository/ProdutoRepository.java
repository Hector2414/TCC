package com.impact.impactTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impact.impactTest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
