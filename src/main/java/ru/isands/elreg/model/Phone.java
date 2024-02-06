package ru.isands.elreg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
    Класс для представления информации о смартфонах.
    Наследует поля класса Model, определяет специфичные атрибуты смартфонов.
 */

@Setter
@Getter
@Entity
@Table(name = "phones")
public class Phone extends Model {
    private int memory;         // Количество памяти в мегабайтах

    @Column(name = "num_cameras")
    private int numCameras;     // Количество камер

    @Override
    public String toString() {
        return "Phone(" + super.toString() + String.format(", memory=%d, numCameras=%d)", memory, numCameras);
    }
}
