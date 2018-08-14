package com.xavier.creativepos.api.repository.helper.banco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xavier.creativepos.api.model.Banco;
import com.xavier.creativepos.api.repository.filter.BancoFilter;

public interface BancoRepositoryQueries {
	
	public Page<Banco> filtrar(BancoFilter bancoFilter, Pageable pageable);

}
