package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.simply.model.Ordem;
import br.com.simply.repository.OrdemRepository;
import br.com.simply.service.OrdemService;

@Controller
public class OrdensController {
	
	@Autowired
	private OrdemRepository ordemRepository;
	
	@Autowired
	private OrdemService ordemService;
	
	@PostMapping("/ordens")
	public ResponseEntity<?> criarOrden(@RequestBody Ordem ordem){
		return ResponseEntity.ok(ordemService.criarOrdem(ordem));
	}
	
	@GetMapping("/ordens/cliente/{cpf}")
	public ResponseEntity<?> buscarOrdensPorData(@PathVariable("cpf")String cpf){
		return ResponseEntity.ok(ordemRepository.findByCliente_cnpjCpfOrderByDataOrdemDesc(cpf));
	}
	
	@GetMapping("/ordens/data/{quantidadeDias}")
	public ResponseEntity<?> buscarOrdensPorData(@PathVariable("quantidadeDias")Integer quantidadeDias){
		return ResponseEntity.ok(ordemService.buscarPorDataEntre(quantidadeDias));
	}
	
	@GetMapping("/ordens/moeda/{idMoeda}")
	public ResponseEntity<?> buscarOrdensPorMoeda(@PathVariable("idMoeda")Long idMoeda){
		return ResponseEntity.ok(ordemRepository.findByMoeda_idOrderByDataOrdemDesc(idMoeda));
	}
	
}
