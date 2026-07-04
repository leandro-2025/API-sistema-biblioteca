package com.example.sistema_biblioteca.service;

import com.example.sistema_biblioteca.model.Livro;
import com.example.sistema_biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public Livro buscar(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
    }

    public Livro atualizar(Long id, Livro livroNovo) {
        Livro livroExistente = livroRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livro não encontrado!"));

        livroExistente.setTitulo(livroNovo.getTitulo());
        livroExistente.setAutor(livroNovo.getAutor());
        livroExistente.setIsbn(livroNovo.getIsbn());
        livroExistente.setDisponivel(false);
        livroExistente.setAnoPublicacao(livroNovo.getAnoPublicacao());

        return livroRepository.save(livroExistente);
    }

    public void deletar(Long id) {
        livroRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livro não encontrado!"));

        livroRepository.deleteById(id);
    }
}
