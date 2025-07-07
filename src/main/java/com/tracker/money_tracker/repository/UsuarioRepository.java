package com.tracker.money_tracker.repository;

import com.tracker.money_tracker.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
