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
import com.xavier.creativepos.api.model.Moeda;
import com.xavier.creativepos.api.repository.MoedaRepository;

@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/moedas")
public class MoedaResource {
	
	@Autowired
	private MoedaRepository moedaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public List<Moeda> pesquisar() {
		return moedaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Moeda> findByCodigo(@PathVariable Long codigo) {
		Optional<Moeda> moeda = moedaRepository.findById(codigo);
		return moeda.isPresent() ? ResponseEntity.ok(moeda.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Moeda> criar(@Valid @RequestBody Moeda moeda, HttpServletResponse response) {
		Moeda moedaCriada = moedaRepository.save(moeda);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, moedaCriada.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(moedaCriada);
	}

}
