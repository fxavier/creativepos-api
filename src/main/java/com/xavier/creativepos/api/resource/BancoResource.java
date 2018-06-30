package com.xavier.creativepos.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativepos.api.event.RecursoCriadoEvent;
import com.xavier.creativepos.api.model.Banco;
import com.xavier.creativepos.api.repository.BancoRepository;

@RestController
@RequestMapping("/bancos")
public class BancoResource {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Banco> pesquisar(){
		return bancoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Banco> criar(@Valid @RequestBody Banco banco, HttpServletResponse response) {
		Banco bancoCriado = bancoRepository.save(banco);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, bancoCriado.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(bancoCriado);
	}

}
