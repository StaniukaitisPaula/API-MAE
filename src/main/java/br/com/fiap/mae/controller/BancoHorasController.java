package br.com.fiap.mae.controller;

import br.com.fiap.mae.dto.BancoHorasDTO;
import br.com.fiap.mae.model.BancoHoras;
import br.com.fiap.mae.service.BancoHorasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/banco-horas")
@RequiredArgsConstructor
public class BancoHorasController {

    @Autowired
    private BancoHorasService service;

    @GetMapping
    public List<BancoHoras> listar() {
        return service.listar();
    }

    @PostMapping
    public BancoHoras salvar(@RequestBody BancoHorasDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/saldo/{funcionarioId}")
    public Double calcularSaldoHoras(@PathVariable String funcionarioId) {
        return service.calcularSaldoHoras(funcionarioId);
    }
}
