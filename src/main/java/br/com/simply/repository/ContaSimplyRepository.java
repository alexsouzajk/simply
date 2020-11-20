package br.com.simply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.simply.model.ContaSimply;

@Repository
public interface ContaSimplyRepository extends JpaRepository<ContaSimply, Long> {

	public ContaSimply findByCliente_id(Long id);
	
}
