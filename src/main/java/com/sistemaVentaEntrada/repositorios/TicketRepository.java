package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Seat;
import com.sistemaVentaEntrada.modelo.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	public Ticket findBySeat(Seat seat);
}
