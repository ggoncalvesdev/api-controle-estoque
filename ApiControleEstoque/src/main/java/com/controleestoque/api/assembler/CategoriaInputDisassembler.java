package com.controleestoque.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controleestoque.api.model.input.CategoriaInput;
import com.controleestoque.domain.model.Categoria;

@Component
public class CategoriaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Categoria toDoMainObject(CategoriaInput categoriaInput) {
			return modelMapper.map(categoriaInput, Categoria.class);
	}

}
