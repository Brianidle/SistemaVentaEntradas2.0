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

@Entity(name = "cinemafunctions")
public class CinemaFunction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCinemaFunction;
	//Salas en las que se da la funcion, ya que en un dia puede darse una funcion en mas de una sala
	@ManyToOne
	private Room room;
	@ManyToOne
	private Movie movie;
	@OneToMany(mappedBy="cinemaFunction")
	private List<Ticket> tickets;
	
	private LocalDate date;
	private LocalTime time;
	
	public CinemaFunction() {}

	public Integer getIdCinemaFunction() {
		return idCinemaFunction;
	}

	public void setIdCinemaFunction(Integer idCinemaFunction) {
		this.idCinemaFunction = idCinemaFunction;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CinemaFunction [idCinemaFunction=" + idCinemaFunction + ", room=" + room + ", movie=" + movie
				+ ", date=" + date + ", time=" + time + "]";
	}

}
