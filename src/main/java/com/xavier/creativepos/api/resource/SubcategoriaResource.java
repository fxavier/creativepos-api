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
import com.xavier.creativepos.api.model.Subcategoria;
import com.xavier.creativepos.api.repository.SubcategoriaRepository;

@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaResource {
	
	@Autowired
	private SubcategoriaRepository subcategoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Subcategoria> pesquisar() {
		return subcategoriaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Subcategoria> findById(@PathVariable Long codigo) {
		Optional<Subcategoria> subcategoriaAchada = subcategoriaRepository.findById(codigo);
		
		return subcategoriaAchada.isPresent() ? ResponseEntity.ok(subcategoriaAchada.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Subcategoria> criar(@Valid @RequestBody Subcategoria subcategoria, HttpServletResponse response) {
		Subcategoria subcategoriaCriada = subcategoriaRepository.save(subcategoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, subcategoriaCriada.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(subcategoriaCriada);
	}

}
