package br.com.simply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.simply.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Cliente findByCnpjCpf(String cnpjCpf);
	
	@Query(value="SELECT TOP 1 * FROM cliente WHERE nome LIKE %:nome%", nativeQuery=true)
	public Cliente findByNome(@Param("nome")String nome);
	
	@Query(value="DELETE cliente WHERE id = ?", nativeQuery=true)
	public Boolean excluirCliente(@Param("id")Long id);
	
}
