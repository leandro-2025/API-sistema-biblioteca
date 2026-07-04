package com.example.sistema_biblioteca.controller;

import com.example.sistema_biblioteca.dto.EmprestimoDTO;
import com.example.sistema_biblioteca.dto.EmprestimoResponseDTO;
import com.example.sistema_biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public EmprestimoResponseDTO criarEmprestimos(@RequestBody EmprestimoDTO dto) {
        return emprestimoService.criar(dto);
    }

    @GetMapping
    public List<EmprestimoResponseDTO> listarEmprestimos() {
        return emprestimoService.listar();
    }

    @GetMapping("/{id}")
    public EmprestimoResponseDTO buscarEmprestimosPorId(@PathVariable Long id) {
        return emprestimoService.buscar(id);
    }

    @PutMapping("/{id}/devolver")
    public EmprestimoResponseDTO devolverPorId(@PathVariable Long id) {
        return emprestimoService.devolver(id);
    }

}
