package com.example.sistema_biblioteca.controller;

import com.example.sistema_biblioteca.model.Livro;
import com.example.sistema_biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @GetMapping
    public List<Livro> listarLivro() {
        return livroService.listar();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable Long id) {
        return livroService.buscar(id);
    }

    @PutMapping("/{id}")
    public Livro atualizaLivroPorId(@PathVariable Long id, @RequestBody Livro livroNovo) {
        return livroService.atualizar(id, livroNovo);
    }

    @DeleteMapping("/{id}")
    public String deletarLivroPorId(@PathVariable Long id){
        livroService.deletar(id);

        return "Livro deletado com sucesso!";
    }

}
