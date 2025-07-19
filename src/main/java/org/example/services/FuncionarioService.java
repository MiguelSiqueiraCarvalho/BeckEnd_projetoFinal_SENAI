package org.example.services;

import org.example.entities.Funcionario;
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

    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    public Funcionario findById(Long id) {
        Optional<Funcionario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Funcionario insert(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public boolean update(Long id, Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionarios = repository.findById(id);
        if (optionalFuncionarios.isPresent()) {
            Funcionario funcionarioSistema = optionalFuncionarios.get();
            funcionarioSistema.setFunNome(funcionario.getFunNome());
            funcionarioSistema.setFunCPF(funcionario.getFunCPF());
            funcionarioSistema.setFunCargo(funcionario.getFunCargo());
            funcionarioSistema.setFunTelefone(funcionario.getFunTelefone());
            repository.save(funcionarioSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
