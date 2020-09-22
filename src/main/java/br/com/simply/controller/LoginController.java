package br.com.simply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.simply.request.LoginRequest;
import br.com.simply.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public ResponseEntity<String> realizaLogin(@RequestBody LoginRequest login) {
		return ResponseEntity.ok(loginService.realizaLogin(login));
	}
	
}
