package org.example.services;

import org.example.entities.Funcionarios;
import org.example.repositories.FuncionarioRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionarios> getAll() {
        return repository.findAll();
    }

    public Funcionarios findById(Long id) {
        Optional<Funcionarios> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Funcionarios insert(Funcionarios funcionarios) {
        return repository.save(funcionarios);
    }

    public boolean update(Long id, Funcionarios funcionarios) {
        Optional<Funcionarios> optionalFuncionarios = repository.findById(id);
        if (optionalFuncionarios.isPresent()) {
            Funcionarios funcionariosSistema = optionalFuncionarios.get();
            funcionariosSistema.setFunNome(funcionarios.getFunNome());
            funcionariosSistema.setFunCPF(funcionarios.getFunCPF());
            funcionariosSistema.setFunCargo(funcionarios.getFunCargo());
            funcionariosSistema.setFunTelefone(funcionarios.getFunTelefone());
            repository.save(funcionariosSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
