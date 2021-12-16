package com.estoque.produtobackend.fornecedor;

import com.estoque.produtobackend.produto.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepositories repositories;

    Logger logger = LoggerFactory.getLogger(FornecedorService.class);

    public List<Fo> findAll() {
        List<Produto> produtos = repositories.findAll();
        return produtos.stream().map(ProdutoDto::from).collect(toList());
    }

    public ProdutoDto create(ProdutoForm produtoForm) {
        Produto produto= Produto.from(produtoForm);
        return ProdutoDto.from(repositories.save(produto));
    }

    public ProdutoDto findById(Long id) {
        return ProdutoDto.from(repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }));
    }

    public ProdutoDto update(Long id, ProdutoForm produtoForm) {
        ModelMapper modelMapper = new ModelMapper();
        Produto produto = repositories.findById(id).orElseThrow(() -> {
            logger.error("Id not{}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.map(produtoForm, produto);
        return ProdutoDto.from(repositories.save(produto));
    }

    public void delete(Long id) {
        Produto produto = repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        repositories.delete(produto);
    }
}
