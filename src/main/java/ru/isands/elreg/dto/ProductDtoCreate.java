package ru.isands.elreg.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Категория техники")
    Category category;

    @NotBlank
    @Size(min = 2, max = 100)
    @Schema(description = "Наименование")
    String name;

    @NotBlank
    @Size(min = 2, max = 50)
    @Schema(description = "Страна производитель")
    String country;

    @NotBlank
    @Size(max = 50)
    @Schema(description = "Фирма производитель")
    String producer;

    @Schema(description = "Существует ли возможность заказать онлайн")
    Boolean onlineOrdering = false;

    @Schema(description = "Можно ли приобрести в рассрочку")
    Boolean installment = false;
}
