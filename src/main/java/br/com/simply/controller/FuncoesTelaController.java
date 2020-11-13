package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.simply.repository.BancosRepository;

@Controller
public class FuncoesTelaController {
	
	@Autowired
	private	BancosRepository bancosRepository;
	
	@GetMapping("/bancos")
	public ResponseEntity<?> buscaBancos(){
		bancosRepository.findAll();
		return ResponseEntity.ok(bancosRepository.findAll());
	}
	
}
