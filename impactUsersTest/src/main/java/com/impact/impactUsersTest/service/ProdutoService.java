package com.impact.impactUsersTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.impactUsersTest.model.Produto;
import com.impact.impactUsersTest.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
    private ProdutoRepository produtoRepository;
	
	public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
	
	public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }

	 public Produto buscarPorId(Long id) {
	        return produtoRepository.findById(id).orElse(null);
	    }
	 

	    public void excluir(Long id) {
	        produtoRepository.deleteById(id);
	    }
}