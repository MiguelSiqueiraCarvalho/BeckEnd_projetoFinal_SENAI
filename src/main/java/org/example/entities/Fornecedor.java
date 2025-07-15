package org.example.entities;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_ID")
    private Long forId;

    @NotBlank(message = "Nome fantasia é obrigatório")
    @Size(max = 100, message = "Nome deve ter no maximo 100 caracteres")
    @Column(name = "FOR_NOME_FANTASIA", nullable = false)
    private String forNomeFantasia;

    @NotBlank(message = "CNPJ é obrigatório")
    @CNPJ(message = "CNPJ inválido")
    @Column(name = "FOR_CNPJ", unique = true, length = 20, nullable = false)
    private String forCnpj;

    @NotBlank(message = "Razão social é obrigatório")
    @Size(max = 100, message = "Razão social deve ter no máximo 100 caracteres")
    @Column(name = "FOR_RAZAO_SOCIAL", nullable = false)
    private String forRazaoSocial;

    public Fornecedor() {
    }

    public Fornecedor(Long forId, String forNome, String forNomeFantasia, String forCnpj, String forRazaoSocial) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
        this.forCnpj = forCnpj;
        this.forRazaoSocial = forRazaoSocial;
    }

    public Long getForId() {
        return forId;
    }

    public void setForId(Long forId) {
        this.forId = forId;
    }

    public String getForNomeFantasia() {
        return forNomeFantasia;
    }

    public void setForNomeFantasia(String forNomeFantasia) {
        this.forNomeFantasia = forNomeFantasia;
    }

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
    }

    public String getForRazaoSocial() {
        return forRazaoSocial;
    }

    public void setForRazaoSocial(String forRazaoSocial) {
        this.forRazaoSocial = forRazaoSocial;
    }

}
