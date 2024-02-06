package ru.isands.elreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isands.elreg.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
