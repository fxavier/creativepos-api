package com.xavier.creativepos.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativepos.api.event.RecursoCriadoEvent;
import com.xavier.creativepos.api.model.Unidade;
import com.xavier.creativepos.api.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidades")
@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200" }) 
public class UnidadeResource {
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Unidade> pesquisar(){
		return unidadeRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Unidade> criar(@Valid @RequestBody Unidade unidade, HttpServletResponse response) {
		Unidade unidadeCriada = unidadeRepository.save(unidade);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, unidadeCriada.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(unidadeCriada);
	}

}
