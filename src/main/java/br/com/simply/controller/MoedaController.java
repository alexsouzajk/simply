package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.simply.repository.MoedaRepository;

@Controller
public class MoedaController {

	@Autowired
	private MoedaRepository moedaRepository;
	
	@GetMapping("/moedas")
	public ResponseEntity<?> buscarMoedas(){
		return ResponseEntity.ok(moedaRepository.findAll());
	}
	
}
