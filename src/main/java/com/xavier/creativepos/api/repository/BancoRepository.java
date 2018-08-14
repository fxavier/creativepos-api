package com.xavier.creativepos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativepos.api.model.Banco;
import com.xavier.creativepos.api.repository.helper.banco.BancoRepositoryQueries;

public interface BancoRepository extends JpaRepository<Banco, Long>, BancoRepositoryQueries{

}
