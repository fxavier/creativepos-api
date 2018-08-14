package com.xavier.creativepos.api.repository.helper.produto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.xavier.creativepos.api.model.Produto;
import com.xavier.creativepos.api.model.Produto_;
import com.xavier.creativepos.api.model.Unidade_;
import com.xavier.creativepos.api.repository.filter.ProdutoFilter;
import com.xavier.creativepos.api.repository.projection.ResumoProduto;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Produto> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(produtoFilter));
	}

	@Override
	public Page<ResumoProduto> resumir(ProdutoFilter produtoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoProduto> criteria = builder.createQuery(ResumoProduto.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		criteria.select(builder.construct(ResumoProduto.class
				       , root.get(Produto_.referencia), root.get(Produto_.codigoBarras)
				       , root.get(Produto_.nome), root.get(Produto_.stockActual)
				       , root.get(Produto_.precovenda), root.get(Produto_.unidade).get(Unidade_.designacao)));
		
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoProduto> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(produtoFilter));
	}
	
	@Override
	public List<ResumoProduto> resumirProduto() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoProduto> criteria = builder.createQuery(ResumoProduto.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		criteria.select(builder.construct(ResumoProduto.class
				       , root.get(Produto_.referencia), root.get(Produto_.codigoBarras)
				       , root.get(Produto_.nome), root.get(Produto_.stockActual)
				       , root.get(Produto_.precovenda), root.get(Produto_.unidade).get(Unidade_.designacao)));
		
		TypedQuery<ResumoProduto> query = manager.createQuery(criteria);
		return query.getResultList();
	}
	
	private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder, Root<Produto> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(produtoFilter.getReferencia())) {
			predicates.add(builder.like(
					builder.lower(root.get(Produto_.referencia)), 
					"%" + produtoFilter.getReferencia().toLowerCase() + "%"));
		}
		
		if(!StringUtils.isEmpty(produtoFilter.getCodigoBarras())) {
			predicates.add(builder.equal(root.get(Produto_.codigoBarras), produtoFilter.getCodigoBarras()));
		}
		
		if(!StringUtils.isEmpty(produtoFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.nome)), 
					"%" + produtoFilter.getNome().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaActual = pageable.getPageNumber();
		int totalRegistosPorPagina = pageable.getPageSize();
		int primeiroRegistoDaPagina = paginaActual * totalRegistosPorPagina;
		
		query.setFirstResult(primeiroRegistoDaPagina);
		query.setMaxResults(totalRegistosPorPagina);
		
	}


	private Long total(ProdutoFilter produtoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


	

}
