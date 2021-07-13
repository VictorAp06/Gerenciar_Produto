package com.produtos.apirest.controller;

import com.produtos.apirest.model.Cidade;
import com.produtos.apirest.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(value = "http://localhost:8081")
@RestController
@RequestMapping(value="/api")
public class CidadeController {

    @Autowired
    CidadeRepository cidadeRepository;
    @CrossOrigin(value = "http://localhost:8081")
    @GetMapping("/cidades")
    public List<Cidade> listaCidades() {
        return cidadeRepository.findAll();
    }

}
