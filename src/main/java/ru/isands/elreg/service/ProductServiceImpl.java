package ru.isands.elreg.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.isands.elreg.dto.ProductDtoCreate;
import ru.isands.elreg.dto.ProductDtoUpdate;
import ru.isands.elreg.exception.NotFoundException;
import ru.isands.elreg.mapper.ProductMapper;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Model;
import ru.isands.elreg.model.Product;
import ru.isands.elreg.repository.ModelRepository;
import ru.isands.elreg.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelRepository modelRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ModelRepository modelRepository) {
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
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

            // Вставить модели для этого продукта
            result = injectModelsToProducts(List.of(result)).get(0);

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

        // Вставить модели для этого продукта
        result = injectModelsToProducts(List.of(result)).get(0);

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
        // Встроить модели в список с продуктами
        products = injectModelsToProducts(products);

        log.info("ProductServiceImpl.readAll() returned result={}", products);
        return products;
    }

    List<Product> injectModelsToProducts(List<Product> products) {
        // Получить список идентификаторов продуктов
        List<Long> productIndexes = products
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList());
        // Задать сортировку по цене
        Sort sort = Sort.by(Sort.Direction.DESC, "price");
        // Получить модели, у которых productId из полученного выше списка
        List<Model> models = modelRepository.findAllByProductIdIn(productIndexes, sort);

        // Сгруппировать модели по productId
        HashMap<Long, List<Model>> groupedModels = groupModelsByProductId(models);

        // Связать продукты и списки моделей
        products = bindProductsWithModels(products, groupedModels);
        return products;
    }

    HashMap<Long, List<Model>> groupModelsByProductId(List<Model> models) {
        HashMap<Long, List<Model>> result = new HashMap<>();  // productId -> List<Model>
        for (Model model: models) {
            List<Model> listInGroup = result.get(model.getProductId());

            if (listInGroup != null) {
                listInGroup.add(model);
            } else {
                result.put(model.getProductId(), new ArrayList<Model>(List.of(model)));
            }
        }
        return result;
    }

    List<Product> bindProductsWithModels(List<Product> products, HashMap<Long, List<Model>> models) {
        return products.stream()
                .peek(product -> {
                    long id = product.getId();
                    List<Model> modelList = models.get(id);

                    // Если для продукта отсутствует перечень моделей, присвоить продукту пустой перечень моделей
                    if (modelList == null) modelList = new ArrayList<>();
                    product.setAvailableModels(modelList);
                })
                .collect(Collectors.toList());
    }
}


