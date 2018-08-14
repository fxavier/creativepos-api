package com.xavier.creativepos.api.repository.helper.produto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xavier.creativepos.api.model.Produto;
import com.xavier.creativepos.api.repository.filter.ProdutoFilter;
import com.xavier.creativepos.api.repository.projection.ResumoProduto;

public interface ProdutoRepositoryQuery {
	public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);
	public Page<ResumoProduto> resumir(ProdutoFilter produtoFilter, Pageable pageable);
	public List<ResumoProduto> resumirProduto();
 
}
