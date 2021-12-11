package com.estoque.produtobackend.produto;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositories repositories;

    Logger logger = LoggerFactory.getLogger(ProdutoService.class);

    public List<ProdutoDto> findAll() {
        List<Produto> result = repositories.findAll();
        return result.stream().map(ProdutoDto::from).collect(toList());
    }

    public ProdutoDto create(ProdutoForm produtoForm) {
        Produto produto = Produto.from(produtoForm);
        return ProdutoDto.from(repositories.save(produto));
    }

    public ProdutoDto findById(Integer id) {
        Optional<Produto> produto = repositories.findById(id);
        return ProdutoDto.from(produto.get());
    }

    public ProdutoDto update(int id, ProdutoForm produtoForm) {
        ModelMapper modelMapper = new ModelMapper();
        Produto produto = repositories.findById(id).orElseThrow(() -> {
            logger.error("Id not{}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.map(produtoForm, produto);
        return ProdutoDto.from(repositories.save(produto));
    }

    public void delete(int id) {
        Produto produto = repositories.findById(id).orElseThrow(() -> {
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        repositories.delete(produto);
    }
    public ProdutoDto findById(int id) {
        return ProdutoDto.from(repositories.findById(id).orElseThrow(()->{
            logger.error("id não existe", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }));
    }

}
