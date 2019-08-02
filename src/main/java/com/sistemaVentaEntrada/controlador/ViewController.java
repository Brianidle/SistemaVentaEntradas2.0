package com.sistemaVentaEntrada.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("registroPelicula")
	public String pagRegistroPelicula() {	
		return "registroNuevaPelicula.html";
	}
}
