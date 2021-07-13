package com.produtos.apirest.controller;

import com.produtos.apirest.model.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:8081")
@RequestMapping(value="/api")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/products")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/products/{cod_produto}")
    public Produto listaProduto(@PathVariable(value = "cod_produto") Integer cod_produto){
        return produtoRepository.findByCodProduto(cod_produto  );
    }

    @PostMapping("/products/saveProduto")
    @CrossOrigin(value = "http://localhost:8081")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/products")
    @CrossOrigin(value = "http://localhost:8081")
    public void deletaProduto(@RequestBody Produto produto){
      produtoRepository.delete(produto);
    }

    @PutMapping("/products")
    @CrossOrigin(value = "http://localhost:8081")
    public void atualizaProduto(@RequestBody Produto produto){
        produtoRepository.save(produto);
    }

}