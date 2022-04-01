package com.controleestoque.api.model;

import com.controleestoque.domain.model.Categoria;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoModel {

	private Long id;
	private String nome;
	private String tamanho;
	private Categoria categoria;
		
}
