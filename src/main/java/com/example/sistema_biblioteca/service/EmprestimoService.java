package com.example.sistema_biblioteca.service;

import com.example.sistema_biblioteca.dto.EmprestimoDTO;
import com.example.sistema_biblioteca.dto.EmprestimoResponseDTO;
import com.example.sistema_biblioteca.model.Emprestimo;
import com.example.sistema_biblioteca.model.Livro;
import com.example.sistema_biblioteca.model.Usuario;
import com.example.sistema_biblioteca.repository.EmprestimoRepository;
import com.example.sistema_biblioteca.repository.LivroRepository;
import com.example.sistema_biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, UsuarioRepository usuarioRepository, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public List<EmprestimoResponseDTO> listar() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll();

        List<EmprestimoResponseDTO> resposta = new ArrayList<>();

        for (Emprestimo emprestimo : emprestimos){
            resposta.add(converterParaResponse(emprestimo));
        }

        return resposta;
    }

    public EmprestimoResponseDTO buscar(Long id) {
         Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Emprestimo não encontrado!"));

         return converterParaResponse(emprestimo);
    }

    public EmprestimoResponseDTO criar(EmprestimoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));

        Livro livro = livroRepository.findById(dto.getLivroId())
                .orElseThrow(()-> new RuntimeException("Livro não encontrado!"));

        if (!livro.isDisponivel()) {
            throw new RuntimeException("Livro indisponível para empréstimo.");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        emprestimo.setDataEmprestimo(LocalDateTime.now());
        emprestimo.setDataPrevistaDevolucao(LocalDateTime.now().plusDays(7));
        emprestimo.setDataDevolucao(null);

        livro.setDisponivel(false);

        livroRepository.save(livro);

        emprestimo = emprestimoRepository.save(emprestimo);

        return converterParaResponse(emprestimo);
    }

    public EmprestimoResponseDTO devolver(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Emprestimo não encontrado!"));

        if (emprestimo.getDataDevolucao()!= null) {
            throw new RuntimeException("O emprestimo do livro já foi devolvido! ");
        }

        emprestimo.setDataDevolucao(LocalDateTime.now());

        Livro livro = emprestimo.getLivro();

        livro.setDisponivel(true);

        livroRepository.save(livro);
        emprestimoRepository.save(emprestimo);

        return converterParaResponse(emprestimo);
    }

    private EmprestimoResponseDTO converterParaResponse(Emprestimo emprestimo) {

        EmprestimoResponseDTO dto = new EmprestimoResponseDTO();
        dto.setId(emprestimo.getId());
        dto.setUsuario(emprestimo.getUsuario().getNome());
        dto.setLivro(emprestimo.getLivro().getTitulo());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());

        return dto;

    }

    
}
