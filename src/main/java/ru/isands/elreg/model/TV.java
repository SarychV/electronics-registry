package ru.isands.elreg.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
    Класс для представления информации о телевизорах.
    Наследует поля класса Model, определяет специфичные атрибуты телевизоров.
 */

@Schema(description = "Дополнительные параметры для телевизоров")
@Setter
@Getter
@Entity
@Table(name = "tvs")
public class TV extends Model {
    @Schema(description = "Категория телевизора")
    @Column(name = "category")
    private String tvCategory;

    @Schema(description = "Технология")
    private String technology;

    @Override
    public String toString() {
        return "TV(" + super.toString() + String.format(", tvCategory=%s, technology=%s)", tvCategory, technology);
    }
}

