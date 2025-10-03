package br.com.fiap.mae.controller;

import br.com.fiap.mae.dto.CheckupDiarioDTO;
import br.com.fiap.mae.model.CheckupDiario;
import br.com.fiap.mae.service.CheckupDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/checkups")
@RequiredArgsConstructor
public class CheckupDiarioController {

    private final CheckupDiarioService service;

    @GetMapping
    public List<CheckupDiario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public List<CheckupDiario> listarPorFuncionario(@PathVariable String funcionarioId) {
        return service.listarPorFuncionario(funcionarioId);
    }

    @GetMapping("/funcionario/{funcionarioId}/data/{data}")
    public List<CheckupDiario> buscarPorFuncionarioEData(
            @PathVariable String funcionarioId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return service.buscarPorFuncionarioEData(funcionarioId, data);
    }

    @PostMapping
    public ResponseEntity<CheckupDiario> salvar(@RequestBody CheckupDiarioDTO dto) {
        CheckupDiario novo = service.salvar(dto);
        return ResponseEntity.status(201).body(novo);
    }
}
