package com.sistemaVentaEntrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Generos")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenero;
	@ManyToMany(mappedBy="generos")
	private List<Movie> peliculas;
	private String nombre;
	
	public Genre() {
	}
	
	public Genre(String nombre) {
		this.nombre=nombre;
	}
	
	public Integer getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Genre [idGenero=" + idGenero + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
