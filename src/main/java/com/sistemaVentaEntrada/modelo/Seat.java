package com.sistemaVentaEntrada.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "seats")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSeat;
	@ManyToMany(mappedBy = "seats")
	private List<Room> rooms;
	@OneToMany(mappedBy="seat")
	private List<Ticket> tickets;
	
	private char rowSeat;
	private Integer number;
	
	public Integer getIdSeat() {
		return idSeat;
	}

	public void setIdSeat(Integer idSeat) {
		this.idSeat = idSeat;
	}

	public char getRowSeat() {
		return rowSeat;
	}

	public void setRowSeat(char rowSeat) {
		this.rowSeat = rowSeat;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	
}
