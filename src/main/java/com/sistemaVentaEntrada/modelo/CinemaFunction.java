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
	private Sala sala;
	@OneToMany(mappedBy="funcion")
	private List<Ticket> entradas;
	@ManyToOne
	private Pelicula pelicula;
	
	private LocalDate fecha;
	private LocalTime hora;
	
	public CinemaFunction() {}

	public CinemaFunction(LocalDate fecha, LocalTime hora, Pelicula pelicula, Sala sala) {
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
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

}
