package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.simply.model.Ordem;
import br.com.simply.service.OrdemService;

@Controller
public class OrdensController {
	
	@Autowired
	private OrdemService ordemService;
	
	@PostMapping("ordens")
	public ResponseEntity<?> criarOrden(@RequestBody Ordem ordem){
		return ResponseEntity.ok(ordemService.criarOrdem(ordem));
	}
	
}
