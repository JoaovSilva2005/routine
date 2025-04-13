package com.example.routine.controller;

import com.example.routine.model.Usuario;
import com.example.routine.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        boolean valid = usuarioService.validarLogin(usuario.getNome(), usuario.getSenha());
        if (valid) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"erro\": \"Usuário ou senha inválidos\"}");
        }
    }
}
