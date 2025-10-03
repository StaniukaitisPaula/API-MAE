package br.com.fiap.mae.service;

import br.com.fiap.mae.dto.TarefaDTO;
import br.com.fiap.mae.model.Funcionario;
import br.com.fiap.mae.model.Tarefa;
import br.com.fiap.mae.repository.FuncionarioRepository;
import br.com.fiap.mae.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public Tarefa salvar(TarefaDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setPrazo(dto.getPrazo());
        tarefa.setHorasGastas(dto.getHorasGastas());
        tarefa.setFuncionarioId(funcionario.getId());

        return repository.save(tarefa);
    }

    public Double calcularTotalHorasGastas(String funcionarioId) {
        List<Tarefa> lista = repository.findByFuncionarioId(funcionarioId);
        if (lista == null || lista.isEmpty()) return 0.0;

        double soma = 0.0;
        for (Tarefa t : lista) {
            soma += Optional.ofNullable(t.getHorasGastas()).orElse(0.0);
        }
        return soma;
    }

    public boolean ultrapassouLimite(String funcionarioId) {
        return calcularTotalHorasGastas(funcionarioId) > 8.0;
    }
}

