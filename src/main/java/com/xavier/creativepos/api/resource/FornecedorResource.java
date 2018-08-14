package com.xavier.creativepos.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativepos.api.model.Fornecedor;
import com.xavier.creativepos.api.repository.FornecedorRepository;

@CrossOrigin(maxAge = 10, origins = { "*" })
@RestController
@RequestMapping("/fornecedores")
public class FornecedorResource {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@GetMapping
	public List<Fornecedor> pesquisar() {
		return fornecedorRepository.findAll();
	}

}
