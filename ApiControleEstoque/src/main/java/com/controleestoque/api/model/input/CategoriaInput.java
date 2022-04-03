package com.controleestoque.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaInput {
	
	@NotBlank
	private String nomeCategoria;

}
