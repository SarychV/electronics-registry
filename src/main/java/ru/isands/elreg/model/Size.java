package ru.isands.elreg.model;

import jakarta.persistence.Embeddable;
import lombok.ToString;

@ToString
@Embeddable
public class Size {
    private int length;     // Длина в милиметрах

    private int width;      // Ширина в милиметрах

    private int height;     // Высота в милиметрах
}
