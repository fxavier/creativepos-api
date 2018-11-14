package com.xavier.creativepos.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xavier.creativepos.api.event.RecursoCriadoEvent;
import com.xavier.creativepos.api.model.Banco;
import com.xavier.creativepos.api.repository.BancoRepository;
import com.xavier.creativepos.api.service.BancoService;


@RestController
@RequestMapping("/bancos")
@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200" })
public class BancoResource {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private BancoService bancoService;
	
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
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		bancoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Banco> actualizar(@PathVariable Long codigo, @Valid @RequestBody Banco banco) {
		Banco foundBanco = bancoService.actualizar(codigo, banco);
		return ResponseEntity.ok(foundBanco);
	}

}
