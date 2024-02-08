package ru.isands.elreg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
    Класс для представления информации о компьютерах.
    Наследует поля класса Model, определяет специфичные атрибуты компьютеров.
 */

@Setter
@Getter
@Entity
@Table(name = "computers")
public class Computer extends Model {
    /*
    Категории компьютеров
    Consumer PC (массовый ПК); Office PC (деловой ПК); Mobile PC (портативный ПК);
    Workstation PC (рабочая станция); Entertainment PC (развлекательный ПК)
     */
    @Column(name = "category")
    private String computerCategory;           // Категория компьютера

    @Column(name = "processor_type")
    private String processorType;      // Тип процессора

    @Override
    public String toString() {
        return "Computer(" + super.toString() +
                String.format(", computerCategory=%s, processorType=%s)", computerCategory, processorType);
    }
}
