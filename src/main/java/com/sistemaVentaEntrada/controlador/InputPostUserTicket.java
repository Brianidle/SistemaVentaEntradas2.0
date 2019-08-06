package com.sistemaVentaEntrada.controlador;

public class InputPostUserTicket {

	private String nickname;
	private char rowSeat;
	private Integer seatNumber;
	
	public InputPostUserTicket() {}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public char getRowSeat() {
		return rowSeat;
	}

	public void setRowSeat(char rowSeat) {
		this.rowSeat = rowSeat;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	
}
