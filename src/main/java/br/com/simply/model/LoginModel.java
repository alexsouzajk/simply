package br.com.simply.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="login")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {

	private String login;
	
	private String senha;
	
}
