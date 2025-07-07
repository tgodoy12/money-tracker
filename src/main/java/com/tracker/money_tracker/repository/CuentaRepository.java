package com.tracker.money_tracker.repository;

import com.tracker.money_tracker.model.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
