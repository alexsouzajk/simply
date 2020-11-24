package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.simply.model.Cliente;
import br.com.simply.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/cliente")
	public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente){
		System.out.println("ENTROU NO CADASTRO \n\n\n\n\n\n\n");
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
}
