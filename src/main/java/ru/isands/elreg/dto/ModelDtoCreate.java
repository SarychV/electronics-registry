package ru.isands.elreg.dto;

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
    protected Long productId;               // Уникальный идентификатор продукта, к которому относится модель

    @NotBlank
    @Size(max = 100)
    private String name;                    // Наименование

    @NotBlank
    @Size(max = 10)
    private String serialNumber;            // Серийный номер

    @Size(max = 15)
    private String colour;                  // Цвет

    @PositiveOrZero
    private Integer length = 0;             // Длина в милиметрах

    @PositiveOrZero
    private Integer width = 0;              // Ширина в милиметрах

    @PositiveOrZero
    private Integer height = 0;             // Высота в милиметрах

    @PositiveOrZero
    private BigDecimal price;               // Цена

    private Boolean available;              // Наличие товара


    // Параметры для категории TV
    @Size(max = 50)
    private String tvCategory;              // Категория телевизора

    @Size(max = 20)
    private String technology;              // Технология


    // Параметры для категории CLEANER
    @Positive
    private Integer containerVolume;        // Объем контейнера в милилитрах

    @Positive
    private Integer numModes;               // Количество режимов


    // Параметры для категории COMPUTER
    @Size(max = 30)
    private String computerCategory;        // Категория компьютера

    @Size(max = 30)
    private String processorType;           // Тип процессора


    // Параметры для категории FRIDGE
    @Positive
    private Integer numDoors;               // Количество дверей

    @Size(max = 30)
    private String compressorType;          // Тип компрессора


    // Параметры для категории PHONE
    @Positive
    private Integer memory;                 // Количество памяти в мегабайтах

    @Positive
    private Integer numCameras;             // Количество камер
}
