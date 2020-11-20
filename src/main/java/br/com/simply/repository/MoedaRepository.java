package br.com.simply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.simply.model.Moeda;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Long>{

}
