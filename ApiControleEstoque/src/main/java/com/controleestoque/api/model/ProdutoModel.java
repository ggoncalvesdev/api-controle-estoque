package com.controleestoque.api.model;

import java.math.BigDecimal;

import com.controleestoque.api.model.input.CategoriaInput;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoModel {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private Long quantidade;
	private String descricao;
	private CategoriaInput categoria;
		
}
