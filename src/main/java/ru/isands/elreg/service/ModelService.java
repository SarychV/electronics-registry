package ru.isands.elreg.service;

import ru.isands.elreg.dto.ModelDtoCreate;
import ru.isands.elreg.dto.ModelDtoUpdate;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Model;
import ru.isands.elreg.model.Sorting;

import java.util.List;

public interface ModelService {
    Model create(ModelDtoCreate modelDto);

    Model read(long modelId);

    List<Model> readAll(Category category, Sorting sort);

    Model update(long modelId, ModelDtoUpdate modelDto);

    void delete(long modelId);
}
