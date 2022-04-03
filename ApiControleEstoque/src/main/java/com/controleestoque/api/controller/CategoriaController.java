package com.controleestoque.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controleestoque.api.assembler.CategoriaInputDisassembler;
import com.controleestoque.api.assembler.CategoriaModelAssembler;
import com.controleestoque.api.model.CategoriaModel;
import com.controleestoque.api.model.input.CategoriaInput;
import com.controleestoque.domain.model.Categoria;
import com.controleestoque.domain.repository.CategoriaRepository;
import com.controleestoque.domain.service.CadastroCategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaModelAssembler categoriaModelAssembler;
	
	@Autowired
	private CadastroCategoriaService cadastroCategoria;
	
	@Autowired
	private CategoriaInputDisassembler cadastroInputDisassembler;

	@GetMapping
	public List<CategoriaModel> listar() {
		List<Categoria> todasCategorias = categoriaRepository.findAll();
		
		return categoriaModelAssembler.toCollectionModel(todasCategorias);
		
	}
	
	@GetMapping("/{categoriaId}")
	public CategoriaModel buscar(@PathVariable Long categoriaId) {
		Categoria categoria = cadastroCategoria.buscarOuFalhar(categoriaId);
		
		return categoriaModelAssembler.toModel(categoria);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaModel adicionar(@RequestBody @Valid CategoriaInput categoriaInput) {
		Categoria categoria = cadastroInputDisassembler.toDoMainObject(categoriaInput);
		categoria = cadastroCategoria.salvar(categoria);
		
		return categoriaModelAssembler.toModel(categoria);
	}
	
	@DeleteMapping("/{categoriaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long categoriaId) {
		cadastroCategoria.excluir(categoriaId);
	}
}
