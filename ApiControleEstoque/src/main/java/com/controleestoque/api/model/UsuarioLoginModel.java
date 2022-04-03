package com.controleestoque.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLoginModel {
	
	private Long id;
	private String login;
	private String senha;

}
