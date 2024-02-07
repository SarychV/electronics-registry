package ru.isands.elreg.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.isands.elreg.dto.ProductDtoIn;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.exception.NotFoundException;
import ru.isands.elreg.mapper.ProductMapper;
import ru.isands.elreg.model.Product;
import ru.isands.elreg.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(ProductDtoIn productDto) {
        Product result;
        Product newProduct = ProductMapper.toProduct(productDto);
        log.info("productRepository.save() was invoked with newProduct={}", newProduct);
        result = productRepository.save(newProduct);
        result.setAvailableModels(List.of());
        log.info("ProductServiceImpl.create() returned result={}", result);
        return result;
    }

    @Override
    public Product read(long productId) {
        Product result;
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            throw new NotFoundException(
                    String.format("Can't read object. Product with id=%d is not in database", productId));
        } else {
            result = product.get();
            // TODO. Вставить модели для этого продукта
            result.setAvailableModels(List.of());
            log.info("ProductServiceImpl.read() returned result={}", result);
            return result;
        }
    }

    @Override
    public Product update(long productId, ProductDtoUpdate productDto) {
        Product result;
        Optional<Product> oldProduct = productRepository.findById(productId);

        if (oldProduct.isEmpty()) {
            throw new NotFoundException(
                    String.format("Can't update object. Product with id=%d is not in database", productId));
        }

        Product updatedProduct = ProductMapper.toUpdatedProduct(productId, productDto, oldProduct.get());

        log.info("productRepository.save() was invoked with updatedProduct={}", updatedProduct);
        result = productRepository.save(updatedProduct);

        // TODO. Вставить модели для этого продукта
        result.setAvailableModels(List.of());

        log.info("ProductServiceImpl.update() returned result={}", result);
        return result;
    }

    @Override
    public void delete(long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            log.info("productRepository.delete(). Product with id={} was deleted", productId);
        } else {
            log.info("productRepository.delete(). Product with id={} is not in database", productId);
            throw new NotFoundException(
                    String.format("Can't find object. Product with id=%d is not in database", productId));
        }
    }

    @Override
    public List<Product> readAll() {
        List<Product> products = productRepository.findAll();
        // TODO Встроить модели в список с продуктами

        log.info("ProductServiceImpl.readAll() returned result={}", products);
        return products;
    }
}
