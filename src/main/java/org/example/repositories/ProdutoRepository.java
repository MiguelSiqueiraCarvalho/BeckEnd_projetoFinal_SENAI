package org.example.repositories;

import org.example.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT SUM(p.prodQtdEstoque) FROM Produto p")
    Long getTotalEstoque();
}