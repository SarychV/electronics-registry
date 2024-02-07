package ru.isands.elreg.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
    Линейка технических средств с информацией о фирме производителе, стране изготовления,
    к какой категории относится техника (например: телевизоры, холодильники, смартфоны и др.),
    есть ли возможность заказать онлайн, приобрести в рассрочку, об имеющихся в наличии моделях.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;                    // Идентификатор линейки технических средств
    // Линейка может быть представлена несколькими моделями
    @Enumerated(EnumType.STRING)
    private Category category;          // Категория техники

    private String name;                // Наименование

    private String country;             // Страна производитель

    private String producer;            // Фирма производитель

    @Column(name = "online_ordering")
    private boolean onlineOrdering;             // Существует ли возможность заказать онлайн

    private boolean installment;                // Можно ли приобрести в рассрочку

    transient List<Model> availableModels;      // Модели в наличии

}
