package ru.isands.elreg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Модели ТС", description = "Контроллер для работы с моделями технических средств. ")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }


    @Operation(summary = "Создание новой модели")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Model createModel(
            @RequestBody
            @Valid
            @Parameter(description = "Информация для создания REST-контроллером модели ТС")
            ModelDtoCreate modelDto) {
        log.info("modelService.create() gets params: modelDto={}", modelDto);
        return modelService.create(modelDto);
    }

    @Operation(summary = "Обновление параметров модели")
    @PatchMapping("/{modelId}")
    public Model updateModel(
            @PathVariable
            @Positive
            @Parameter(description = "Идентификатор модели ТС")
            Long modelId,

            @RequestBody
            @Valid
            @Parameter(description = "Информация для обновления REST-контроллером модели ТС")
            ModelDtoUpdate modelDto) {
        log.info("modelService.update() gets params: modelId={}, modelDto={}", modelId, modelDto);
        return modelService.update(modelId, modelDto);
    }

    @Operation(summary = "Получение информации о модели по идентификатору")
    @GetMapping("/{modelId}")
    public Model getModel(
            @PathVariable
            @Positive
            @Parameter(description = "Идентификатор модели ТС")
            Long modelId) {
        log.info("modelService.read() gets params: modelId={}", modelId);
        return modelService.read(modelId);
    }

    @Operation(summary = "Получение информации об имеющихся в базе моделях с возможностью фильтрации по категориям")
    @GetMapping()
    public List<Model> getModelList(
            @RequestParam(required = false)
            @Parameter(description = "Категория ТС (необязательный параметр)")
            Category category,

            @RequestParam(required = false, defaultValue = "LEXICAL")
            @Parameter(description = "Порядок сортировки")
            Sorting sort) {
        log.info("modelService.readAll() is invoked with category={}, sort={}", category, sort);
        return modelService.readAll(category, sort);
    }

    @Operation(summary = "Удаление модели из базы по идентификатору")
    @DeleteMapping("/{modelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModel(
            @PathVariable
            @Positive
            @Parameter(description = "Индентификатор модели ТС")
            Long modelId) {
        log.info("modelService.delete() gets params: modelId={}", modelId);
        modelService.delete(modelId);
    }
}
