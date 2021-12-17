package com.estoque.produtobackend;

import com.estoque.produtobackend.fornecedor.Fornecedor;
import com.estoque.produtobackend.fornecedor.FornecedorForm;
import com.estoque.produtobackend.produto.ProdutoForm;
import com.estoque.produtobackend.produto.ProdutoRepositories;
import com.estoque.produtobackend.tipoDeProduto.TipoDeProdutoForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEstoque {

    @Autowired
    private ProdutoRepositories repositories;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void incia() throws Exception {
        FornecedorForm fornecedorForm = new FornecedorForm("Samsung");

        mockMvc.perform(post("/fornecedor").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fornecedorForm)))
                .andReturn();

    }

    @Test
    @Order(1)
    public void verificarCadastro()throws Exception{

       FornecedorForm fornecedorForm = new FornecedorForm("Samsung");

       mockMvc.perform(post("/fornecedor").contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(fornecedorForm)))
               .andExpect(status().isOk())
               .andReturn();
    }

    @Test
    @Order(2)
    public void verificarFornecedor() throws Exception{
        FornecedorForm fornecedorForm = new FornecedorForm("Samsung");

        mockMvc.perform(post("/fornecedor").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fornecedorForm)))
                .andExpect(status().isBadRequest())
                .andReturn();

    }

}
