package br.com.simply.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="conta_cliente_simply")
public class ContaSimply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="cod_banco")
	private BancosEntity banco;
	
	@OneToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	@Column(name="cod_agencia")
	private String agencia;
	
	@Column(name="cod_conta")
	private String conta;
	
	@Column(name="saldo")
	private BigDecimal saldo;
	
	@Column(name="data_saldo")
	private Date dataSaldo;
	
	
}
