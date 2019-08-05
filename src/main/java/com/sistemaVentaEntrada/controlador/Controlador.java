package com.sistemaVentaEntrada.controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaVentaEntrada.repositorios.GenreRepository;
import com.sistemaVentaEntrada.repositorios.CinemaFunctionRepository;
import com.sistemaVentaEntrada.repositorios.MovieRepository;
import com.sistemaVentaEntrada.repositorios.RoomRepository;
import com.sistemaVentaEntrada.repositorios.SeatRepository;
import com.sistemaVentaEntrada.repositorios.TicketRepository;
import com.sistemaVentaEntrada.repositorios.UserRepository;

import com.sistemaVentaEntrada.modelo.Genre;
import com.sistemaVentaEntrada.modelo.Movie;
import com.sistemaVentaEntrada.modelo.Room;
import com.sistemaVentaEntrada.modelo.CinemaFunction;
import com.sistemaVentaEntrada.modelo.Seat;
import com.sistemaVentaEntrada.modelo.Ticket;

@Controller
public class Controlador {
	
	@Autowired
	private SeatRepository repoAsiento;
	@Autowired
	private TicketRepository ticketRepo;
	@Autowired 
	private CinemaFunctionRepository movieFunctionRepo;
	@Autowired
	private GenreRepository genreRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private RoomRepository roomRepo;
	@Autowired
	private UserRepository userRepo;

	@GetMapping("hardcodearAsientos")
	public void hardcodearAsientos() {
		char[] letters= {'A','B','C','D','F','G','H','I','J','K','L','M'};
		
		for(int i=0; i<12; i++) {
			for(int j=1; j<16; j++) {
				Seat seat=new Seat();
				seat.setRowSeat(letters[i]);
				seat.setNumber(j);
				repoAsiento.save(seat);
				seat=null;
			}
		}
		
		System.out.println("All seats added");
	}
	
	@GetMapping("hardcodearGeneros")
	public void hardcodearGeneros(){
		List<Genre> genres=new ArrayList<Genre>();
		genres.add(new Genre("Action"));
		genres.add(new Genre("Science Fiction"));
		genres.add(new Genre("Adventure"));
		genres.add(new Genre("Horror"));
		genres.add(new Genre("Comedy"));
		genres.add(new Genre("Musical"));
		genres.add(new Genre("Western"));
		genres.add(new Genre("Historical"));
		genres.add(new Genre("Drama"));
	
		genreRepo.saveAll(genres);
		
		System.out.println("Se agregaron todos los generos");
		
	}
	
	@GetMapping("hardcodearSalas")
	public void hardcodearSalas() {
		addRoom(1, 10, 12);
		addRoom(2, 8, 10);
		addRoom(3, 11, 10);
		addRoom(4, 6, 8);
	}
	
	public List<Seat> getSeatsBD(int numRows, int numSeatsByRow) {
		List<Seat> seats=new ArrayList<Seat>();
		
		char[] letters= {'A','B','C','D','F','G','H','I','J','K','L','M'};
		
		for(int i=0; i< numRows; i++) {
			for(int j=1; j< numSeatsByRow; j++) {
				seats.add(repoAsiento.findByRowSeatAndNumber(letters[i], j));
			}
		}
		
		return seats;
	}
	
	public void addRoom(Integer roomNumber, int numRows, int numSeatsByRow) {
		
		List<Seat> asientos= getSeatsBD(numRows, numSeatsByRow);
		Room sala=new Room(roomNumber, asientos);
		
		roomRepo.save(sala);
		
		System.out.println("Seat "+ roomNumber +" added");
	}
	
}
