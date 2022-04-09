package com.controleestoque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.controleestoque.domain.model.Categoria;

public class CadastroCategoriaServiceTest {
	
	@Test
	void categoriaDeveriaCadastrar_QuandoNaoExistente( ) {
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria("tenis");
		 
		assertEquals("tenis", categoria.getNomeCategoria());
		
	}
	
}
