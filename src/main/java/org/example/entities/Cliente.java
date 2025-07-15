package org.example.entities;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "CLI_NOME", nullable = false, length = 100)
    private String cliNome;

    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(name = "CLI_CPF",nullable = false, unique = true, length = 11)
    private String cliCpf;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    @Column(name = "CLI_EMAIL", nullable = false, length = 100)
    private String cliEmail;

    @NotBlank(message = "Telefone é obrogatório")
    @Size(max = 14, message = "Telefone deve ter no áximo 14 caracteres")
    @Column(name = "CLI_TELEFONE", nullable = false, length = 14)
    private String cliTelefone;


    @Column(name = "CLI_END_RUA", nullable = true, length = 100)
    private String cliEndRua;

    @Column(name = "CLI_END_CIDADE", nullable = true, length = 100)
    private String cliEndCidade;

    @Column(name = "CLI_END_NUMERO", nullable = true, length = 100)
    private String cliEndNum;

    @Column(name = "CLI_END_ESTADO", nullable = true, length = 100)
    private String cliEndEstado;

    public Cliente() {
    }

    public Cliente(Long cliId, String cliNome, String cliCpf, String cliEmail, String cliTelefone, String cliEndRua, String cliEndCidade, String cliEndNum, String cliEndEstado) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.cliEmail = cliEmail;
        this.cliTelefone = cliTelefone;
        this.cliEndRua = cliEndRua;
        this.cliEndCidade = cliEndCidade;
        this.cliEndNum = cliEndNum;
        this.cliEndEstado = cliEndEstado;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliEndRua() {
        return cliEndRua;
    }

    public void setCliEndRua(String cliEndRua) {
        this.cliEndRua = cliEndRua;
    }

    public String getCliEndCidade() {
        return cliEndCidade;
    }

    public void setCliEndCidade(String cliEndCidade) {
        this.cliEndCidade = cliEndCidade;
    }

    public String getCliEndNum() {
        return cliEndNum;
    }

    public void setCliEndNum(String cliEndNum) {
        this.cliEndNum = cliEndNum;
    }

    public String getCliEndEstado() {
        return cliEndEstado;
    }

    public void setCliEndEstado(String cliEndEstado) {
        this.cliEndEstado = cliEndEstado;
    }
}
