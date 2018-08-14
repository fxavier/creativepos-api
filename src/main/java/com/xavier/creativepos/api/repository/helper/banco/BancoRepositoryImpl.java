package com.xavier.creativepos.api.repository.helper.banco;

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

import com.xavier.creativepos.api.model.Banco;
import com.xavier.creativepos.api.model.Banco_;
import com.xavier.creativepos.api.repository.filter.BancoFilter;

public class BancoRepositoryImpl implements BancoRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Banco> filtrar(BancoFilter bancoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Banco> criteria = builder.createQuery(Banco.class);
		
		Root<Banco> root = criteria.from(Banco.class);
		
		Predicate[] predicates = criarRestricoes(bancoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Banco> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(bancoFilter));
	}

	private Long total(BancoFilter bancoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Banco> root = criteria.from(Banco.class);
		
		Predicate[] predicates = criarRestricoes(bancoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Banco> query, Pageable pageable) {
		int paginaActual = pageable.getPageNumber();
		int totalRegistosPorPagina = pageable.getPageSize();
		int primeiroRegistoDaPagina = paginaActual * totalRegistosPorPagina;
		
		query.setFirstResult(primeiroRegistoDaPagina);
		query.setMaxResults(totalRegistosPorPagina);
		
	}

	private Predicate[] criarRestricoes(BancoFilter bancoFilter, CriteriaBuilder builder, Root<Banco> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(bancoFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Banco_.nome)),
					"%" + bancoFilter.getNome().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
