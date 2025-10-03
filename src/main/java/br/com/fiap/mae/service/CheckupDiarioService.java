package br.com.fiap.mae.service;

import br.com.fiap.mae.dto.CheckupDiarioDTO;
import br.com.fiap.mae.model.CheckupDiario;
import br.com.fiap.mae.repository.CheckupDiarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckupDiarioService {

    private final CheckupDiarioRepository repository;

    public List<CheckupDiario> listarTodos() {
        return repository.findAll();
    }

    public List<CheckupDiario> listarPorFuncionario(String funcionarioId) {
        return repository.findByFuncionarioId(funcionarioId);
    }

    public List<CheckupDiario> buscarPorFuncionarioEData(String funcionarioId, LocalDate data) {
        return repository.findByFuncionarioIdAndData(funcionarioId, data);
    }

    public CheckupDiario salvar(CheckupDiarioDTO dto) {
        CheckupDiario checkup = new CheckupDiario();
        checkup.setFuncionarioId(dto.getFuncionarioId());
        checkup.setData(dto.getData());
        checkup.setMotivacao(dto.getMotivacao());
        checkup.setCansaco(dto.getCansaco());
        checkup.setPreocupacao(dto.getPreocupacao());
        checkup.setEstresse(dto.getEstresse());
        checkup.setAnimacao(dto.getAnimacao());
        checkup.setSatisfacao(dto.getSatisfacao());

        return repository.save(checkup);
    }
}
