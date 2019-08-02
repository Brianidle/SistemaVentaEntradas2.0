package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Genre;
import com.sistemaVentaEntrada.modelo.Sala;

public interface RoomRepository extends JpaRepository<Sala, Integer> {

	public Sala findByNumSala(Integer numSala);
}
