package com.controleestoque.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.controleestoque.domain.exception.CategoriaNaoEncontradaException;
import com.controleestoque.domain.exception.EntidadeEmUsoException;
import com.controleestoque.domain.exception.ProdutoNaoEncontradoException;
import com.controleestoque.domain.model.Categoria;
import com.controleestoque.domain.repository.CategoriaRepository;

@Service
public class CadastroCategoriaService {
	
	private static final String MSG_CADASTRO_EM_USO 
	= "Cadastro de código %d não pode ser removido, pois está em uso";


	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional
	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public void excluir(Long categoriaId) {
		try {
			categoriaRepository.deleteById(categoriaId);
			categoriaRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new CategoriaNaoEncontradaException(categoriaId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_CADASTRO_EM_USO, categoriaId));
		}
	}
	
	public Categoria buscarOuFalhar(Long categoriaId) {
		return categoriaRepository.findById(categoriaId)
			.orElseThrow(() -> new ProdutoNaoEncontradoException(categoriaId));
	}
	
}
