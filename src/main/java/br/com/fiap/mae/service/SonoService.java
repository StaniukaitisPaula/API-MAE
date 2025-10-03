package br.com.fiap.mae.service;

import br.com.fiap.mae.dto.SonoDTO;
import br.com.fiap.mae.model.Sono;
import br.com.fiap.mae.repository.SonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SonoService {

    private final SonoRepository repository;

    public Sono salvar(SonoDTO dto) {
        Sono sono = new Sono();
        sono.setFuncionarioId(dto.getFuncionarioId());
        sono.setData(dto.getData());
        sono.setHorasDormidas(dto.getHorasDormidas());
        return repository.save(sono);
    }

    public List<Sono> listarTodos() {
        return repository.findAll();
    }

    public List<Sono> listarPorFuncionario(String funcionarioId) {
        return repository.findByFuncionarioId(funcionarioId);
    }

    public Double calcularMediaSono(String funcionarioId, LocalDate inicio, LocalDate fim) {
        List<Sono> registros = repository.findByFuncionarioIdAndDataBetween(funcionarioId, inicio, fim);
        if (registros.isEmpty()) return 0.0;

        double soma = registros.stream().mapToDouble(Sono::getHorasDormidas).sum();
        return soma / registros.size();
    }
}
