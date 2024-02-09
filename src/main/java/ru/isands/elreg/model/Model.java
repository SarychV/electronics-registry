package ru.isands.elreg.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/*
    Общие сведения о модели
 */

@Schema(description = "Информация о модели ТС")
@Entity
@Setter
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "models")
public abstract class Model implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Уникальный идентификатор модели")
    protected long id;

    @Schema(description = "Уникальный идентификатор продукта, к которому относится модель")
    @Column(name = "product_id")
    protected long productId;

    @Schema(description = "Категория изделия (телевизор, холодильник, пылесос и т.д.)")
    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    protected Category productCategory;

    @Schema(description = "Наименование")
    private String name;

    @Schema(description = "Серийный номер")
    @Column(name = "ser_num")
    private String serialNumber;

    @Schema(description = "Цвет")
    private String colour;

    @Schema(description = "Размер")
    private Size size;

    @Schema(description = "Цена")
    private BigDecimal price;

    @Schema(description = "Наличие товара")
    @Column(name = "available")
    private Boolean available;

    @Override
    public Model clone() throws CloneNotSupportedException {
        return (Model) super.clone();
    }
}
