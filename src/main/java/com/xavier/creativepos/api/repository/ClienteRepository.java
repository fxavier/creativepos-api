package com.xavier.creativepos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativepos.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
