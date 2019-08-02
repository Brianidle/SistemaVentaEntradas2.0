package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Pelicula;

public interface MovieRepository extends JpaRepository<Pelicula, Integer>{
	
	public Pelicula findByNombre(String nombre);
	
}
