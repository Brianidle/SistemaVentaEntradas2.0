package com.sistemaVentaEntrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "Peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPelicula;
	private String nombre;
	@ManyToMany
	private List<Genre> generos;
	@OneToMany(mappedBy="pelicula")
	private List<CinemaFunction> funciones;
	
	public Pelicula() {}
	
	public Pelicula(String nombre, List<Genre> generos) {
		this.nombre=nombre;
		this.generos=generos;
	}
	
	public Integer getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}
	public List<Genre> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genre> generos) {
		this.generos = generos;
	}
	public List<CinemaFunction> getFuncion() {
		return funciones;
	}
	public void setFuncion(List<CinemaFunction> funciones) {
		this.funciones = funciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
