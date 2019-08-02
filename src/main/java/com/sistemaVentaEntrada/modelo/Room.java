package com.sistemaVentaEntrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "rooms")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomNumber;
	//En un dia una sala da muchas funciones. Esto debe aparecer en la cartelera
	@OneToMany(mappedBy="room")
	private List<CinemaFunction> cinemaFunctions;
	@ManyToMany
	private List<Seat> seats;
	
	public Room() {}

	public Room(Integer roomNumber, List<Seat> seats) {
		this.roomNumber = roomNumber;
		this.seats = seats;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	
}
