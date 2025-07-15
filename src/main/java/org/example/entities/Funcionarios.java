package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Funcionarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUN_ID")
    private Long funId;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "FUN_NOME", nullable = false, length = 100)
    private String funNome;

    @NotBlank(message = "Cargo é obrigatório")
    @Column(name = "FUN_CARGO", nullable = false, length = 100)
    private String funCargo;

    @NotBlank(message = "Telefone é obrigatório")
    @Column(name = "FUN_TELEFONE", nullable = false, length = 30)
    private String funTelefone;

    @NotBlank(message = "CPF é obrigatório")
    @Column(name = "FUN_CPF", nullable = false, length = 11, unique = true)
    private String funCPF;

    public Funcionarios() {
    }

    public Funcionarios(Long funId, String funNome, String funCargo, String funTelefone, String funCPF) {
        this.funId = funId;
        this.funNome = funNome;
        this.funCargo = funCargo;
        this.funTelefone = funTelefone;
        this.funCPF = funCPF;
    }

    public Long getFunId() {
        return funId;
    }

    public void setFunId(Long funId) {
        this.funId = funId;
    }

    public String getFunNome() {
        return funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public String getFunCargo() {
        return funCargo;
    }

    public void setFunCargo(String funCargo) {
        this.funCargo = funCargo;
    }

    public String getFunTelefone() {
        return funTelefone;
    }

    public void setFunTelefone(String funTelefone) {
        this.funTelefone = funTelefone;
    }

    public String getFunCPF() {
        return funCPF;
    }

    public void setFunCPF(String funCPF) {
        this.funCPF = funCPF;
    }
}