package ru.isands.elreg.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.elreg.dto.ProductDtoCreate;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Product;
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
    public Product createProduct(@RequestBody @Valid ProductDtoCreate productDto) {
        log.info("productService.create() gets params: productDto={}", productDto);
        return productService.create(productDto);
    }

    @PatchMapping("/{productId}")
    public Product updateProduct( @PathVariable @Positive Long productId,
                                        @RequestBody ProductDtoUpdate productDto) {
        log.info("productService.update() gets params: productId={}, productDto={}", productId, productDto);
        return productService.update(productId, productDto);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable @Positive Long productId) {
        log.info("productService.read() gets params: productId={}", productId);
        return productService.read(productId);
    }

    @GetMapping()
    public List<Product> getProductList(
            @RequestParam(required = false) Category category) {
        log.info("productService.readAll() is invoked");
        return productService.readAll(category);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable @Positive Long productId) {
        log.info("productService.delete() gets params: productId={}", productId);
        productService.delete(productId);
    }
}
