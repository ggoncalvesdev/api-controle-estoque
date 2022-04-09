package com.controleestoque.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controleestoque.api.assembler.ProdutoInputDisassembler;
import com.controleestoque.api.assembler.ProdutoModelAssembler;
import com.controleestoque.api.model.ProdutoModel;
import com.controleestoque.api.model.input.ProdutoInput;
import com.controleestoque.domain.model.Produto;
import com.controleestoque.domain.repository.ProdutoRepository;
import com.controleestoque.domain.service.CadastroProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoModelAssembler produtoModelAssembler;
	
	@Autowired
	private ProdutoInputDisassembler produtoInputDisassembler;
	
	@Autowired
	private CadastroProdutoService cadastroProduto;

	@GetMapping
	public Page<ProdutoModel> listar(@PageableDefault(size = 10) Pageable pageable) {
		Page<Produto> produtoPage = produtoRepository.findAll(pageable);
		
		List<ProdutoModel> produtosModel = produtoModelAssembler
				.toCollectionModel(produtoPage.getContent());
		
		Page<ProdutoModel> produtosModelPage = new PageImpl<>(produtosModel, pageable, 
				produtoPage.getTotalElements());
		
		return produtosModelPage;
	}
	
	@GetMapping("/{produtoId}")
	public ProdutoModel buscar(@PathVariable Long produtoId) {
		Produto produto = cadastroProduto.buscarOuFalhar(produtoId);
		
		return produtoModelAssembler.toModel(produto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoModel adicionar(@RequestBody @Valid ProdutoInput produtoInput) {
		Produto produto = produtoInputDisassembler.toDomainObject(produtoInput);
		produto = cadastroProduto.salvar(produto);
		
		return produtoModelAssembler.toModel(produto);
	}
	
	@PutMapping("/{produtoId}")
	public ProdutoModel atualizar(@PathVariable Long produtoId,
			@RequestBody @Valid ProdutoInput produtoInput) {
		Produto produtoAtual = cadastroProduto.buscarOuFalhar(produtoId);
		produtoInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);
		produtoAtual = cadastroProduto.salvar(produtoAtual);
		
		return produtoModelAssembler.toModel(produtoAtual);
	}
	
	@DeleteMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long produtoId) {
		cadastroProduto.excluir(produtoId);
	}
}
