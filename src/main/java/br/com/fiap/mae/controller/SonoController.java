package br.com.fiap.mae.controller;

import br.com.fiap.mae.dto.SonoDTO;
import br.com.fiap.mae.model.Sono;
import br.com.fiap.mae.service.SonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/sono")
@RequiredArgsConstructor
public class SonoController {

    private final SonoService service;

    @PostMapping
    public ResponseEntity<Sono> salvar(@RequestBody SonoDTO dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public List<Sono> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public List<Sono> listarPorFuncionario(@PathVariable String funcionarioId) {
        return service.listarPorFuncionario(funcionarioId);
    }

    @GetMapping("/media/{funcionarioId}")
    public Double calcularMedia(
            @PathVariable String funcionarioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        return service.calcularMediaSono(funcionarioId, inicio, fim);
    }
}
