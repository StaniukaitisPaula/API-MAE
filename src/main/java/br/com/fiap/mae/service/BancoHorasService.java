package br.com.fiap.mae.service;

import br.com.fiap.mae.dto.BancoHorasDTO;
import br.com.fiap.mae.model.BancoHoras;
import br.com.fiap.mae.repository.BancoHorasRepository;
import br.com.fiap.mae.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BancoHorasService {

    @Autowired
    private BancoHorasRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<BancoHoras> listar() {
        return repository.findAll();
    }

    public BancoHoras salvar(BancoHorasDTO dto) {
        var funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        var bancoHoras = new BancoHoras();
        bancoHoras.setData(dto.getData());
        bancoHoras.setHorasExtras(dto.getHorasExtras());
        bancoHoras.setHorasPagas(dto.getHorasPagas());
        bancoHoras.setFuncionarioId(funcionario.getId());

        return repository.save(bancoHoras);
    }

    public Double calcularSaldoHoras(String funcionarioId) {
        List<BancoHoras> lista = repository.findByFuncionarioId(funcionarioId);
        if (lista == null || lista.isEmpty()) return 0.0;

        double soma = 0.0;
        for (BancoHoras b : lista) {
            double extras = Optional.ofNullable(b.getHorasExtras()).orElse(0.0);
            double pagas = Optional.ofNullable(b.getHorasPagas()).orElse(0.0);
            soma += (extras - pagas);
        }
        return soma;
    }
}
