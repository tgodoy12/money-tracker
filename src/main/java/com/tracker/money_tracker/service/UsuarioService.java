package com.tracker.money_tracker.service;

import com.tracker.money_tracker.Exception.UsuarioYaExisteException;
import com.tracker.money_tracker.model.DTOs.UsuarioDTO;
import com.tracker.money_tracker.model.entities.Usuario;
import com.tracker.money_tracker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public void registrar(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsByEmail(usuarioDTO.email())) {
            throw new UsuarioYaExisteException("Ya existe un usuario con el email" + usuarioDTO.email());
        }

        Usuario usuario = new Usuario(usuarioDTO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(new Usuario(usuarioDTO));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            var usuarioEncontrado = usuario.get();
            return User.builder()
                    .username(usuarioEncontrado.getEmail())
                    .password(usuarioEncontrado.getPassword())
                    .roles(usuarioEncontrado.getRol().toString())
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
