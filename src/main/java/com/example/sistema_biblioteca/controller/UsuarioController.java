package com.example.sistema_biblioteca.controller;


import com.example.sistema_biblioteca.model.Usuario;
import com.example.sistema_biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscar(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuarioNovo) {
        return usuarioService.atualizar(id, usuarioNovo);
    }

    @DeleteMapping("/{id}")
    public String deletarUsuarioPorId(@PathVariable Long id) {
        usuarioService.deletar(id);

        return "Usuário deletado com sucesso!";
    }
}
