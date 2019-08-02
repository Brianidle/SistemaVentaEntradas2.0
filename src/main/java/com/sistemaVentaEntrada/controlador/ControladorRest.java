package com.sistemaVentaEntrada.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaVentaEntrada.modelo.Genre;
import com.sistemaVentaEntrada.modelo.Pelicula;
import com.sistemaVentaEntrada.modelo.Sala;
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
	private TicketRepository repoEntrada;
	@Autowired 
	private MovieFunctionRepository repoFuncion;
	@Autowired
	private GenreRepository repoGenre;
	@Autowired
	private MovieRepository repoPelicula;
	@Autowired
	private RoomRepository repoSala;
	@Autowired
	private UserRepository repoUsuario;

	@GetMapping("getGenres")
	public ResponseEntity<Object> getGenresBD() {
		List<Genre> genresBD=repoGenre.findAll();
		
		for (Genre genre : genresBD) {
			System.out.println(genre);
		}
		
		ServiceResponse<List<Genre>> response= new ServiceResponse<List<Genre>>("success", genresBD);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@GetMapping("getPeliculas")
	public ResponseEntity<Object> getPeliculas(){
		List<Pelicula> movies= repoPelicula.findAll();
		
		ServiceResponse<List<Pelicula>> response=new ServiceResponse<List<Pelicula>>("success",movies);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
	
	@GetMapping("getSalas")
	public ResponseEntity<Object> getSalas(){
		List<Sala> seats=repoSala.findAll();
		
		ServiceResponse<List<Sala>> response= new ServiceResponse<List<Sala>>("success", seats);
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
}
