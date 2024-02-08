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
    // Category category;
    // Возможность смены категории для изделий убрана.
    // Смена категории приводит к необходимой смене типов записей в моделях техники
    // (меняется состав дополнительных атрибутов). Реализация этой возможности приведет к рассогласованности базы.
    //
    // Вариантом решения проблемы является проверка наличия моделей у продукта.
    // Если модели есть, то смена категории невозможна. Если нет, то можно сменить категорию продукта.
    // TODO Релизовать проверку наличия моделей у продукта. В случае остутствия, провести смену категории.

    @Size(min = 2, max = 100)
    String name;

    @Size(min = 2, max = 50)
    String country;

    @Size(max = 50)
    String producer;

    Boolean onlineOrdering;
    Boolean installment;
}