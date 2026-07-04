package com.example.sistema_biblioteca.repository;

import com.example.sistema_biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
