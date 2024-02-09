package ru.isands.elreg.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Setter
@Getter
@ToString
public class ModelDtoCreate {
    @NotNull
    @Positive
    @Schema(description = "Уникальный идентификатор продукта, к которому относится модель")
    protected Long productId;

    @NotBlank
    @Size(max = 100)
    @Schema(description = "Наименование")
    private String name;

    @NotBlank
    @Size(max = 10)
    @Schema(description = "Серийный номер")
    private String serialNumber;

    @Size(max = 15)
    @Schema(description = "Цвет")
    private String colour;

    @PositiveOrZero
    @Schema(description = "Длина в милиметрах")
    private Integer length = 0;

    @PositiveOrZero
    @Schema(description = "Ширина в милиметрах")
    private Integer width = 0;

    @PositiveOrZero
    @Schema(description = "Высота в милиметрах")
    private Integer height = 0;

    @PositiveOrZero
    @Schema(description = "Цена")
    private BigDecimal price;

    @Schema(description = "Наличие товара")
    private Boolean available;


    // Параметры для категории TV
    @Size(max = 50)
    @Schema(description = "Категория телевизора")
    private String tvCategory;

    @Size(max = 20)
    @Schema(description = "Технология")
    private String technology;


    // Параметры для категории CLEANER
    @Positive
    @Schema(description = "Объем контейнера в милилитрах")
    private Integer containerVolume;

    @Positive
    @Schema(description = "Количество режимов")
    private Integer numModes;


    // Параметры для категории COMPUTER
    @Size(max = 30)
    @Schema(description = "Категория компьютера")
    private String computerCategory;

    @Size(max = 30)
    @Schema(description = "Тип процессора")
    private String processorType;


    // Параметры для категории FRIDGE
    @Positive
    @Schema(description = "Количество дверей")
    private Integer numDoors;

    @Size(max = 30)
    @Schema(description = "Тип компрессора")
    private String compressorType;


    // Параметры для категории PHONE
    @Positive
    @Schema(description = "Количество памяти в мегабайтах")
    private Integer memory;

    @Positive
    @Schema(description = "Количество камер")
    private Integer numCameras;
}