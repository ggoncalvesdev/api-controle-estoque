package com.controleestoque.domain.exception;

public class CategoriaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CategoriaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CategoriaNaoEncontradaException(Long categoriaId) {
		this(String.format("Não existe um cadastro de categoria com código %d", categoriaId));
	}

}
