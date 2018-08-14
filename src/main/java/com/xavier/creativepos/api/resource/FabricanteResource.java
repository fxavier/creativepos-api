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
import com.xavier.creativepos.api.model.Fabricante;
import com.xavier.creativepos.api.repository.FabricanteRepository;

@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/fabricantes")
public class FabricanteResource {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Fabricante> pesquisar() {
		return fabricanteRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Fabricante> findByCodigo(@PathVariable Long codigo) {
		Optional<Fabricante> fabricante = fabricanteRepository.findById(codigo);
		
		return fabricante.isPresent() ? ResponseEntity.ok(fabricante.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Fabricante> criar(@Valid @RequestBody Fabricante fabricante, HttpServletResponse response) {
		Fabricante fabricanteCriado = fabricanteRepository.save(fabricante);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, fabricanteCriado.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteCriado);
	}

}
