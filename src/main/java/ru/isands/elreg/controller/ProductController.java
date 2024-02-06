package ru.isands.elreg.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.elreg.dto.ProductDtoIn;
import ru.isands.elreg.dto.ProductDtoOut;
import ru.isands.elreg.service.ProductService;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDtoOut createProduct(@RequestBody @Valid ProductDtoIn productDto) {
        log.info("productService.create() gets params: productDto={}", productDto);
        return productService.create(productDto);
    }

    @PatchMapping("/{productId}")
    public ProductDtoOut updateProduct( @PathVariable @Positive Long productId,
                                        @RequestBody @Valid ProductDtoIn productDto) {
        log.info("productService.update() gets params: productId={}, productDto={}", productId, productDto);
        return productService.update(productId, productDto);
    }

    @GetMapping("/{productId}")
    public ProductDtoOut getProduct(@PathVariable @Positive Long productId) {
        log.info("productService.read() gets params: productId={}", productId);
        return productService.read(productId);
    }

    @GetMapping()
    public List<ProductDtoOut> getProductList() {
        log.info("productService.readAll() is invoked");
        return productService.readAll();
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable @Positive Long productId) {
        log.info("productService.delete() gets params: productId={}", productId);
        productService.delete(productId);
    }
}
