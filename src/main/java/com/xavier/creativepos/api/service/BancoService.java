package com.xavier.creativepos.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.xavier.creativepos.api.model.Banco;
import com.xavier.creativepos.api.repository.BancoRepository;

@Service
public class BancoService {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	public Banco actualizar(Long codigo, Banco banco) {
		Banco foundBanco = bancoRepository.getOne(codigo);
		if(foundBanco == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(banco, foundBanco, "codigo");
		
		bancoRepository.save(foundBanco);
		
		return foundBanco;
	}

}
