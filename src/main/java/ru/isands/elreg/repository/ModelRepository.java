package ru.isands.elreg.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Model;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findAllByProductCategory(Category category, Sort sort);

    List<Model> findAllByProductIdIn(List<Long> indexes, Sort sort);
}
