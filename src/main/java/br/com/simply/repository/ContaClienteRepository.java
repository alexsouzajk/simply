package br.com.simply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.simply.model.ContaCliente;

@Repository
public interface ContaClienteRepository extends JpaRepository<ContaCliente, Long>{

}
