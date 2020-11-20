package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.simply.model.ContaCliente;
import br.com.simply.repository.BancosRepository;
import br.com.simply.repository.ContaClienteRepository;
import br.com.simply.repository.ContaSimplyRepository;

@Controller
public class FuncoesTelaController {
	
	@Autowired
	private	BancosRepository bancosRepository;
	
	@Autowired
	private	ContaClienteRepository contaClienteRepository;
	
	@Autowired
	private ContaSimplyRepository contaSimplyRepository;
	
	@GetMapping("/bancos")
	public ResponseEntity<?> buscaBancos(){
		bancosRepository.findAll();
		return ResponseEntity.ok(bancosRepository.findAllbancos());
	}
	
	@GetMapping("/qtd-contas")
	public ResponseEntity<?> buscaQuantidadeContas(){
		String jsonRetorno = "{\"qtdContas\":"+bancosRepository.findTotalContas()+"}";
		return ResponseEntity.ok(jsonRetorno);
	}
	
	@GetMapping("/contas")
	public ResponseEntity<?> buscaContasCliente(){
		return ResponseEntity.ok(contaClienteRepository.findAll());
	}
	
	@PostMapping("/contas")
	public ResponseEntity<?> salvarContaCliente(@RequestBody ContaCliente contaCliente){
		return ResponseEntity.ok(contaClienteRepository.save(contaCliente));
	}
	
	@DeleteMapping("/contas")
	public ResponseEntity<?> excluirContaCliente(@RequestBody ContaCliente contaCliente){
		contaClienteRepository.delete(contaCliente);
		return ResponseEntity.ok("Conta deletada!");
	}
	
	@GetMapping("/contas-simply")
	public ResponseEntity<?> buscaContaSimply(){
		return ResponseEntity.ok(contaSimplyRepository.findByCliente_id(1L));
	}
	
	
}
