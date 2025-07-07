package com.tracker.money_tracker.controller;

import com.tracker.money_tracker.model.DTOs.UsuarioDTO;
import com.tracker.money_tracker.repository.UsuarioRepository;
import com.tracker.money_tracker.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public void registrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        usuarioService.registrar(usuarioDTO);
    }
}

// Crear primer migracion para la creacion de las tablas correspondientes
// probar con el registro del primer usuario y ver que conda el encode del password
// probar el login con un template y thymeleaf