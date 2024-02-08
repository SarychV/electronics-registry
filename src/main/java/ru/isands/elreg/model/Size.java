package ru.isands.elreg.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Embeddable
public class Size {
    private int length;     // Длина в милиметрах

    private int width;      // Ширина в милиметрах

    private int height;     // Высота в милиметрах
}
