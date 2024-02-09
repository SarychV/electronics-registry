package ru.isands.elreg.service;

import ru.isands.elreg.dto.ProductDtoCreate;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product create(ProductDtoCreate prodDto);

    Product read(long productId);

    Product update(long productId, ProductDtoUpdate prodDto);

    void delete(long productId);

    List<Product> readAll(Category category);

    List<Product> search(String name, List<Category> categories, String colour, BigDecimal priceFrom,
                  BigDecimal priceTo, String tvCategory, String tvTechnology, Integer clnVFrom, Integer clnVTo,
                  Integer clnModesFrom, Integer clnModesTo, Integer frgDoorsFrom, Integer frgDoorsTo,
                  String frgCompressorType, Integer phnMemFrom, Integer phnMemTo, Integer phnCamFrom, Integer phnCamTo,
                  String computerCategory, String computerProcType);
}
