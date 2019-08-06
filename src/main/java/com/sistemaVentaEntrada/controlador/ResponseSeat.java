package com.sistemaVentaEntrada.controlador;

public class ResponseSeat {

	private char rowSeat;
	private Integer number;

	public ResponseSeat(char rowSeat, Integer number) {
		this.rowSeat = rowSeat;
		this.number = number;
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
