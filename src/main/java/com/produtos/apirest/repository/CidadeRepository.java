package com.produtos.apirest.repository;

import com.produtos.apirest.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CidadeRepository extends JpaRepository<Cidade, String>{
}
