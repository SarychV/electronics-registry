package ru.isands.elreg.service;

import ru.isands.elreg.dto.ProductDtoIn;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.model.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDtoIn prodDto);

    Product read(long productId);

    Product update(long productId, ProductDtoUpdate prodDto);

    void delete(long productId);

    List<Product> readAll();
}
