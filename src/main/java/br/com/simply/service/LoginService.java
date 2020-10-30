package br.com.simply.service;

import org.springframework.stereotype.Service;

import br.com.simply.request.LoginRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {
	
	public String realizaLogin(LoginRequest login) {
		String retorno = "Login realizado! usuário logado - " + login.getLogin();
		return retorno;
	}
	
}
