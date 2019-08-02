package com.sistemaVentaEntrada.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("registroPelicula")
	public String pagRegistroPelicula() {	
		return "newMovieRegistration.html";
	}
	
	@GetMapping("registroFuncion")
	public String pagRegistroFuncion() {
		return "newMovieFunctionRegistration.html";
	}
}
