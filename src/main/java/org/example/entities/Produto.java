package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @Column(name = "PRO_NOME")
    private String proNome;

    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2)
    private Double proPrecoCusto;

    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2)
    private Double proPrecoVenda;

    @Column(name = "PRO_QTD_ESTOQUE", precision = 10, scale = 2)
    private Long proQtdEstoque;

    @Column(name = "PRO_CATEGORIA", precision = 10, scale = 2)
    private String proCategoria;

    @Column(name = "PRO_CODIGO_BARRAS", precision = 10, scale = 2)
    private String proCodigoBarras;

    @Column(name = "PRO_MARCA", precision = 10, scale = 2)
    private String proMarca;

    @Column(name = "PRO_UNIDADE_MEDIDA", precision = 10, scale = 2)
    private String proUnidadeMedida;

    @Column(name = "PRO_STATUS", precision = 10, scale = 2)
    private String proStatus;

    @Column(name = "PRO_DATA_CADASTRO", precision = 10, scale = 2)
    private String proDataCadastro;

    @Column(name = "PRO_DATA_ATT", precision = 10, scale = 2)
    private String proDataAtt;

    public Produto() {
    }

    public Produto(Long proId, String proNome, Double proPrecoCusto, Double proPrecoVenda, Long proQtdEstoque, String proCategoria, String proCodigoBarras, String proMarca, String proUnidadeMedida, String proStatus, String proDataCadastro, String proDataAtt) {
        this.proId = proId;
        this.proNome = proNome;
        this.proPrecoCusto = proPrecoCusto;
        this.proPrecoVenda = proPrecoVenda;
        this.proQtdEstoque = proQtdEstoque;
        this.proCategoria = proCategoria;
        this.proCodigoBarras = proCodigoBarras;
        this.proMarca = proMarca;
        this.proUnidadeMedida = proUnidadeMedida;
        this.proStatus = proStatus;
        this.proDataCadastro = proDataCadastro;
        this.proDataAtt = proDataAtt;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public Double getProPrecoCusto() {
        return proPrecoCusto;
    }

    public void setProPrecoCusto(Double proPrecoCusto) {
        this.proPrecoCusto = proPrecoCusto;
    }

    public Double getProPrecoVenda() {
        return proPrecoVenda;
    }

    public void setProPrecoVenda(Double proPrecoVenda) {
        this.proPrecoVenda = proPrecoVenda;
    }

    public Long getProQtdEstoque() {
        return proQtdEstoque;
    }

    public void setProQtdEstoque(Long proQtdEstoque) {
        this.proQtdEstoque = proQtdEstoque;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public String getProCodigoBarras() {
        return proCodigoBarras;
    }

    public void setProCodigoBarras(String proCodigoBarras) {
        this.proCodigoBarras = proCodigoBarras;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public String getProUnidadeMedida() {
        return proUnidadeMedida;
    }

    public void setProUnidadeMedida(String proUnidadeMedida) {
        this.proUnidadeMedida = proUnidadeMedida;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(String proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public String getProDataAtt() {
        return proDataAtt;
    }

    public void setProDataAtt(String proDataAtt) {
        this.proDataAtt = proDataAtt;
    }
}