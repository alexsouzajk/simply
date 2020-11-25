package br.com.simply.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.simply.model.Ordem;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long>{

	public List<Ordem> findAllByStatusOrdem(String statusOrdem);
	
	public List<Ordem> findByMoeda_idOrderByDataOrdemDesc(Long idMoeda);
	
	public List<Ordem> findByCliente_cnpjCpfOrderByDataOrdemDesc(String cnpjCpf);
	
	@Query(value = "SELECT * FROM ordens WHERE data_ordem BETWEEN :startDate AND :endDate ORDER BY data_ordem DESC", nativeQuery=true)
	public List<Ordem> findAllByDataBetween(@Param("startDate")Date dataInicial,@Param("endDate")Date agora);
	
}
