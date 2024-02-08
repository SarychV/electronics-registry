package ru.isands.elreg.model;

import jakarta.persistence.*;
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
public abstract class Model implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;              // Уникальный идентификатор модели

    @Column(name = "product_id")
    protected long productId;       // Уникальный идентификатор продукта, к которому относится модель

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    protected Category productCategory;     // Категория изделия (телевизор, холодильник, пылесос и т.д.)

    private String name;            // Наименование

    @Column(name = "ser_num")
    private String serialNumber;    // Серийный номер

    private String colour;          // Цвет

    private Size size;              // Размер

    private BigDecimal price;       // Цена

    @Column(name = "available")
    private Boolean available;      // Наличие товара

    @Override
    public Model clone() throws CloneNotSupportedException {
        return (Model) super.clone();
    }
}
