package br.com.simply.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="dbo.bancos")
public class BancosEntity {
	@Id
	private Long codigo;

	private String banco;
}
