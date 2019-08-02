package com.sistemaVentaEntrada.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTicket;
	@ManyToOne
	private CinemaFunction cinemaFunction;
	@ManyToOne
	private User user;
	

	public Integer getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public CinemaFunction getCinemaFunction() {
		return cinemaFunction;
	}

	public void setCinemaFunction(CinemaFunction cinemaFunction) {
		this.cinemaFunction = cinemaFunction;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
