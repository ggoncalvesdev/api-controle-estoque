package com.controleestoque.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controleestoque.domain.exception.ProdutoNaoEncontradoException;
import com.controleestoque.domain.model.Produto;
import com.controleestoque.domain.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto buscarOuFalhar(Long produtoId) {
		return produtoRepository.findById(produtoId)
			.orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));
	}
	
}
