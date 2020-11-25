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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ordens")
public class Ordem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name="id_cliente")
	@OneToOne
	private Cliente cliente;
	
	@JoinColumn(name="id_moeda")
	@OneToOne
	private Moeda moeda;
	
	@JoinColumn(name="id_conta_simply")
	@OneToOne
	private ContaSimply contaSimply;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="quantidade_moedas")
	private Integer quantidadeMoedas;
	
	@Column(name="data_ordem")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataOrdem;
	
	@Column(name="valor_ordem")
	private BigDecimal valorOrdem;
	
	@Column(name="status_ordem")
	private String statusOrdem;
	
}
