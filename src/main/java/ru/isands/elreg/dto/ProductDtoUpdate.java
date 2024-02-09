package ru.isands.elreg.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDtoUpdate {
    // Category category;
    // Возможность смены категории продукта убрана.
    // Смена категории приводит к необходимой смене типов записей в моделях техники
    // (меняется состав дополнительных атрибутов). Реализация этой возможности приведет к рассогласованности базы.
    //
    // Вариантом решения проблемы является проверка наличия моделей у продукта.
    // Если модели есть, то смена категории невозможна. Если нет, то можно сменить категорию продукта.
    // TODO Релизовать проверку наличия моделей у продукта. В случае остутствия, провести смену категории.

    @Size(min = 2, max = 100)
    @Schema(description = "Наименование")
    String name;

    @Size(min = 2, max = 50)
    @Schema(description = "Страна производитель")
    String country;

    @Size(max = 50)
    @Schema(description = "Фирма производитель")
    String producer;

    @Schema(description = "Существует ли возможность заказать онлайн")
    Boolean onlineOrdering;

    @Schema(description = "Можно ли приобрести в рассрочку")
    Boolean installment;
}