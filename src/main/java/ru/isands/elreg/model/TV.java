package ru.isands.elreg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
    Класс для представления информации о телевизорах.
    Наследует поля класса Model, определяет специфичные атрибуты телевизоров.
 */

@Setter
@Getter
@Entity
@Table(name = "tvs")
public class TV extends Model {
    private String category;        // Категория телевизора

    private String technology;      // Технология

    @Override
    public String toString() {
        return "TV(" + super.toString() + String.format(", category=%s, technology=%s)", category, technology);
    }
}

