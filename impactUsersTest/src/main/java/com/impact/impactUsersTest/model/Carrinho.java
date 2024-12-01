package com.impact.impactUsersTest.model;

import java.util.ArrayList;
import java.util.List;




public class Carrinho {

	  private List<Produto> itens = new ArrayList<>();

	    public List<Produto> getItens() {
	        return itens;
	    }

	    public void adicionarProduto(Produto produto) {
	        itens.add(produto);
	    }

	    public void removerProduto(Produto produto) {
	        itens.remove(produto);
	    }

	    public void limparCarrinho() {
	        itens.clear();
	    }

	    public Double calcularTotal() {
	        return itens.stream().mapToDouble(Produto::getPreco).sum();
	    }
	}

