package ru.isands.elreg.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.isands.elreg.dto.ProductDtoCreate;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.exception.NotFoundException;
import ru.isands.elreg.mapper.ProductMapper;
import ru.isands.elreg.model.Category;
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
    public Product create(ProductDtoCreate productDto) {
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
            log.info("ProductServiceImpl.read(). Product with id={} not found", productId);
            throw new NotFoundException(
                    String.format("Product with id=%d not found", productId));
        } else {
            result = product.get();
            // TODO Вставить модели для этого продукта

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
            log.info("ProductServiceImpl.update(). Product with id=%d not found in database");
            throw new NotFoundException(
                    String.format("Product with id=%d not found in database", productId));
        }

        Product updatedProduct = ProductMapper.toProduct(productDto, oldProduct.get());

        log.info("productRepository.save() was invoked with updatedProduct={}", updatedProduct);
        result = productRepository.save(updatedProduct);

        // TODO Вставить модели для этого продукта
        result.setAvailableModels(List.of());

        log.info("ProductServiceImpl.update() returned result={}", result);
        return result;
    }

    @Override
    public void delete(long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            log.info("ProductServiceImpl.delete(). Product with id={} was deleted", productId);
        } else {
            log.info("ProductServiceImpl.delete(). Product with id={} not found", productId);
            throw new NotFoundException(
                    String.format("Product with id=%d not found", productId));
        }
    }

    @Override
    public List<Product> readAll(Category category) {
        List<Product> products;

        Sort sort = Sort.by("category", "producer", "name");

        if (category == null) {
            products = productRepository.findAll(sort);
        } else {
            products = productRepository.findAllByCategory(category, sort);
        }
        // TODO Встроить модели в список с продуктами
        log.info("ProductServiceImpl.readAll() returned result={}", products);
        return products;
    }
}
