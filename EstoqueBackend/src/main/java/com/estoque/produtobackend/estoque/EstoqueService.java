package com.estoque.produtobackend.estoque;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class EstoqueService {

    private EstoqueRepositories repositories;

    Logger logger = LoggerFactory.getLogger(EstoqueService.class);

    public EstoqueService(EstoqueRepositories repositories) {
        this.repositories = repositories;
    }

    public List<EstoqueDto> findAll() {
        List<Estoque> estoques = repositories.findAll();
        return estoques.stream().map(EstoqueDto::from).collect(toList());
    }

    public EstoqueDto create(EstoqueForm estoqueForm) {
        Estoque estoque = Estoque.from(estoqueForm);
        return EstoqueDto.from(repositories.save(estoque));
    }

    public EstoqueDto findById(long id) {
        return EstoqueDto.from(repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }));
    }

    public EstoqueDto update(long id, EstoqueForm estoqueForm) {
        ModelMapper modelMapper = new ModelMapper();
        Estoque estoque = repositories.findById(id).orElseThrow(() -> {
            logger.error("Id not{}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.map(estoqueForm, estoque);
        return EstoqueDto.from(repositories.save(estoque));
    }

    public void delete(long id) {
        Estoque estoque = repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        repositories.delete(estoque);
    }

}
