package ru.isands.elreg.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.elreg.dto.ModelDtoCreate;
import ru.isands.elreg.dto.ModelDtoUpdate;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Model;
import ru.isands.elreg.model.Sorting;
import ru.isands.elreg.service.ModelService;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Model createModel(@RequestBody @Valid ModelDtoCreate modelDto) {
        log.info("modelService.create() gets params: modelDto={}", modelDto);
        return modelService.create(modelDto);
    }

    @PatchMapping("/{modelId}")
    public Model updateModel(@PathVariable @Positive Long modelId,
                                  @RequestBody ModelDtoUpdate modelDto) {
        log.info("modelService.update() gets params: modelId={}, modelDto={}", modelId, modelDto);
        return modelService.update(modelId, modelDto);
    }

    @GetMapping("/{modelId}")
    public Model getModel(@PathVariable @Positive Long modelId) {
        log.info("modelService.read() gets params: modelId={}", modelId);
        return modelService.read(modelId);
    }

    @GetMapping()
    public List<Model> getModelList(@RequestParam(required = false) Category category,
                                    @RequestParam(required = false, defaultValue = "LEXICAL") Sorting sort) {
        log.info("modelService.readAll() is invoked with category={}, sort={}", category, sort);
        return modelService.readAll(category, sort);
    }

    @DeleteMapping("/{modelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModel(@PathVariable @Positive Long modelId) {
        log.info("modelService.delete() gets params: modelId={}", modelId);
        modelService.delete(modelId);
    }
}
