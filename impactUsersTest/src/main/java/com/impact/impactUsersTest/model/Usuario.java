package com.impact.impactUsersTest.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeUsuario;
	private String senha;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_papeis",
	                joinColumns = @JoinColumn(name = "usuario_id") ,
	                inverseJoinColumns = @JoinColumn(name = "papel_id"))
	private Set<Papel> papeis = new HashSet<Papel>();
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public Usuario() {
		
	}
	public Usuario(Long id, String nomeUsuario, String senha) {
		
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	public Set<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(Set<Papel> papeis) {
		this.papeis = papeis;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
}
