package br.com.simply.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cnpj_cpf")
	private String cnpjCpf;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="data_nascimento")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="sexo")
	private String sexo;

}
