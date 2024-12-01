package com.impact.impactUsersTest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.impact.impactUsersTest.model.Produto;

@Service
public class CarrinhoService {

	private final Map<Long, Produto> carrinho = new HashMap<>();

    public void removerProduto(Long produtoId) {
        carrinho.remove(produtoId);
    }

}
