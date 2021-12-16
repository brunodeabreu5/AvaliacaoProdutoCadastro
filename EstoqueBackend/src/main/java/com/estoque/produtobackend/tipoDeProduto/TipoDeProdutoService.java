package com.estoque.produtobackend.tipoDeProduto;

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
public class TipoDeProdutoService {

    @Autowired
    private TipoDeProdutoRepositories repositories;

    Logger logger = LoggerFactory.getLogger(TipoDeProduto.class);

    public List<TipoDeProdutoDto> findAll() {
        List<TipoDeProduto> tipoDeProdutos = repositories.findAll();
        return tipoDeProdutos.stream().map(TipoDeProdutoDto::from).collect(toList());
    }

    public TipoDeProdutoDto create(TipoDeProdutoForm tipoDeProdutoForm) {
        TipoDeProduto tipoDeProduto= TipoDeProduto.from(tipoDeProdutoForm);
        return TipoDeProdutoDto.from(repositories.save(tipoDeProduto));
    }

    public TipoDeProdutoDto findById(Long id) {
        return TipoDeProdutoDto.from(repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }));
    }

    public TipoDeProdutoDto update(Long id, TipoDeProdutoForm tipoDeProdutoForm) {
        ModelMapper modelMapper = new ModelMapper();
        TipoDeProduto tipoDeProduto = repositories.findById(id).orElseThrow(() -> {
            logger.error("Id not{}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.map(tipoDeProdutoForm, tipoDeProduto);
        return TipoDeProdutoDto.from(repositories.save(tipoDeProduto));
    }

    public void delete(Long id) {
        TipoDeProduto produto = repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        repositories.delete(produto);
    }
}
