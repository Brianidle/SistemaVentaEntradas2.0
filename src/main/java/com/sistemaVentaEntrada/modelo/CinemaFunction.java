package com.sistemaVentaEntrada.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Funciones")
public class CinemaFunction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFuncion;
	//Salas en las que se da la funcion, ya que en un dia puede darse una funcion en mas de una sala
	@ManyToOne
	private Room sala;
	@OneToMany(mappedBy="funcion")
	private List<Ticket> entradas;
	@ManyToOne
	private Movie pelicula;
	
	private LocalDate fecha;
	private LocalTime hora;
	
	public CinemaFunction() {}

	public CinemaFunction(LocalDate fecha, LocalTime hora, Movie pelicula, Room sala) {
		this.fecha = fecha;
		this.hora = hora;
		this.pelicula = pelicula;
		this.sala=sala;
	}
	
	public Integer getIdFuncion() {
		return idFuncion;
	}
	public void setIdFuncion(Integer idFuncion) {
		this.idFuncion = idFuncion;
	}
	public Room getSala() {
		return sala;
	}
	public void setSala(Room sala) {
		this.sala = sala;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Movie getPelicula() {
		return pelicula;
	}
	public void setPelicula(Movie pelicula) {
		this.pelicula = pelicula;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

}
