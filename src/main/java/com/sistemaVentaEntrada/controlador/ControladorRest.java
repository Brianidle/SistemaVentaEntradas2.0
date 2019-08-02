package com.sistemaVentaEntrada.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaVentaEntrada.modelo.Genre;
import com.sistemaVentaEntrada.modelo.Movie;
import com.sistemaVentaEntrada.modelo.Room;
import com.sistemaVentaEntrada.repositorios.GenreRepository;
import com.sistemaVentaEntrada.repositorios.SeatRepository;
import com.sistemaVentaEntrada.repositorios.TicketRepository;
import com.sistemaVentaEntrada.repositorios.MovieFunctionRepository;
import com.sistemaVentaEntrada.repositorios.MovieRepository;
import com.sistemaVentaEntrada.repositorios.RoomRepository;
import com.sistemaVentaEntrada.repositorios.UserRepository;

@RestController
public class ControladorRest {
	
	@Autowired
	private SeatRepository repoAsiento;
	@Autowired
	private TicketRepository ticketRepo;
	@Autowired 
	private MovieFunctionRepository movieFunctionRepo;
	@Autowired
	private GenreRepository genreRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private RoomRepository roomRepo;
	@Autowired
	private UserRepository userRepo;

	@GetMapping("getGenres")
	public ResponseEntity<Object> getGenresBD() {
		List<Genre> genresBD=genreRepo.findAll();
		
		for (Genre genre : genresBD) {
			System.out.println(genre);
		}
		
		ServiceResponse<List<Genre>> response= new ServiceResponse<List<Genre>>("success", genresBD);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@GetMapping("getMovies")
	public ResponseEntity<Object> getMovies(){
		List<Movie> movies= movieRepo.findAll();
		
		ServiceResponse<List<Movie>> response=new ServiceResponse<List<Movie>>("success",movies);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@GetMapping("getRooms")
	public ResponseEntity<Object> getRooms(){
		List<Room> seats=roomRepo.findAll();
		
		ServiceResponse<List<Room>> response= new ServiceResponse<List<Room>>("success", seats);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
}
