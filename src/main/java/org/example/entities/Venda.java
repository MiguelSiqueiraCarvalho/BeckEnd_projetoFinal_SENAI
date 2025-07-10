package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENDA_ID")
    private Long vendaId;

    @NotBlank(message = "Forma de pagamento é obrigatório")
    @Column(name = "VENDA_FORMA_PAGAMENTO", length = 40)
    private String vendaFomaPagamento;

    @NotBlank(message = "Data é obrigatório")
    @Column(name = "VENDA_DATA", nullable = false, length = 30)
    private String vendaData;

    @ManyToMany(mappedBy = "venda")
    private Set<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "CLI_ID")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FUN_ID")
    private Funcionarios funcionarios;


    public Venda() {
    }

    public Venda(Long vendaId, String vendaFomaPagamento, String vendaData) {
        this.vendaId = vendaId;
        this.vendaFomaPagamento = vendaFomaPagamento;
        this.vendaData = vendaData;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
    }

    public String getVendaFomaPagamento() {
        return vendaFomaPagamento;
    }

    public void setVendaFomaPagamento(String vendaFomaPagamento) {
        this.vendaFomaPagamento = vendaFomaPagamento;
    }

    public String getVendaData() {
        return vendaData;
    }

    public void setVendaData(String vendaData) {
        this.vendaData = vendaData;
    }
}
