package com.impact.impactUsersTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.impact.impactUsersTest.model.Carrinho;
import com.impact.impactUsersTest.model.Produto;
import com.impact.impactUsersTest.service.CarrinhoService;
import com.impact.impactUsersTest.service.ProdutoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

	 private final Carrinho carrinho = new Carrinho();
	    private final ProdutoService produtoService;
	    
	    private final CarrinhoService carrinhoService;

	    public CarrinhoController(ProdutoService produtoService , CarrinhoService carrinhoService) {
	        this.produtoService = produtoService;
	        this.carrinhoService = carrinhoService;
	    }

	    @PostMapping("/adicionarCarrinho")
	    public String adicionarAoCarrinho(@RequestParam("produtoId") Long produtoId) {
	        Produto produto = produtoService.buscarPorId(produtoId);
	        if (produto != null) {
	            carrinho.adicionarProduto(produto);
	        }
	        return "redirect:/home";
	    }

	    @GetMapping
	    public String exibirCarrinho(Model modelo) {
	        modelo.addAttribute("itens", carrinho.getItens());
	        modelo.addAttribute("total", carrinho.calcularTotal());
	        return "carrinho";
	    }
	    
	    @PostMapping("/remover")
	    public String removerProduto(@RequestParam Long produtoId) {
	        carrinhoService.removerProduto(produtoId);
	        return "redirect:/carrinho";
	    }

	    @PostMapping("/finalizarCompra")
	    public String finalizarCompra() {
	        carrinho.limparCarrinho();
	        return "redirect:/home?compraFinalizada";
	    }
}
