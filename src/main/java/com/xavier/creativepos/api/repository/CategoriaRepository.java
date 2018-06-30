package com.xavier.creativepos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xavier.creativepos.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
