package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.CinemaFunction;
import com.sistemaVentaEntrada.modelo.Genre;

public interface MovieFunctionRepository extends JpaRepository<CinemaFunction, Integer>{

}
