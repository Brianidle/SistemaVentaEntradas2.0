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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaVentaEntrada.modelo.User;
import com.sistemaVentaEntrada.repositorios.SeatRepository;
import com.sistemaVentaEntrada.repositorios.TicketRepository;
import com.sistemaVentaEntrada.repositorios.MovieFunctionRepository;
import com.sistemaVentaEntrada.repositorios.GenreRepository;
import com.sistemaVentaEntrada.repositorios.MovieRepository;
import com.sistemaVentaEntrada.repositorios.RoomRepository;
import com.sistemaVentaEntrada.repositorios.UserRepository;
import com.sistemaVentaEntrada.modelo.Seat;
import com.sistemaVentaEntrada.modelo.CinemaFunction;
import com.sistemaVentaEntrada.modelo.Genre;
import com.sistemaVentaEntrada.modelo.Pelicula;
import com.sistemaVentaEntrada.modelo.Sala;

@Controller
public class Controlador {
	
	@Autowired
	private SeatRepository repoAsiento;
	@Autowired
	private TicketRepository repoEntrada;
	@Autowired 
	private MovieFunctionRepository repoFuncion;
	@Autowired
	private GenreRepository repoGenero;
	@Autowired
	private MovieRepository repoPelicula;
	@Autowired
	private RoomRepository repoSala;
	@Autowired
	private UserRepository repoUsuario;
	
	@RequestMapping("registrarUsuario")
	public ModelAndView registrarUsuario(@RequestParam("nombre") String nombre, @RequestParam("contrasenia") String contra) {
		
		User nuevoUsuario=new User();
		nuevoUsuario.setNombre(nombre);
		nuevoUsuario.setContrasenia(contra);
		
		repoUsuario.save(nuevoUsuario);
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("usuarioRegistradoExitosamente.jsp");
		mv.addObject("usuario",nuevoUsuario);
		
		return mv;
	}
	
	@RequestMapping("home")
	public String pagPrincipal() {
		return "paginaPrincipal.jsp";
	}
	
	@RequestMapping("registroUsuario")
	public String pagRegistroUsuario() {
		return "registroUsuario.jsp";
	}
	
	@RequestMapping("registroPelicula")
	public String pagRegistroPelicula(Model model) {
		Map<String,String> opcionesNombresGeneros=new HashMap<String,String>();
		List<Genre> generosBD=repoGenero.findAll();
		Genre g=new Genre();
		g.setNombre("Aventura");
		
		for (Genre genero : generosBD) {
			opcionesNombresGeneros.put(genero.getNombre(), genero.getNombre());
		}
		
		model.addAttribute("opcionesGeneros",opcionesNombresGeneros);
		model.addAttribute("generoPorDefecto", g);
		
		return "registroNuevaPelicula.jsp";
	}
	
	@RequestMapping("registroFuncion")
	public String pagRegistroFuncion(Model model) {
		List<Pelicula> peliculasBD=repoPelicula.findAll();
		//List<Sala> salasBD=repoSala.findAll();
		List<String> nombresPeliculasBD=new ArrayList<String>();
		Map<String,String> opcionesPeliculas=new HashMap<String,String>();
		//Map<Integer,String> opcionesNumSalas=new HashMap<Integer,String>();
		
		//Valor por defecto para la Lista Desplegable
		Pelicula peliculaPorDefecto=new Pelicula();
		peliculaPorDefecto.setNombre("Terminator 3");
		
		//List<String> nombresPeliculasBD = (List<String>) peliculasBD.forEach(p-> {p.getNombre();});
		
		for (Pelicula pelicula : peliculasBD) {
			nombresPeliculasBD.add(pelicula.getNombre());
			opcionesPeliculas.put(pelicula.getNombre(), pelicula.getNombre().toUpperCase());
		}
		/*
		for (Sala sala : salasBD) {
			opcionesNumSalas.put(sala.getNumSala(), String.valueOf(sala.getNumSala()));
		}
		
		model.addAttribute("opcionesNumSalas",opcionesNumSalas);*/
		model.addAttribute("opcionesPeliculas",opcionesPeliculas);
		model.addAttribute("peliculaPorDefecto", peliculaPorDefecto);
		
		
		return "registroNuevaFuncion.jsp";
	}

