package ru.isands.elreg.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import ru.isands.elreg.dto.ModelDtoCreate;
import ru.isands.elreg.dto.ModelDtoUpdate;
import ru.isands.elreg.exception.BadRequestException;
import ru.isands.elreg.exception.NotFoundException;
import ru.isands.elreg.model.Model;
import ru.isands.elreg.model.Product;
import ru.isands.elreg.model.Sorting;
import ru.isands.elreg.repository.ModelRepository;
import ru.isands.elreg.repository.ProductRepository;

import java.util.*;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.mapper.ModelMapper;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ProductRepository productRepository;

    public ModelServiceImpl(ModelRepository modelRepository,
                            ProductRepository productRepository) {
        this.modelRepository = modelRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Model create(ModelDtoCreate modelDto) {
        Model result;
        long productId = modelDto.getProductId();
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            log.info("ModelServiceImpl.create(). Product with id={} not found");
            throw new BadRequestException(
                    String.format("Product with id=%d not found", productId));
        }

        Category modelCategory = product.get().getCategory();
        Model newModel = ModelMapper.toModel(modelDto, modelCategory);

        log.info("ModelRepository.save() was invoked with newModel={}", newModel);
        result = modelRepository.save(newModel);
        log.info("ModelServiceImpl.create() returned result={}", result);
        return result;
    }

    @Override
    public Model read(long modelId) {
        Model result;
        Optional<Model> model = modelRepository.findById(modelId);
        if (model.isEmpty()) {
            log.info("ModelServiceImpl.read(). Model with id={} not found", modelId);
            throw new NotFoundException(
                    String.format("Model with id=%d not found", modelId));
        }
        result = model.get();
        log.info("ModelServiceImpl.read() returned result={}", result);
        return result;
    }

    @Override
    public List<Model> readAll(Category category, Sorting sortingType) {
        List<Model> result;

        Sort sort = selectModelSorting(sortingType);

        if (category == null) {
            result = modelRepository.findAll(sort);
        } else {
            result = modelRepository.findAllByProductCategory(category, sort);
        }
        log.info("ModelServiceImpl.readAll() returned result={}", result);
        return result;
    }

    @Override
    public Model update(long modelId, ModelDtoUpdate modelDto) {
        Model result;
        Optional<Model> oldModel = modelRepository.findById(modelId);

        if (oldModel.isEmpty()) {
            log.info("ModelServiceImpl.update(). Model with id={} not found");
            throw new NotFoundException(
                    String.format("Model with id=%d not found", modelId));
        }

        Model updatedModel = ModelMapper.toModel(modelDto, oldModel.get());

        log.info("ModelRepository.save() was invoked with updatedModel={}", updatedModel);
        result = modelRepository.save(updatedModel);

        log.info("ModelServiceImpl.update() returned result={}", result);
        return result;
    }

    @Override
    public void delete(long modelId) {
        if (modelRepository.existsById(modelId)) {
            modelRepository.deleteById(modelId);
            log.info("ModelServiceImpl.delete(). Model with id={} was deleted", modelId);
        } else {
            log.info("ModelServiceImpl.delete(). Model with id={} not found", modelId);
            throw new NotFoundException(
                    String.format("Model with id=%d not found", modelId));
        }
    }

    Sort selectModelSorting(Sorting sortingType) {
        return switch (sortingType) {
            case PRICE -> Sort.by(Sort.Direction.DESC, "price");
            case LEXICAL -> Sort.by("name");
        };
    }
}
