package ru.isands.elreg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.isands.elreg.model.Category;

@Setter
@Getter
@ToString
public class ProductDtoCreate {
    @NotNull
    Category category;

    @NotBlank
    @Size(min = 2, max = 100)
    String name;

    @NotBlank
    @Size(min = 2, max = 50)
    String country;

    @NotBlank
    @Size(max = 50)
    String producer;

    Boolean onlineOrdering = false;
    Boolean installment = false;
}
