package br.com.simply.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.simply.model.Ordem;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long>{

	public List<Ordem> findAllByStatusOrdem(String statusOrdem);
	
}
