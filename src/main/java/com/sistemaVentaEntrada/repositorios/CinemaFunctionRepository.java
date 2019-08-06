package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.CinemaFunction;

public interface CinemaFunctionRepository extends JpaRepository<CinemaFunction, Integer>{

	//findByRoomAndDateAndTime
}
