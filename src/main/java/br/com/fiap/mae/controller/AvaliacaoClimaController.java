package br.com.fiap.mae.controller;

import br.com.fiap.mae.dto.AvaliacaoClimaDTO;
import br.com.fiap.mae.service.AvaliacaoClimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoClimaController {

    private final AvaliacaoClimaService service;

    @PostMapping("/avaliar")
    public ResponseEntity<Map<String, String>> avaliar(@RequestBody AvaliacaoClimaDTO dto) {

        String risco = service.classificarRisco(dto.getPercentualRisco());
        String cargaTrabalho = service.classificarCargaTrabalho(dto.getPercentualCargaTrabalho());
        String sinaisAlerta = service.classificarSinaisAlerta(dto.getPercentualSinaisAlerta());
        String diagnostico = dto.getDiagnosticoClima();

        Map<String, String> resultado = new HashMap<>();
        resultado.put("Risco", risco);
        resultado.put("Carga de Trabalho", cargaTrabalho);
        resultado.put("Sinais de Alerta", sinaisAlerta);
        resultado.put("Diagnóstico de Clima", diagnostico);

        return ResponseEntity.ok(resultado);
    }
}