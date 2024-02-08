package ru.isands.elreg.mapper;

import ru.isands.elreg.dto.ProductDtoCreate;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.model.Product;

public class ProductMapper {
    public static Product toProduct(ProductDtoCreate dto) {
        Product result = new Product();
        result.setCategory(dto.getCategory());
        result.setName(dto.getName());
        result.setCountry(dto.getCountry());
        result.setCountry(dto.getCountry());
        result.setProducer(dto.getProducer());
        result.setOnlineOrdering(dto.getOnlineOrdering());
        result.setInstallment(dto.getInstallment());
        return result;
    }

    public static Product toProduct(ProductDtoUpdate dto, Product saved) {
        Product result = new Product();

        result.setId(saved.getId());

        if (dto.getName() == null) result.setName(saved.getName());
            else result.setName(dto.getName());

        if (dto.getCountry() == null) result.setCountry(saved.getCountry());
            else result.setCountry(dto.getCountry());

        if (dto.getProducer() == null) result.setProducer(saved.getProducer());
            else result.setProducer(dto.getProducer());
/*
        if (dto.getCategory() == null) result.setCategory(saved.getCategory());
            else result.setCategory(dto.getCategory());
*/
        if (dto.getOnlineOrdering() == null) result.setOnlineOrdering(saved.isOnlineOrdering());
            else result.setOnlineOrdering(dto.getOnlineOrdering());

        if (dto.getInstallment() == null) result.setInstallment(saved.isInstallment());
            else result.setInstallment(dto.getInstallment());

        return result;
    }
}
