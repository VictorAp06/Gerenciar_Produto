package com.produtos.apirest.repository;

import com.produtos.apirest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //Produto findById(long id);

    Produto findByCodProduto(Integer cod_produto);

    void deleteByCodProduto(Integer cod_produto);
}
