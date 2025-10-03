package br.com.fiap.mae.controller;

import br.com.fiap.mae.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/relatorio")
@RequiredArgsConstructor
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/{funcionarioId}")
    public ResponseEntity<?> gerarRelatorio(@PathVariable String funcionarioId) {
        Map<String, Object> relatorio = relatorioService.gerarRelatorioFuncionario(funcionarioId);
        return ResponseEntity.ok(relatorio);
    }
}