package com.controleestoque.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controleestoque.api.model.CategoriaModel;
import com.controleestoque.domain.model.Categoria;

@Component
public class CategoriaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CategoriaModel toModel(Categoria categoria) {
		return modelMapper.map(categoria, CategoriaModel.class);
	}
	
	public List<CategoriaModel> toCollectionModel(Collection<Categoria> categorias) {
		return categorias.stream()
				.map(categoria -> toModel(categoria))
				.collect(Collectors.toList());
	}
		
}
