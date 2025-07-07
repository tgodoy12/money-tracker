package com.tracker.money_tracker.model.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotBlank String nombre,
        @NotBlank String pais
) {
}
