package com.xavier.creativepos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativepos.api.model.Produto;
import com.xavier.creativepos.api.repository.helper.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

}
