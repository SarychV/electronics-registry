package ru.isands.elreg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
    Класс для представления информации о пылесосах.
    Наследует поля класса Model, определяет специфичные атрибуты пылесосов.
 */

@Setter
@Getter
@Entity
@Table(name = "cleaners")
public class Cleaner extends Model {
    @Column(name = "container_volume")
    private int containerVolume;            // Объем контейнера в милилитрах
    @Column(name = "num_modes")
    private int numModes;                   // Количество режимов

    @Override
    public String toString() {
        return "Cleaner(" + super.toString() + String.format(", containerVolume=%d, numModes=%d)",
                containerVolume , numModes);
    }
}