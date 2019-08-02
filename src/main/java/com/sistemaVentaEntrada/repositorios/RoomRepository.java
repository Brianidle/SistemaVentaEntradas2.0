package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Genre;
import com.sistemaVentaEntrada.modelo.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

	public Room findByNumSala(Integer numSala);
}
