package com.estoque.produtobackend.estoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepositories extends JpaRepository<Estoque, Long> {
}
