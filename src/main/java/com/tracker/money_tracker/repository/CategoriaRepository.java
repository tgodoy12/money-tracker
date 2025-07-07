package com.tracker.money_tracker.repository;

import com.tracker.money_tracker.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
