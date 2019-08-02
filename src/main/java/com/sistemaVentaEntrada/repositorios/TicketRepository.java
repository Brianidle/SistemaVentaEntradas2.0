package com.sistemaVentaEntrada.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaVentaEntrada.modelo.Ticket;
import com.sistemaVentaEntrada.modelo.Genre;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
