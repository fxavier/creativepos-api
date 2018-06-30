package com.xavier.creativepos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativepos.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
