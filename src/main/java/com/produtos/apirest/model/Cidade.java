package com.produtos.apirest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CIDADE")
public class Cidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nome;

    @OneToMany(mappedBy = "cidade")
    private List<Produto> produtos;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
