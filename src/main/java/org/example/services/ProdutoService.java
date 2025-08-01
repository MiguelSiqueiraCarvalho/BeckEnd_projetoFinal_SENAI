package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.ProdutoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto insert(Produto produto) {
        if (produto.getFornecedor() == null || produto.getFornecedor().getForId() == null) {
            throw new IllegalArgumentException("Fornecedor deve ser informado");
        }

        Long fornecedorId = produto.getFornecedor().getForId();
        var fornecedor = fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com id: " + fornecedorId));

        produto.setFornecedor(fornecedor);

        return repository.save(produto);
    }

    public boolean update(Long id, Produto produto) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produtoSistema = optionalProduto.get();
            produtoSistema.setProdNome(produto.getProdNome());
            produtoSistema.setProdPrecoCusto(produto.getProdPrecoCusto());
            produtoSistema.setProdPrecoVenda(produto.getProdPrecoVenda());
            produtoSistema.setProdQtdEstoque(produto.getProdQtdEstoque());
            produtoSistema.setProdCategoria(produto.getProdCategoria());
            produtoSistema.setProdMarca(produto.getProdMarca());

            if (produto.getFornecedor() != null && produto.getFornecedor().getForId() != null) {
                var fornecedor = fornecedorRepository.findById(produto.getFornecedor().getForId())
                        .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com id: " + produto.getFornecedor().getForId()));
                produtoSistema.setFornecedor(fornecedor);
            }

            repository.save(produtoSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
