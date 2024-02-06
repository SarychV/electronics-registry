package ru.isands.elreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.elreg.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
