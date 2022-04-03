package com.controleestoque.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String senha;
	
	@ManyToMany
	@Column(nullable = false)
	@JoinTable(name = "usuario_tipo", joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "tipo_usuario_id"))
	private Set<TipoUsuario> tipoUsuario = new HashSet<>();
	
	public boolean senhaCoincideCom(String senha) {
		return getSenha().equals(senha);
	}
	public boolean senhaNaoCoincideCom(String senha) {
		return !senhaCoincideCom(senha);
	}
	
	public boolean loginCoincideCom(String login) {
		return getLogin().equals(login);
	}
	public boolean loginNaoCoincideCom(String login) {
		return !loginCoincideCom(login);
	}
	
	public boolean removerTipo(TipoUsuario tipoUsuario) {
		return getTipoUsuario().remove(tipoUsuario);
	}
	public boolean adicionarTipo(TipoUsuario tipoUsuario) {
		return getTipoUsuario().add(tipoUsuario);
	}
	
}
