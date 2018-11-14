package com.xavier.creativepos.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativepos.api.event.RecursoCriadoEvent;
import com.xavier.creativepos.api.model.Fornecedor;
import com.xavier.creativepos.api.repository.FornecedorRepository;

@CrossOrigin(maxAge = 10, origins = { "*" })
@RestController
@RequestMapping("/fornecedores")
public class FornecedorResource {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Fornecedor> pesquisar() {
		return fornecedorRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Fornecedor> findByCodigo(@PathVariable Long codigo) {
		Optional<Fornecedor> fornecedorAchado = fornecedorRepository.findById(codigo);
		
		return fornecedorAchado.isPresent() ? ResponseEntity.ok(fornecedorAchado.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> criar(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response) {
		Fornecedor fornecedorCriado = fornecedorRepository.save(fornecedor);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, fornecedorCriado.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorCriado);
	}

}
