package com.estoque.produtobackend.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositories extends JpaRepository<Produto, Integer> {
}
