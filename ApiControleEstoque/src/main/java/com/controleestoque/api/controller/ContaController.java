package com.controleestoque.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleestoque.domain.model.Conta;
import com.controleestoque.domain.repository.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;

	@GetMapping
	public List<Conta> listar(){
		// TODO fazer mais tarde !!
		return contaRepository.findAll();
		
	}
}
