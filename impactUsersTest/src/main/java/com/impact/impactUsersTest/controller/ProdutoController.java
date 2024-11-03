package com.impact.impactUsersTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.impact.impactUsersTest.model.Produto;
import com.impact.impactUsersTest.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	 @Autowired
	    private ProdutoService produtoService;

	    @GetMapping
	    public String listar(Model modelo) {
	        List<Produto> produtos = produtoService.listarTodos();
	        modelo.addAttribute("produtos", produtos);
	        return "lista";
	    }

	    @GetMapping("/novo")
	    public String novoProdutoForm(Model modelo) {
	        modelo.addAttribute("produto", new Produto());
	        return "form";
	    }

	    @PostMapping
	    public String salvar(@ModelAttribute Produto produto) {
	        produtoService.salvar(produto);
	        return "redirect:/produtos";
	    }
/*
	    @GetMapping("/editar/{id}")
	    public String editarProdutoForm(@PathVariable Long id, Model modelo) {
	        Produto produto = produtoService.buscarPorId(id);
	        modelo.addAttribute("produto", produto);
	        
	        return "form";
	    }

	    @PostMapping("/editar/{id}")
	    public String editar(@PathVariable Long id, @ModelAttribute Produto produto) {
	        produto.setId(id);
	        produtoService.salvar(produto);
	        return "redirect:/produtos";
	    }*/

	    @GetMapping("/excluir/{id}")
	    public String excluir(@PathVariable Long id) {
	        produtoService.excluir(id);
	        return "redirect:/produtos";
	    }
}
