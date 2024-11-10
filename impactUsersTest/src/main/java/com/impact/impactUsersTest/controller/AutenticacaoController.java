package com.impact.impactUsersTest.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.impact.impactUsersTest.model.Papel;
import com.impact.impactUsersTest.model.Produto;
import com.impact.impactUsersTest.model.Usuario;
import com.impact.impactUsersTest.repository.PapelRepository;
import com.impact.impactUsersTest.repository.ProdutoRepository;
import com.impact.impactUsersTest.repository.UsuarioRepository;



@Controller
public class AutenticacaoController {

	@Autowired
	private BCryptPasswordEncoder encodeSenha;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/login")
	public String login() {
		return"login";
	}
	
	
	
	@GetMapping("/registrar")
	public String registrar(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return"registrar";
	}
	
	@PostMapping("/registrar")
	public String registrarUsuario(@ModelAttribute Usuario usuario, Model modelo) {
		if(usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario()) != null) {
			modelo.addAttribute("menssagem", "Nome do usuário já existe");
			return"registrar";
		} 
		usuario.setSenha(encodeSenha.encode(usuario.getSenha()));
		Papel papelUsuario = papelRepository.findByNomePapel("ROLER_USER");
		usuario.getPapeis().add(papelUsuario);
		usuarioRepository.save(usuario);
		
		return"login";
	}
	
	
	
	
	@GetMapping("/home")
	public String home(Model modelo) {
		List<Produto> produtos = produtoRepository.findAll();
	        modelo.addAttribute("produtos", produtos);
		return"home";
	}
	
	
}
