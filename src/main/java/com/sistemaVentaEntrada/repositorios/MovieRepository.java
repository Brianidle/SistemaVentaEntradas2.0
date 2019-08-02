package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	public Movie findByNombre(String nombre);
	
}
