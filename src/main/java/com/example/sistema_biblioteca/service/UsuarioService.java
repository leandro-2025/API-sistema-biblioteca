package com.example.sistema_biblioteca.service;

import com.example.sistema_biblioteca.model.Usuario;
import com.example.sistema_biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));
    }

    public Usuario atualizar(Long id, Usuario usuarioNovo) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));

        usuarioExistente.setNome(usuarioNovo.getNome());
        usuarioExistente.setEmail(usuarioExistente.getEmail());
        usuarioExistente.setTelefone(usuarioNovo.getTelefone());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletar(Long id) {
        usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));

        usuarioRepository.deleteById(id);
    }
}
