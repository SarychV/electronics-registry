package ru.isands.elreg.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/*
    Общие сведения о модели
 */
@Entity
@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "models")
public abstract class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;              // Уникальный идентификатор модели

    @Column(name = "product_id")
    protected long productId;       // Уникальный идентификатор продукта, к которому относится модель

    private String name;            // Наименование

    @Column(name = "ser_num")
    private String serialNumber;    // Серийный номер

    private String colour;          // Цвет

    private Size size;              // Размер

    private BigDecimal price;       // Цена

    @Column(name = "available")
    private boolean isAvailable;    // Наличие товара
}
