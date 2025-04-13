package com.example.routine.service;

import com.example.routine.model.Usuario;
import com.example.routine.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarLogin(String nome, String senha) {
        Usuario usuario = usuarioRepository.findByNome(nome);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return true;  // Login válido
        }
        return false;  // Login inválido
    }
}
