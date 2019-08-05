package com.sistemaVentaEntrada.controlador;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaVentaEntrada.modelo.CinemaFunction;
import com.sistemaVentaEntrada.modelo.Genre;
import com.sistemaVentaEntrada.modelo.Movie;
import com.sistemaVentaEntrada.modelo.Room;
import com.sistemaVentaEntrada.modelo.Seat;
import com.sistemaVentaEntrada.modelo.Ticket;
import com.sistemaVentaEntrada.modelo.User;
import com.sistemaVentaEntrada.repositorios.CinemaFunctionRepository;
import com.sistemaVentaEntrada.repositorios.GenreRepository;
import com.sistemaVentaEntrada.repositorios.SeatRepository;
import com.sistemaVentaEntrada.repositorios.TicketRepository;
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
	private CinemaFunctionRepository cinemaFunctionRepo;
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

		ServiceResponse<List<Genre>> response= new ServiceResponse<List<Genre>>("success", genresBD);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@GetMapping("getMovies")
	public ResponseEntity<Object> getMoviesBD(){
		List<Movie> movies= movieRepo.findAll();
		
		ServiceResponse<List<Movie>> response=new ServiceResponse<List<Movie>>("success",movies);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@GetMapping("getRooms")
	public ResponseEntity<Object> getRoomsBD(){
		List<Room> rooms=roomRepo.findAll();
		
		for (Room room : rooms) {
			System.out.println(room);
		}
		
		ServiceResponse<List<Room>> response= new ServiceResponse<List<Room>>("success", rooms);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@PostMapping("addMovie")
	public ResponseEntity<Object> addMovieBD(@RequestBody Movie movieInput){
		System.out.println(movieInput);
		List<Genre> genresBD=new ArrayList<Genre>();
		
		for (Genre genre : movieInput.getGenres()) {
			genresBD.add(genreRepo.findByName(genre.getName()));
		}
		
		Movie newMovie=new Movie();
		newMovie.setName(movieInput.getName());
		newMovie.setGenres(genresBD);
		
		movieRepo.save(newMovie);
		
		ServiceResponse<Movie> response=new ServiceResponse<Movie>("success",movieInput);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@PostMapping("addCinemaFunction")
	public ResponseEntity<Object> addCinemaFunction(@RequestBody InfoPostPelicula infoPost){
		CinemaFunction newCinemaFunction= new CinemaFunction();

		System.out.println(infoPost);
		
		Room room=roomRepo.findByRoomNumber(infoPost.getRoomNumber());
		Movie movie=movieRepo.findByName(infoPost.getMovieName());
		
		System.out.println(room);
		System.out.println(movie);
		
		newCinemaFunction.setMovie(movie);
		newCinemaFunction.setRoom(room);
		newCinemaFunction.setDate(LocalDate.parse(infoPost.getDate()));
		newCinemaFunction.setTime(LocalTime.parse(infoPost.getTime()));
		
		cinemaFunctionRepo.save(newCinemaFunction);
		
		//Crear Entradas para esa Funcion de Cine
		List<Seat> roomSeats=room.getSeats();
		//crear un hilo para que se creen los tickets, mientras se envia la respuesta, porque sino la respuesta tendra que esperar a 
		//que se cargen los tickets
		for (Seat seat : roomSeats) {
			Ticket t=new Ticket();
			t.setSeat(seat);
			t.setCinemaFunction(newCinemaFunction);
			ticketRepo.save(t);
		}
		
		ServiceResponse<InfoPostPelicula> response=new ServiceResponse<InfoPostPelicula>("success",infoPost);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@PostMapping("addUser")
	public ResponseEntity<Object> addUserBD(@RequestBody User user){
		System.out.println(user);
		
		userRepo.save(user);
		
		ServiceResponse<User> response=new ServiceResponse<User>("success",user);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
}
