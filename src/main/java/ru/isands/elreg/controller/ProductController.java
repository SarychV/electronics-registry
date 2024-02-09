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

import java.math.BigDecimal;
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
                                  @RequestBody @Valid ProductDtoUpdate productDto) {
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

    @GetMapping("/search")
    public List<Product> getSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) List<Category> category,
            @RequestParam(required = false) String colour,
            @RequestParam(required = false, name = "price_from") BigDecimal priceFrom,
            @RequestParam(required = false, name = "price_to") BigDecimal priceTo,
            @RequestParam(required = false, name = "tv_category") String tvCategory,
            @RequestParam(required = false, name = "tv_technology") String tvTechnology,
            @RequestParam(required = false, name = "cln_v_from") Integer clnVFrom,
            @RequestParam(required = false, name = "cln_v_to") Integer clnVTo,
            @RequestParam(required = false, name = "cln_modes_from") Integer clnModesFrom,
            @RequestParam(required = false, name = "cln_modes_to") Integer clnModesTo,
            @RequestParam(required = false, name = "frg_doors_from") Integer frgDoorsFrom,
            @RequestParam(required = false, name = "frg_doors_to") Integer frgDoorsTo,
            @RequestParam(required = false, name = "frg_compressor") String frgCompressorType,
            @RequestParam(required = false, name = "phn_mem_from")  Integer phnMemFrom,
            @RequestParam(required = false, name = "phn_mem_to") Integer phnMemTo,
            @RequestParam(required = false, name = "phn_cam_from") Integer phnCamFrom,
            @RequestParam(required = false, name = "phn_cam_to") Integer phnCamTo,
            @RequestParam(required = false, name = "comp_category") String computerCategory,
            @RequestParam(required = false, name = "comp_proc") String computerProcType
            ) {
        log.info("searchService.search() gets params: name={}, categories={}, colour={}, " +
                "priceFrom={}, priceTo={}, tvCategory={}, tvTechnology={}, clnVFrom={}, " +
                "clnVTo={}, clnModesFrom={}, clnModesTo={}, frgDoorsFrom={}, frgDoorsTo={}, " +
                "frgCompressorType={}, phnMemFrom={}, phnMemTo={}, phnCamFrom={}, phnCamTo={}, " +
                "computerCategory={}, computerProcType={}",
                name, category, colour, priceFrom, priceTo, tvCategory, tvTechnology, clnVFrom,
                clnVTo, clnModesFrom, clnModesTo, frgDoorsFrom, frgDoorsTo, frgCompressorType, phnMemFrom,
                phnMemTo, phnCamFrom, phnCamTo, computerCategory, computerProcType);

        return productService.search(name, category, colour, priceFrom, priceTo, tvCategory,
                tvTechnology, clnVFrom, clnVTo, clnModesFrom, clnModesTo, frgDoorsFrom, frgDoorsTo,
                frgCompressorType, phnMemFrom, phnMemTo, phnCamFrom, phnCamTo, computerCategory, computerProcType);
    }
}
