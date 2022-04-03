package com.controleestoque.api.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoModel {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private String descricao;
		
}
