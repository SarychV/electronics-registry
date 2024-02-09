package ru.isands.elreg.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Schema(description = "Габаритные размеры технического средства")
@Setter
@Getter
@ToString
@Embeddable
public class Size {
    @Schema(description = "Длина в милиметрах")
    private int length;

    @Schema(description = "Ширина в милиметрах")
    private int width;

    @Schema(description = "Высота в милиметрах")
    private int height;
}
