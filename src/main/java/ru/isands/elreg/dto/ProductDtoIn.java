package ru.isands.elreg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.isands.elreg.model.Category;

public class ProductDtoIn {
    Category category;

    @NotBlank
    @Size(min = 1, max = 100)
    String name;

    @NotBlank
    @Size(min = 1, max = 50)
    String country;

    @NotBlank
    @Size(min = 1, max = 50)
    String producer;

    Boolean online = false;
    Boolean installment = false;
}
