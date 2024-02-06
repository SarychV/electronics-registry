package ru.isands.elreg.service;

import ru.isands.elreg.dto.ProductDtoIn;
import ru.isands.elreg.dto.ProductDtoOut;
import ru.isands.elreg.model.Product;

import java.util.List;

public interface ProductService {
    ProductDtoOut create(ProductDtoIn prodDto);

    ProductDtoOut read(long productId);

    ProductDtoOut update(long productId, ProductDtoIn prodDto);

    void delete(long productId);

    List<ProductDtoOut> readAll();
}
