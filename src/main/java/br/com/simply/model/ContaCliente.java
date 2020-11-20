package br.com.simply.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="conta_cliente")
public class ContaCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cod_banco")
	private BancosEntity codigoBanco;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente idCliente;
	
	@Column(name="cod_agencia")
	private Long codigoAgencia;
	
	@Column(name="cod_conta")
	private Long codigoConta;
	
	@Column(name="principal")
	private Boolean principal;

}
