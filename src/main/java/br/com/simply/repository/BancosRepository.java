package br.com.simply.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.simply.model.BancosEntity;

@Repository
public interface BancosRepository extends JpaRepository<BancosEntity, Long>{

	@Query(value = "SELECT * FROM bancos", nativeQuery = true)
	public List<BancosEntity> findAllbancos();
	
	@Query(value = "SELECT COUNT(*) FROM conta_cliente WHERE id_cliente = 1", nativeQuery = true)
	public int findTotalContas();
	
}
