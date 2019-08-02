package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{
	 
	public Genre findByName(String name);
}
