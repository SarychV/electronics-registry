package ru.isands.elreg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
import ru.isands.elreg.service.InitService;
import ru.isands.elreg.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/products")
@Tag(name = "Линейки ТС",
        description = "Контроллер для работы с реестром технических средств (ТС). " +
                "В реестре создаются разные линейки ТС (products), к ним относятся соответствующие модели ТС.")
public class ProductController {
    private final ProductService productService;
    private final InitService initService;

    public ProductController(ProductService productService,
                             InitService initService) {
        this.productService = productService;
        this.initService = initService;
    }

    @Operation(summary = "Создание новой линейки ТС")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(
            @RequestBody
            @Valid
            @Parameter(description = "Информация для создания REST-контроллером линейки ТС")
            ProductDtoCreate productDto) {
        log.info("productService.create() gets params: productDto={}", productDto);
        return productService.create(productDto);
    }

    @Operation(summary = "Обновление параметров линейки технических средств")
    @PatchMapping("/{productId}")
    public Product updateProduct(
            @PathVariable
            @Positive
            @Parameter(description = "Идентификатор линейки ТС")
            Long productId,

            @RequestBody
            @Valid
            @Parameter(description = "Информация для обновления REST-контроллером параметров линейки ТС ")
            ProductDtoUpdate productDto) {
        log.info("productService.update() gets params: productId={}, productDto={}", productId, productDto);
        return productService.update(productId, productDto);
    }

    @Operation(summary = "Получение информации о линейке ТС по идентификатору")
    @GetMapping("/{productId}")
    public Product getProduct(
            @PathVariable
            @Positive
            @Parameter(description = "Идентификатор линейки ТС")
            Long productId) {
        log.info("productService.read() gets params: productId={}", productId);
        return productService.read(productId);
    }

    @Operation(summary = "Получение информации о имеющихся в базе линейках ТС с возможностью фильтрации по категориям")
    @GetMapping()
    public List<Product> getProductList(
            @RequestParam(required = false)
            @Parameter(description = "Запрашиваемая категория ТС (необязательный параметр)")
            Category category) {
        log.info("productService.readAll() is invoked");
        return productService.readAll(category);
    }

    @Operation(summary = "Удаление линейки ТС из базы по ее идентификатору")
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(
            @PathVariable
            @Positive
            @Parameter(description = "Идентификатор удаляемой линейки ТС")
            Long productId) {
        log.info("productService.delete() gets params: productId={}", productId);
        productService.delete(productId);
    }

    @Operation(summary = "Поиск ТС по реквизитам. Параметры определяются по необходимости")
    @GetMapping("/search")
    public List<Product> getSearch(
            @RequestParam(required = false)
            @Parameter(description = "Имя линейки ТС или модели ТС")
            String name,

            @RequestParam(required = false)
            @Parameter(description = "Категории ТС (одновременно может задаваться несколько категорий)")
            List<Category> category,

            @RequestParam(required = false)
            @Parameter(description = "Цвет модели ТС")
            String colour,

            @RequestParam(required = false, name = "price_from")
            @Parameter(description = "Наименьшая цена модели")
            BigDecimal priceFrom,

            @RequestParam(required = false, name = "price_to")
            @Parameter(description = "Наибольшая цена модели")
            BigDecimal priceTo,

            @RequestParam(required = false, name = "tv_category")
            @Parameter(description = "Категория телевизора")
            String tvCategory,

            @RequestParam(required = false, name = "tv_technology")
            @Parameter(description = "Технология телевизора")
            String tvTechnology,

            @RequestParam(required = false, name = "cln_v_from")
            @Parameter(description = "Наименьший объем пылесборника у пылесоса")
            Integer clnVFrom,

            @RequestParam(required = false, name = "cln_v_to")
            @Parameter(description = "Наибольший объем пылесборника у пылесоса")
            Integer clnVTo,

            @RequestParam(required = false, name = "cln_modes_from")
            @Parameter(description = "Наименьшее количество режимов у пылесоса")
            Integer clnModesFrom,

            @RequestParam(required = false, name = "cln_modes_to")
            @Parameter(description = "Наибольшее количество режимов у пылесоса")
            Integer clnModesTo,

            @RequestParam(required = false, name = "frg_doors_from")
            @Parameter(description = "Наименьшее количество дверей у холодильника")
            Integer frgDoorsFrom,

            @RequestParam(required = false, name = "frg_doors_to")
            @Parameter(description = "Наибольшее количество дверей у холодильника")
            Integer frgDoorsTo,

            @RequestParam(required = false, name = "frg_compressor")
            @Parameter(description = "Тип компрессора у холодильника")
            String frgCompressorType,

            @RequestParam(required = false, name = "phn_mem_from")
            @Parameter(description = "Наименьшее количество памяти у смартфона")
            Integer phnMemFrom,

            @RequestParam(required = false, name = "phn_mem_to")
            @Parameter(description = "Наибольшее количество памяти у смартфона")
            Integer phnMemTo,

            @RequestParam(required = false, name = "phn_cam_from")
            @Parameter(description = "Наименьшее количество камер у смартфона")
            Integer phnCamFrom,

            @RequestParam(required = false, name = "phn_cam_to")
            @Parameter(description = "Наибольшее количество камер у смартфона")
            Integer phnCamTo,

            @RequestParam(required = false, name = "comp_category")
            @Parameter(description = "Категория компьютера")
            String computerCategory,

            @RequestParam(required = false, name = "comp_proc")
            @Parameter(description = "Тип процессора у компьютера")
            String computerProcType) {
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

    @Operation(summary = "Инициализация базы набором данных")
    @PostMapping("/init")
    void initDatabase() {
        initService.initDatabase();
    }
}
