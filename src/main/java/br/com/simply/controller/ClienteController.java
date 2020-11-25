package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.simply.model.Cliente;
import br.com.simply.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cliente/nome")
	public ResponseEntity<?> buscarClientePorNome(String nome){
		Cliente cliente = clienteRepository.findByNome(nome);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/cliente/cpf")
	public ResponseEntity<?> buscarClientePorCpf(String cpf){
		return ResponseEntity.ok(clienteRepository.findByCnpjCpf(cpf));
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente){
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
	@PutMapping("/cliente")
	public ResponseEntity<?> buscarClientePorNome(@RequestBody Cliente cliente){
		return ResponseEntity.ok(clienteRepository.save(cliente));
	}
	
	@DeleteMapping("/cliente")
	public ResponseEntity<?> deletarCliente(@RequestBody Cliente cliente){
		clienteRepository.delete(cliente);
		return ResponseEntity.ok("Cliente: "+cliente.getNome()+" excluído!");
	}
	
	
}
