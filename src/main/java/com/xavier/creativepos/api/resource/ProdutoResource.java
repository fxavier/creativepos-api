package com.xavier.creativepos.api.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.xavier.creativepos.api.model.Produto;
import com.xavier.creativepos.api.repository.ProdutoRepository;
import com.xavier.creativepos.api.repository.filter.ProdutoFilter;
import com.xavier.creativepos.api.repository.projection.ResumoProduto;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(maxAge = 10, origins = { "http://localhost:4200" })
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Produto> produto = produtoRepository.findById(codigo);
		return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
			
	}
	
	@GetMapping
	public Page<Produto> pesquisar(ProdutoFilter produtoFilter, Pageable pageable) {
		return produtoRepository.filtrar(produtoFilter, pageable);
	}
	
	@GetMapping(params = "resumo")
	public Page<ResumoProduto> resumir(ProdutoFilter produtoFilter, Pageable pageable) {
		return produtoRepository.resumir(produtoFilter, pageable);
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		Produto produtoCriado = produtoRepository.save(produto);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoCriado.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
	}

}








