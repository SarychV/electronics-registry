package ru.isands.elreg.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category, Sort sort);
}
