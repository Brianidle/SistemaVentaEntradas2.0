package com.sistemaVentaEntrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "Salas")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSala;
	//En un dia una sala da muchas funciones. Esto debe aparecer en la cartelera
	@OneToMany(mappedBy="sala")
	private List<CinemaFunction> funciones;
	@ManyToMany
	private List<Seat> asientos;
	//@Column(columnDefinition = "numSala int(2) not null zerofill")
	private Integer numSala;
	
	public Room() {}
	
	public Room(Integer numSala, List<Seat> asientos) {
		this.numSala=numSala;
		this.asientos=asientos;
	}

	public Integer getIdSala() {
		return idSala;
	}
	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	public List<Seat> getAsientos() {
		return asientos;
	}
	public void setAsientos(List<Seat> asientos) {
		this.asientos = asientos;
	}
	public List<CinemaFunction> getFunciones() {
		return funciones;
	}
	public void setFunciones(List<CinemaFunction> funciones) {
		this.funciones = funciones;
	}
	public Integer getNumSala() {
		return numSala;
	}
	public void setNumSala(Integer numSala) {
		this.numSala = numSala;
	}

}
