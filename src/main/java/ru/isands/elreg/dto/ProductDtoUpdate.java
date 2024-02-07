package ru.isands.elreg.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.isands.elreg.model.Category;

@Setter
@Getter
@ToString
public class ProductDtoUpdate {
    Category category;
    @Size(min = 2, max = 100)
    String name;

    @Size(min = 2, max = 50)
    String country;

    @Size(max = 50)
    String producer;

    Boolean onlineOrdering;
    Boolean installment;
}