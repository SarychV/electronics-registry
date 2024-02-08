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
    @Column(name = "category")
    private String tvCategory;      // Категория телевизора

    private String technology;      // Технология

    @Override
    public String toString() {
        return "TV(" + super.toString() + String.format(", tvCategory=%s, technology=%s)", tvCategory, technology);
    }
}

