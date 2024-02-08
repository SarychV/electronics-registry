package ru.isands.elreg.service;

import ru.isands.elreg.dto.ProductDtoCreate;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDtoCreate prodDto);

    Product read(long productId);

    Product update(long productId, ProductDtoUpdate prodDto);

    void delete(long productId);

    List<Product> readAll(Category category);
}
