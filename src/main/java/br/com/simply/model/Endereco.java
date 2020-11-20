package br.com.simply.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="logradouro")
	private String logradouro;
	
	@Column(name="bairro")
	private String bairo;
	
	@Column(name="UF")
	private String UF;
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="complemento")
	private String complemento;

}
