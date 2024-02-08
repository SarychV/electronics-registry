package ru.isands.elreg.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.isands.elreg.dto.ProductDtoCreate;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Product;
import ru.isands.elreg.service.ProductServiceImpl;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @MockBean
    ProductServiceImpl service;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mvc;

    ProductDtoCreate productDto = new ProductDtoCreate();
    Product product = new Product();

    @BeforeEach
    void initProductDtoIn() {
        productDto.setCategory(Category.TV);
        productDto.setName("Product name");
        productDto.setCountry("Russia");
        productDto.setProducer("Product producer");
        productDto.setOnlineOrdering(true);
        productDto.setInstallment(true);

        product.setId(1L);
        product.setCategory(Category.TV);
        product.setName("Product name");
        product.setCountry("Russia");
        product.setProducer("Product producer");
        product.setOnlineOrdering(true);
        product.setInstallment(true);
        product.setAvailableModels(null);
    }

    @Test
    void whenCreateProduct_thenIsOk() throws Exception {
        Mockito.when(service.create(any(ProductDtoCreate.class)))
                .thenReturn(product);

        mvc.perform(post("/products")
                        .content(mapper.writeValueAsString(productDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is((int) product.getId())))
                .andExpect(jsonPath("$.category", is(product.getCategory().name())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.country", is(product.getCountry())))
                .andExpect(jsonPath("$.producer", is(product.getProducer())))
                .andExpect(jsonPath("$.onlineOrdering", is(product.isOnlineOrdering())))
                .andExpect(jsonPath("$.installment", is(product.isInstallment())))
                .andExpect(jsonPath("$.availableModels", is(product.getAvailableModels())));
    }

/*
    @Test
    public void whenNameIsVeryLong_thenThrowException() throws Exception {
        String more100symbols = "01234567890123456789012345678901234567890123456789" +
                "0123456789012345678901234567890123456789012345678";
        productDto.setName(more100symbols);

        Mockito.when(service.create(any(ProductDtoIn.class)))
                .thenReturn(product);

        mvc.perform(post("/products")
                        .content(mapper.writeValueAsString(productDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is((int) product.getId())))
                .andExpect(jsonPath("$.category", is(product.getCategory().name())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.country", is(product.getCountry())))
                .andExpect(jsonPath("$.producer", is(product.getProducer())))
                .andExpect(jsonPath("$.onlineOrdering", is(product.isOnlineOrdering())))
                .andExpect(jsonPath("$.installment", is(product.isInstallment())))
                .andExpect(jsonPath("$.availableModels", is(product.getAvailableModels())));
    }
*/
    @Test
    void updateProduct() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void getProductList() {
    }

    @Test
    void deleteProduct() {
    }
}