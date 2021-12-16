package com.estoque.produtobackend.tipoDeProduto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeProdutoRepositories extends JpaRepository<TipoDeProduto, Long> {
}
