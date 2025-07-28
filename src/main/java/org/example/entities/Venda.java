package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENDA_ID")
    private Long vendaId;

    @NotBlank(message = "Forma de pagamento é obrigatório")
    @Column(name = "VENDA_FORMA_PAGAMENTO", length = 40, nullable = false)
    private String vendaFormaPagamento;

    @NotBlank(message = "Data é obrigatório")
    @Column(name = "VENDA_DATA", nullable = false, length = 30)
    private String vendaData;

    @NotBlank(message = "Valor é obrigatorio")
    @Column(name = "VENDA_VALOR", nullable = false, length = 30000)
    private Double vendaValor;

    @ManyToMany(mappedBy = "venda")
    private Set<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "CLI_ID", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FUN_ID", nullable = false)
    private Funcionario funcionario;


    public Venda() {
    }

    public Venda(Long vendaId, String vendaFormaPagamento, String vendaData, Double vendaValor) {
        this.vendaId = vendaId;
        this.vendaFormaPagamento = vendaFormaPagamento;
        this.vendaData = vendaData;
        this.vendaValor = vendaValor;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
    }

    public String getVendaFormaPagamento() {
        return vendaFormaPagamento;
    }

    public void setVendaFormaPagamento(String vendaFormaPagamento) {
        this.vendaFormaPagamento = vendaFormaPagamento;
    }

    public String getVendaData() {
        return vendaData;
    }

    public void setVendaData(String vendaData) {
        this.vendaData = vendaData;
    }

    public Double getVendaValor() { return vendaValor;}

    public void setVendaValor(Double vendaValor) { this.vendaValor = vendaValor;}


}
