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

    public List<FornecedorDto> findAll() {
        List<Fornecedor> fornecedors = repositories.findAll();
        return fornecedors.stream().map(FornecedorDto::from).collect(toList());
    }

    public FornecedorDto create(FornecedorForm fornecedorForm) {
        Fornecedor fornecedor= Fornecedor.from(fornecedorForm);
        return FornecedorDto.from(repositories.save(fornecedor));
    }

    public FornecedorDto findById(Long id) {
        return FornecedorDto.from(repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }));
    }

    public FornecedorDto update(Long id, FornecedorForm fornecedorForm) {
        ModelMapper modelMapper = new ModelMapper();
        Fornecedor fornecedor = repositories.findById(id).orElseThrow(() -> {
            logger.error("Id not{}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.map(fornecedorForm, fornecedor);
        return FornecedorDto.from(repositories.save(fornecedor));
    }

    public void delete(Long id) {
        Fornecedor fornecedor = repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        repositories.delete(fornecedor);
    }
}
