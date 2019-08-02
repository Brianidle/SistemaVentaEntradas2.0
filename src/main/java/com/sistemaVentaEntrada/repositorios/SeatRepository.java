package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer>{

	public Seat findByRowSeatAndNumber(char rowSeat, Integer number);
}
