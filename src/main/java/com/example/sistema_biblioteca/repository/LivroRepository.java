package com.example.sistema_biblioteca.repository;

import com.example.sistema_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
