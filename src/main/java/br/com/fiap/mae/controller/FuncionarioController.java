package br.com.fiap.mae.controller;

import br.com.fiap.mae.dto.FuncionarioDTO;
import br.com.fiap.mae.dto.LoginRequest;
import br.com.fiap.mae.model.Funcionario;
import br.com.fiap.mae.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criar(@RequestBody @Valid FuncionarioDTO dto) {
        FuncionarioDTO criado = service.criarFuncionario(dto);
        return ResponseEntity.ok(criado);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        FuncionarioDTO funcionario = service.login(request.getEmail(), request.getSenha());

        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
        }
    }
}