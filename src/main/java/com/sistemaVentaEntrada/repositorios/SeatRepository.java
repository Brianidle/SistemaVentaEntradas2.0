package com.sistemaVentaEntrada.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer>{

	public Seat findByFilaAndNumero(char fila, Integer numero);
}
