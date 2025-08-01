package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private Long prodId;

    @Column(name = "PROD_NOME", nullable = false, length = 100)
    private String prodNome;

    @Column(name = "PROD_PRECO_CUSTO", precision = 10, scale = 2, nullable = false)
    private Double prodPrecoCusto;

    @Column(name = "PROD_PRECO_VENDA", precision = 10, scale = 2, nullable = false)
    private Double prodPrecoVenda;

    @Column(name = "PROD_QTD_ESTOQUE", precision = 10, scale = 2, nullable = false)
    private Long prodQtdEstoque;

    @Column(name = "PROD_CATEGORIA", precision = 10, scale = 2, nullable = false)
    private String prodCategoria;

    @Column(name = "PROD_MARCA", precision = 10, scale = 2, nullable = false)
    private String prodMarca;


    @ManyToOne
    @JoinColumn( name = "FOR_ID", nullable = false)
    private Fornecedor fornecedor;

    @ManyToMany
    @JoinTable( name = "Prod_venda", joinColumns = @JoinColumn( name = "PROD_ID"), inverseJoinColumns = @JoinColumn(name = "VENDA_ID"))
    private Set<Venda> venda;

    public Produto() {
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto(Long prodId, String prodNome, Double prodPrecoCusto, Double prodPrecoVenda, Long prodQtdEstoque, String prodCategoria, String prodMarca) {
        this.prodId = prodId;
        this.prodNome = prodNome;
        this.prodPrecoCusto = prodPrecoCusto;
        this.prodPrecoVenda = prodPrecoVenda;
        this.prodQtdEstoque = prodQtdEstoque;
        this.prodCategoria = prodCategoria;
        this.prodMarca = prodMarca;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public Double getProdPrecoCusto() {
        return prodPrecoCusto;
    }

    public void setProdPrecoCusto(Double prodPrecoCusto) {
        this.prodPrecoCusto = prodPrecoCusto;
    }

    public Double getProdPrecoVenda() {
        return prodPrecoVenda;
    }

    public void setProdPrecoVenda(Double prodPrecoVenda) {
        this.prodPrecoVenda = prodPrecoVenda;
    }

    public Long getProdQtdEstoque() {
        return prodQtdEstoque;
    }

    public void setProdQtdEstoque(Long prodQtdEstoque) {
        this.prodQtdEstoque = prodQtdEstoque;
    }

    public String getProdCategoria() {
        return prodCategoria;
    }

    public void setProdCategoria(String prodCategoria) {
        this.prodCategoria = prodCategoria;
    }

    public String getProdMarca() {
        return prodMarca;
    }

    public void setProdMarca(String prodMarca) {
        this.prodMarca = prodMarca;
    }
}