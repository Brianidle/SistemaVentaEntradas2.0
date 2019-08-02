package com.sistemaVentaEntrada.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Entradas")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEntrada;
	@ManyToOne
	private CinemaFunction funcion;
	@ManyToOne
	private User usuario;
	
	public Ticket() {}
	
	public Ticket(CinemaFunction funcion, User usuario) {
		this.funcion=funcion;
		this.usuario=usuario;
	}
	
	public Integer getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}
	public CinemaFunction getFuncion() {
		return funcion;
	}
	public void setFuncion(CinemaFunction funcion) {
		this.funcion = funcion;
	}

	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	
}
