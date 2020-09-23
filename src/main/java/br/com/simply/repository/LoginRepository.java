package br.com.simply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.simply.model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long>{

}
