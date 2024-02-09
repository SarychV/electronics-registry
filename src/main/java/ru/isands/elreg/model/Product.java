package ru.isands.elreg.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
    Линейка технических средств с информацией о фирме производителе, стране изготовления,
    к какой категории относится техника (например: телевизоры, холодильники, смартфоны и др.),
    есть ли возможность заказать онлайн, приобрести в рассрочку, об имеющихся в наличии моделях.
 */

@Schema(description = "Информация о линейке ТС")
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор линейки ТС. Линейка может быть представлена несколькими моделями")
    private long id;

    @Schema(description = "Категория техники")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Schema(description = "Наименование")
    private String name;

    @Schema(description = "Страна производитель")
    private String country;

    @Schema(description = "Фирма производитель")
    private String producer;

    @Schema(description = "Существует ли возможность заказать онлайн")
    @Column(name = "online_ordering")
    private boolean onlineOrdering;

    @Schema(description = "Можно ли приобрести в рассрочку")
    private boolean installment;

    @Schema(description = "Модели в наличии")
    transient List<Model> availableModels;

}