	@RequestMapping("registrarPelicula")
	public ModelAndView registrarPelicula(String nombrePelicula,@RequestParam("nombre") List<String> nombresGeneros) {
		ModelAndView mv=new ModelAndView();
		Pelicula nuevaPelicula;
		List<Genre> generosElegidos=new ArrayList<Genre>();
		
		for (String nombreGenero : nombresGeneros) {
			generosElegidos.add(repoGenero.findByNombre(nombreGenero));
		}
		
		nuevaPelicula=new Pelicula(nombrePelicula, generosElegidos);
		repoPelicula.save(nuevaPelicula);
		
		mv.addObject("lists",generosElegidos);
		mv.addObject("pelicula",nuevaPelicula);
		mv.setViewName("registroPeliculaExitoso.jsp");
		
		return mv;
	}
	
	@RequestMapping("registarFuncion")
	public ModelAndView registrarFuncion(@RequestParam("nombre") String nombrePelicula, String fecha, String hora, Integer numSala){
		ModelAndView mv=new ModelAndView();
		Pelicula pelicula=repoPelicula.findByNombre(nombrePelicula);
		Sala sala=repoSala.findByNumSala(numSala);
		CinemaFunction funcion=new CinemaFunction(LocalDate.parse(fecha), LocalTime.parse(hora), pelicula, sala);
		
		mv.addObject("funcion",funcion);
		mv.addObject("pelicula",pelicula);
		mv.setViewName("funcionRegistradaExitosamente.jsp");
		
		repoFuncion.save(funcion);
		
		return mv;
	}
	
	@RequestMapping("hardcodearAsientos")
	public void hardcodearAsientos() {
		char[] letras= {'A','B','C','D','F','G','H','I','J','K','L','M'};
		
		for(int i=0; i<12; i++) {
			for(int j=1; j<16; j++) {
				Seat asiento=new Seat();
				asiento.setFila(letras[i]);
				asiento.setNumero(j);
				repoAsiento.save(asiento);
				asiento=null;
			}
		}
		
		System.out.println("Se agregaron todos los asientos");
	}
	
	@RequestMapping("hardcodearGeneros")
	public void hardcodearGeneros(){
		List<Genre> generos=new ArrayList<Genre>();
		generos.add(new Genre("Acción"));
		generos.add(new Genre("Ciencia Ficción"));
		generos.add(new Genre("Aventura"));
		generos.add(new Genre("Terror"));
		generos.add(new Genre("Comedia"));
		generos.add(new Genre("Musical"));
		generos.add(new Genre("Infantil"));
		generos.add(new Genre("Adulto"));
		generos.add(new Genre("Drama"));
	
		repoGenero.saveAll(generos);
		
		System.out.println("Se agregaron todos los generos");
		
	}
	
	@RequestMapping("hardcodearSalas")
	public void hardcodearSalas() {
		agregarSala(1, 10, 12);
		agregarSala(2, 8, 10);
		agregarSala(3, 11, 10);
		agregarSala(4, 6, 8);
	}
	
	public List<Seat> obtenerAsientos(int numFilas, int numAsientosPorFila) {
		List<Seat> asientos=new ArrayList<Seat>();
		
		char[] letras= {'A','B','C','D','F','G','H','I','J','K','L','M'};
		
		for(int i=0; i< numFilas; i++) {
			for(int j=1; j< numAsientosPorFila; j++) {
				asientos.add(repoAsiento.findByFilaAndNumero(letras[i], j));
			}
		}
		
		return asientos;
	}
	
	public void agregarSala(Integer numSala, int numFilas, int numAsientosPorFila) {
		
		List<Seat> asientos= obtenerAsientos(numFilas, numAsientosPorFila);
		Sala sala=new Sala(numSala, asientos);
		
		repoSala.save(sala);
		
		System.out.println("Sala "+ numSala +" agregada.");
	}
	
}
