package org.example.services;

import org.example.entities.Venda;
import org.example.repositories.VendaRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<Venda> getAll() {
        return repository.findAll();
    }

    public Venda findById(Long id) {
        Optional<Venda> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Venda insert(Venda venda) {
        return repository.save(venda);
    }

    public boolean update(Long id, Venda venda) {
        Optional<Venda> optionalVenda = repository.findById(id);
        if (optionalVenda.isPresent()) {
            Venda vendaSistema = optionalVenda.get();
            vendaSistema.setVendaFomaPagamento(venda.getVendaFomaPagamento());
            vendaSistema.setVendaData(venda.getVendaData());
            repository.save(vendaSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
