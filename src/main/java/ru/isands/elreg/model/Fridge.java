package ru.isands.elreg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
    Класс для представления информации о холодильниках.
    Наследует поля класса Model, определяет специфичные атрибуты холодильников.
 */

@Setter
@Getter
@Entity
@Table(name = "fridges")
public class Fridge extends Model {
    @Column(name = "num_doors")
    private int numDoors;               // Количество дверей

    @Column(name = "compressor_type")
    private String compressorType;      // Тип компрессора

    @Override
    public String toString() {
        return "Fridge(" + super.toString() +
                String.format(", numDoors=%d, compressorType=%s)", numDoors, compressorType);
    }
}

