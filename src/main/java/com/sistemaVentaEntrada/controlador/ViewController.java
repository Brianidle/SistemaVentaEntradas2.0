package com.sistemaVentaEntrada.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("movieRegistration")
	public String pagMovieRegistration() {	
		return "newMovieRegistration.html";
	}
	
	@GetMapping("cinemaFunctionRegistration")
	public String pagCinemaFunctionRegistration() {
		return "newCinemaFunctionRegistration.html";
	}
	
	@GetMapping("userRegistration")
	public String pagUserRegistration() {
		return "newUserRegistration.html";
	}
	
	@GetMapping("buyTicket")
	public String pagBuyTicket() {
		return "buyTicket.html";
	}
	
	@GetMapping("chooseCinemaFunction")
	public String chooseCinemaFunctionPag() {
		return "ChooseCinemaFunction.html";
	}
	
	@GetMapping("deleteMovie")
	public String deleteMoviePag() {
		return "deleteMovie.html";
	}
	
	@GetMapping("home")
	public String pagHome() {
		return "home.html";
	}
}
