package ru.isands.elreg.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.isands.elreg.service.ProductServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @MockBean
    ProductServiceImpl service;

    @Autowired
    ObjectMapper mapper;

    @Test
    void createProduct() {
    }

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