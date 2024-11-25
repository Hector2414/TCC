package com.impact.impactUsersTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.impact.impactUsersTest.model.Role;
import com.impact.impactUsersTest.model.Usuario;
import com.impact.impactUsersTest.repository.ProdutoRepository;
import com.impact.impactUsersTest.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	

	
	@Bean
	CommandLineRunner executar() {
		
		return args ->{
			Usuario usuario = new Usuario();
			usuario.setNomeUsuario("admin");
			usuario.setSenha(new BCryptPasswordEncoder().encode("admin"));
			usuario.setRole(Role.ADMIN);
			usuarioRepository.save(usuario);
			
			Usuario usuario1 = new Usuario();
			usuario1.setNomeUsuario(null);
			usuario1.setSenha(new BCryptPasswordEncoder().encode("maria"));
			usuario1.setRole(Role.USER);
			
			usuarioRepository.save(usuario1);
			
		
			
		
		};
	}
}
