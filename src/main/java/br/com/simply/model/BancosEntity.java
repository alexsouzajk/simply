package br.com.simply.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="bancos")
public class BancosEntity {
	@Id
	private Long codigo;
	
	@Column(name="banco")
	private String banco;
}
