package ru.isands.elreg.service;

import org.springframework.stereotype.Service;
import ru.isands.elreg.dto.ProductDtoIn;
import ru.isands.elreg.dto.ProductDtoOut;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDtoOut create(ProductDtoIn prodDto) {
        return null;
    }

    @Override
    public ProductDtoOut read(long productId) {
        return null;
    }

    @Override
    public ProductDtoOut update(long productId, ProductDtoIn prodDto) {
        return null;
    }

    @Override
    public void delete(long productId) {

    }

    @Override
    public List<ProductDtoOut> readAll() {
        return null;
    }
}
