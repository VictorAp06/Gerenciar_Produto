package com.produtos.apirest.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name="PRODUTO")
public class Produto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Integer codProduto;

    private String nome;

    private BigDecimal valor;

    private BigInteger estoque;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigInteger getEstoque() {
        return estoque;
    }

    public void setEstoque(BigInteger estoque) {
        this.estoque = estoque;
    }

}